package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

import java.util.Date;

/**
 * @Author LGH
 * @Date 2022/11/10 15:59
 * @Version 1.0
 */
@Data
public class Send extends Entity {
    private Integer id;
    private Integer companyId;
    private Integer postId;
    private Integer resumeId;
    private Date sendDate;
    private Integer status; // 0待查看|1已查看|2有意向|3不合适
    private Integer studentId;

    private Company company;
    private Student student;
    private Post post;
    private Resume resume;

}
