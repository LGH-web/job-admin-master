package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

/**
 * @Author LGH
 * @Date 2022/11/10 15:57
 * @Version 1.0
 */
@Data
public class Profession extends Entity {
    private Integer id;
    private String name;
    private Integer parentId;
}
