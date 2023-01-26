package com.gsupl.controller;

import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Channel;
import com.gsupl.framework.redis.RedisUtil;
import com.gsupl.service.ChannelService;
import com.gsupl.utils.Result;
import com.gsupl.utils.UserThreadLocal;
import com.gsupl.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Author LGH
 * @Date 2022/11/14 15:17
 * @Version 1.0
 */
@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/create")
    public Result create(@RequestBody Channel channel) {
        //获取登录用户的信息
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        //设置一些属性
        channel.setCreateDate(new Date());
        channel.setCreateUser(userData.getId());
        int flag = channelService.create(channel);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/delete")
    public Result delete(String ids) {
        int flag = channelService.delete(ids);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Channel channel) {
        int flag = channelService.update(channel);
        if (flag > 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        return Result.success(channelService.detail(id));
    }

    @PostMapping("/query")
    public Map<String, Object> query(@RequestBody Channel channel) {
        PageInfo<Channel> pageInfo = channelService.query(channel);
        return Result.success(pageInfo);
    }

    @GetMapping("tree")
    public Result tree() {
        List<Channel> list = channelService.tree(null);
        List<Map<String, Object>> mapList = new ArrayList<>();
        list.forEach(channel -> {
            if (channel.getParentId() == 0) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", channel.getId());
                map.put("label", channel.getName());
                if (isChildren(channel.getId(), list)) {
                    map.put("children", children(channel.getId(), list));
                }
                mapList.add(map);
            }
        });
        return Result.success(mapList);
    }

    //如何支持多级：递归
    public List<Map<String, Object>> children(int id, List<Channel> list) {
        List<Map<String, Object>> children = new ArrayList<>();
        for (Channel channel : list) {
            if (channel.getParentId() == id) {
                Map<String, Object> map = new HashMap();
                map.put("id", channel.getId());
                map.put("label", channel.getName());
                if (isChildren(channel.getId(), list)) {//出口
                    map.put("children", children(channel.getId(), list));
                }
                children.add(map);
            }
        }
        return children;
    }

    public boolean isChildren(int id, List<Channel> list) {
        boolean flag = false;
        for (Channel channel : list) {
            if (channel.getParentId() == id) {
                flag = true;
            }
        }
        return flag;
    }

}
