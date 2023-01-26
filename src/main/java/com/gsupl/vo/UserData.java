package com.gsupl.vo;

import lombok.Data;

/**
 * @Author LGH
 * @Date 2022/11/14 14:59
 * @Version 1.0
 */
@Data
public class UserData {
    private Integer id;
    private String account;
    private String name;
    private Integer type;
    private String token;

}
