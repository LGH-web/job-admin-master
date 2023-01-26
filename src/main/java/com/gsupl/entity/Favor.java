package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

import java.util.Date;

/**
 * @Author LGH
 * @Date 2022/11/10 15:54
 * @Version 1.0
 */
@Data
public class Favor extends Entity {
    private Integer id;
    private Integer companyId;
    private Integer postId;
    private Integer studentId;
    private Date favorDate;

    private Post post;
    private Company company;
    private Student student;

}
