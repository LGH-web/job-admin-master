package com.gsupl.controller;

import com.gsupl.entity.Company;
import com.gsupl.entity.Student;
import com.gsupl.entity.User;
import com.gsupl.framework.redis.RedisUtil;
import com.gsupl.framework.role.Role;
import com.gsupl.service.CompanyService;
import com.gsupl.service.StudentService;
import com.gsupl.service.UserService;
import com.gsupl.utils.Result;
import com.gsupl.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

/**
 * @Author LGH
 * @Date 2022/11/14 15:55
 * @Version 1.0
 */
@RestController

public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public Result login(@RequestBody Map<String,String> map) {
        String account = map.get("account");
        String password = map.get("password");
        String type = map.get("type");
        String msg= "用户或密码错误";

        boolean flag = false;
        UserData userData = new UserData();

        if(Role.ADMIN.getCode().equals(Integer.parseInt(type))) {
            //管理员登录
            User user = userService.login(account, password);
            if(user != null) {
                flag = true;
                userData.setId(user.getId());
                userData.setAccount(user.getUserName());
                userData.setName(user.getName());
                userData.setType(Role.ADMIN.getCode());
            }
        }
        if(String.valueOf(Role.COMPANY.getCode()).equals(type)) {
            //企业登录
            Company company = companyService.login(account, password);
            if(company != null){
                if(company.getStatus() ==0){
                    msg = "账号审批中，请等待";
                }else if(company.getStatus() ==2){
                    msg = "审批未通过，请与管理员沟通";
                }else{
                    userData.setId(company.getId());
                    userData.setAccount(company.getAccount());
                    userData.setName(company.getName());
                    userData.setType(Role.COMPANY.getCode());
                    flag = true;
                }
            }
        }
        if(Role.STUDENT.getCode().equals(Integer.parseInt(type))) {
            //学生登录
            Student student = studentService.login(account, password);
            if(student != null) {
                flag = true;
                userData.setId(student.getId());
                userData.setAccount(student.getAccount());
                userData.setName(student.getName());
                userData.setType(Role.STUDENT.getCode());
            }
        }

        if(flag) {
            //登录成功
            //1、生成token
            String token = UUID.randomUUID().toString();
            //2、存入redis
            userData.setToken(token);
            redisUtil.set(token, userData, RedisUtil.EXPR);
            //3、响应数据
            return Result.success(userData);
        } else {
            return Result.error(msg);
        }
    }
}
