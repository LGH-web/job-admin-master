package com.gsupl.service;

import com.gsupl.entity.Menu;
import com.gsupl.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author LGH
 * @Date 2022/11/14 16:00
 * @Version 1.0
 */
@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    public int create(Menu menu) {
        return menuMapper.create(menu);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                menuMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return menuMapper.delete(id);
    }

    public int update(Menu menu) {
        return menuMapper.update(menu);
    }

    public List<Menu> query(Menu menu) {
        return menuMapper.query(menu);
    }

    public Menu detail(Integer id) {
        return menuMapper.detail(id);
    }

    public int count(Menu menu) {
        return menuMapper.count(menu);
    }
}
