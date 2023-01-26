package com.gsupl.controller;

import com.github.pagehelper.PageInfo;
import com.gsupl.entity.User;
import com.gsupl.framework.role.RequiresRoles;
import com.gsupl.framework.role.Role;
import com.gsupl.service.UserService;
import com.gsupl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author LGH
 * @Date 2022/11/14 16:17
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Result create(@RequestBody User user) {
        int row = userService.create(user);
        if (row > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int row = userService.delete(ids);
        if (row > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        int row = userService.update(user);
        if (row > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/query")
    @RequiresRoles(type = Role.ADMIN)
    public Map<String, Object> query(@RequestBody User user) {
        PageInfo<User> pageInfo = userService.query(user);
        return Result.success(pageInfo);
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        User user = userService.detail(id);
        return Result.success(user);
    }
}
