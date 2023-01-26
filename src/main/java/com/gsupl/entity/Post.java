package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

/**
 * @Author LGH
 * @Date 2022/11/10 15:54
 * @Version 1.0
 */
@Data
public class Post extends Entity {
    private Integer id;
    private String name;
    private String education;
    private String salary;
    private String description;
    private Integer companyId;
}
