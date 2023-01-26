package com.gsupl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Send;
import com.gsupl.mapper.SendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author LGH
 * @Date 2022/11/14 16:10
 * @Version 1.0
 */
@Service
public class SendService {
    @Autowired
    private SendMapper sendMapper;

    public int create(Send send) {
        return sendMapper.create(send);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                sendMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return sendMapper.delete(id);
    }

    public int update(Send send) {
        return sendMapper.update(send);
    }

    public PageInfo<Send> query(Send send) {
        if (send != null && send.getPage() != null) {
            PageHelper.startPage(send.getPage(), send.getLimit());
        }
        return new PageInfo<>(sendMapper.query(send));
    }

    public Send detail(Integer id) {
        return sendMapper.detail(id);
    }

    public int count(Send send) {
        return sendMapper.count(send);
    }

    public int updateStatus(Send send) {
        return sendMapper.updateStatus(send);
    }

    public int updateSelective(Send send) {
        return sendMapper.updateSelective(send);
    }

}
