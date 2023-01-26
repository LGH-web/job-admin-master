package com.gsupl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Favor;
import com.gsupl.mapper.FavorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author LGH
 * @Date 2022/11/14 15:46
 * @Version 1.0
 */
@Service
public class FavorService {
    @Autowired
    private FavorMapper favorMapper;

    public int create(Favor favor) {
        return favorMapper.create(favor);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                favorMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return favorMapper.delete(id);
    }

    public int update(Favor favor) {
        return favorMapper.update(favor);
    }

    public PageInfo<Favor> query(Favor favor) {
        if (favor != null && favor.getPage() != null) {
            PageHelper.startPage(favor.getPage(), favor.getLimit());
        }
        return new PageInfo<>(favorMapper.query(favor));
    }

    public Favor detail(Integer id) {
        return favorMapper.detail(id);
    }

    public int count(Favor favor) {
        return favorMapper.count(favor);
    }
}
