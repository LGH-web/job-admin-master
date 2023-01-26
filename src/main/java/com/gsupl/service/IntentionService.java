package com.gsupl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gsupl.entity.Intention;
import com.gsupl.mapper.IntentionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author LGH
 * @Date 2022/11/14 15:54
 * @Version 1.0
 */
@Service
public class IntentionService {
    @Autowired
    private IntentionMapper intentionMapper;

    public int create(Intention intention) {
        return intentionMapper.create(intention);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                intentionMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return intentionMapper.delete(id);
    }

    public int update(Intention intention) {
        return intentionMapper.update(intention);
    }

    public PageInfo<Intention> query(Intention intention) {
        if (intention != null && intention.getPage() != null) {
            PageHelper.startPage(intention.getPage(), intention.getLimit());
        }
        return new PageInfo<>(intentionMapper.query(intention));
    }

    public Intention detail(Integer id) {
        return intentionMapper.detail(id);
    }

    public int count(Intention intention) {
        return intentionMapper.count(intention);
    }
}
