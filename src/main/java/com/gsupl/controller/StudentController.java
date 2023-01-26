package com.gsupl.controller;

import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Student;
import com.gsupl.framework.redis.RedisUtil;
import com.gsupl.framework.role.RequiresRoles;
import com.gsupl.framework.role.Role;
import com.gsupl.service.StudentService;
import com.gsupl.utils.Result;
import com.gsupl.utils.UserThreadLocal;
import com.gsupl.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author LGH
 * @Date 2022/11/14 16:11
 * @Version 1.0
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/create")
    public Result create(@RequestBody Student student) {
        int flag = studentService.create(student);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = studentService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Student student) {
        int flag = studentService.update(student);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @RequestMapping("/updateSelective")
    public Result updateSelective(@RequestBody Student student){
        int flag = studentService.updateSelective(student);
        if (flag>0){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(studentService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Student student) {
        PageInfo<Student> pageInfo = studentService.query(student);
        return Result.success(pageInfo);
    }

    @PostMapping("info")
    @RequiresRoles(type = Role.STUDENT)
    public Result info(){
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        return  Result.success(studentService.detail(userData.getId()));
    }
}
