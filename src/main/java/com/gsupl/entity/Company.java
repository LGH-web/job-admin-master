package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

/**
 * @Author LGH
 * @Date 2022/11/10 15:51
 * @Version 1.0
 */
@Data
public class Company  extends Entity {
    private Integer id;
    private String name;
    private String account;
    private String password;
    private String contact;
    private String telephone;
    private String email;
    private String addr;
    private String url;
    private String size;
    private String type;
    private String logo;
    private String description;
    private Integer status;

}
