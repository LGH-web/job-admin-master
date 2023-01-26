package com.gsupl.controller;

import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Company;
import com.gsupl.framework.redis.RedisUtil;
import com.gsupl.framework.role.RequiresRoles;
import com.gsupl.framework.role.Role;
import com.gsupl.service.CompanyService;
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
 * @Date 2022/11/14 15:21
 * @Version 1.0
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/create")
    public Result create(@RequestBody Company company) {
        int flag = companyService.create(company);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = companyService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Company company) {
        int flag = companyService.update(company);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/updateSelective")
    public Result updateSelective(@RequestBody Company company){
        int flag = companyService.updateSelective(company);
        if (flag>0){
            return Result.success();
        }else {
            return Result.error();
        }

    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(companyService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Company company) {
        PageInfo<Company> pageInfo = companyService.query(company);
        return Result.success(pageInfo);
    }

    @PostMapping("/info")
    @RequiresRoles(type = Role.COMPANY)
    public Result info() {
        //获取登录用户的信息
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        return Result.success(companyService.detail(userData.getId()));
    }


}
