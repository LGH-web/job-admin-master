package com.gsupl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Type;
import com.gsupl.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author LGH
 * @Date 2022/11/14 16:15
 * @Version 1.0
 */
@Service
public class TypeService {
    @Autowired
    private TypeMapper typeMapper;

    public int create(Type type) {
        return typeMapper.create(type);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                typeMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return typeMapper.delete(id);
    }

    public int update(Type type) {
        return typeMapper.update(type);
    }

    public PageInfo<Type> query(Type type) {
        if (type != null && type.getPage() != null) {
            PageHelper.startPage(type.getPage(), type.getLimit());
        }
        return new PageInfo<>(typeMapper.query(type));
    }

    public Type detail(Integer id) {
        return typeMapper.detail(id);
    }

    public int count(Type type) {
        return typeMapper.count(type);
    }
}
