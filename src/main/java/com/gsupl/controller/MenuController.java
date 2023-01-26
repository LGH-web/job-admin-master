package com.gsupl.controller;

import com.gsupl.entity.Menu;
import com.gsupl.service.MenuService;
import com.gsupl.service.UserDataService;
import com.gsupl.utils.Result;
import com.gsupl.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author LGH
 * @Date 2022/11/14 15:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private UserDataService userDataService;

    @PostMapping("/create")
    public Result create(@RequestBody Menu menu) {
        int flag = menuService.create(menu);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = menuService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Menu menu) {
        int flag = menuService.update(menu);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(menuService.detail(id));
    }

    @PostMapping("/query")
    public Result query() {
        Menu menu = new Menu();
        //获取当前登录用户的用户信息（从redis中获取）
        UserData userData = userDataService.getUser();
        if(userData != null) {
            menu.setType(userData.getType());
            List<Menu> list = menuService.query(menu);
            return Result.success(list);
        } else {
            return Result.error();
        }
    }
}
