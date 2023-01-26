package com.gsupl.controller;

import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Type;
import com.gsupl.service.TypeService;
import com.gsupl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author LGH
 * @Date 2022/11/14 16:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @PostMapping("/create")
    public Result create(@RequestBody Type type) {
        int flag = typeService.create(type);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = typeService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Type type) {
        int flag = typeService.update(type);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(typeService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Type type) {
        PageInfo<Type> pageInfo = typeService.query(type);
        return Result.success(pageInfo);
    }

}
