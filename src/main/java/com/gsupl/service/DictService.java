package com.gsupl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Dict;
import com.gsupl.mapper.DictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author LGH
 * @Date 2022/11/14 15:34
 * @Version 1.0
 */
@Service
public class DictService {
    @Autowired
    private DictMapper dictMapper;

    public int create(Dict dict) {
        return dictMapper.create(dict);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                dictMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return dictMapper.delete(id);
    }

    public int update(Dict dict) {
        return dictMapper.update(dict);
    }

    public PageInfo<Dict> query(Dict dict) {
        if (dict != null && dict.getPage() != null) {
            PageHelper.startPage(dict.getPage(), dict.getLimit());
        }
        return new PageInfo<>(dictMapper.query(dict));
    }

    public Dict detail(Integer id) {
        return dictMapper.detail(id);
    }

    public int count(Dict dict) {
        return dictMapper.count(dict);
    }

}
