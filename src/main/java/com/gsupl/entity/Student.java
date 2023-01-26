package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

import java.util.Date;

/**
 * @Author LGH
 * @Date 2022/11/10 15:55
 * @Version 1.0
 */
@Data
public class Student extends Entity {
    private Integer id;
    private String name;
    private String account;
    private String password;
    private Date birthday;
    private Integer professionId;
    private String college;
    private String education;
    private String phone;
    private String sex;
    private String photo;
    private Date graduateDate;
}
