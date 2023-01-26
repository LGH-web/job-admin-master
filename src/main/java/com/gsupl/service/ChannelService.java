package com.gsupl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Channel;
import com.gsupl.mapper.ChannelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author LGH
 * @Date 2022/11/14 15:18
 * @Version 1.0
 */
@Service
public class ChannelService {
    @Autowired
    private ChannelMapper channelMapper;

    public int create(Channel channel) {
        return channelMapper.create(channel);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                channelMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return channelMapper.delete(id);
    }

    public int update(Channel channel) {
        return channelMapper.update(channel);
    }

    public PageInfo<Channel> query(Channel channel) {
        if (channel != null && channel.getPage() != null) {
            PageHelper.startPage(channel.getPage(), channel.getLimit());
        }
        return new PageInfo<>(channelMapper.query(channel));
    }

    public List<Channel> tree(Channel channel) {
        return channelMapper.query(channel);
    }

    public Channel detail(Integer id) {
        return channelMapper.detail(id);
    }

    public int count(Channel channel) {
        return channelMapper.count(channel);
    }
}
