package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

import java.util.Date;

/**
 * @Author LGH
 * @Date 2022/11/10 16:01
 * @Version 1.0
 */
@Data
public class User extends Entity {
    private Integer id;
    private String userName;
    private String name;
    private String password;
    private Date loginTime;
}
