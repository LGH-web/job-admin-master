package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

/**
 * @Author LGH
 * @Date 2022/11/10 15:48
 * @Version 1.0
 */
@Data
public class Resume extends Entity {

    private Integer id;
    private String name;
    private String jobStatus;
    private String evaluate;
    private String skill;
    private Integer studentId;
    private Integer status; // 0关闭|1开放
}
