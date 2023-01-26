package com.gsupl.controller;

import com.github.pagehelper.PageInfo;
import com.gsupl.entity.UserMenu;
import com.gsupl.service.UserMenuService;
import com.gsupl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author LGH
 * @Date 2022/11/14 16:18
 * @Version 1.0
 */
@RestController
@RequestMapping("/userMenu")
public class UserMenuController {
    @Autowired
    private UserMenuService userMenuService;

    @PostMapping("/create")
    public Result create(@RequestBody UserMenu userMenu) {
        int flag = userMenuService.create(userMenu);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = userMenuService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody UserMenu userMenu) {
        int flag = userMenuService.update(userMenu);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(userMenuService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody UserMenu userMenu) {
        PageInfo<UserMenu> pageInfo = userMenuService.query(userMenu);
        return Result.success(pageInfo);
    }

}
