package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

/**
 * @Author LGH
 * @Date 2022/11/10 15:57
 * @Version 1.0
 */
@Data
public class Menu extends Entity {
    private Integer id;
    private String name;
    private String icon;
    private String href;
    private String perms;
    private Integer parentId;
    private Integer type; // 0管理员|1企业|2学生

}
