package com.gsupl.controller;

import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Profession;
import com.gsupl.service.ProfessionService;
import com.gsupl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LGH
 * @Date 2022/11/14 16:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/profession")
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;

    @PostMapping("/create")
    public Result create(@RequestBody Profession profession) {
        if(profession.getParentId() == null) {
            profession.setParentId(0);
        }
        int flag = professionService.create(profession);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = professionService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Profession profession) {
        int flag = professionService.update(profession);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(professionService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Profession profession) {
        PageInfo<Profession> pageInfo = professionService.query(profession);
        return Result.success(pageInfo);
    }

    @PostMapping("/tree")
    public Result tree() {
        List<Profession> list = professionService.tree();
        //??????????????????????????? {id:1, label:'1-1', children:'xxx'}
        List<Map<String,Object>> mapList = new ArrayList<>();
        //??????????????????
        list.forEach(profession -> {
            if(profession.getParentId() == 0) {
                Map<String,Object> map = new HashMap<>();
                map.put("id", profession.getId());
                map.put("label", profession.getName());
                map.put("parentId", profession.getParentId());
                //??????children
                map.put("children", children(profession.getId(), list));
                mapList.add(map);
            }
        });
        return Result.success(mapList);
    }

    public List<Map<String,Object>> children(int id, List<Profession> list) {
        List<Map<String,Object>> children = new ArrayList<>();
        for (Profession profession : list) {
            if(profession.getParentId() == id) {
                Map<String,Object> map = new HashMap<>();
                map.put("id", profession.getId());
                map.put("label", profession.getName());
                map.put("parentId", profession.getParentId());
                children.add(map);
            }
        }
        return children;
    }
}
