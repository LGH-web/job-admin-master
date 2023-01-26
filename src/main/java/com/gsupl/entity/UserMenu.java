package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

/**
 * @Author LGH
 * @Date 2022/11/10 16:01
 * @Version 1.0
 */
@Data
public class UserMenu extends Entity {
    private Integer userId;
    private Integer menuId;
}
