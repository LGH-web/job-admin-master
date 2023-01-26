package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

import java.util.Date;

/**
 * @Author LGH
 * @Date 2022/11/10 15:52
 * @Version 1.0
 */
@Data
public class Experience extends Entity {
    private Integer id;
    private String company;
    private String post;
    private String salary;
    private String description;
    private Date joinDate;
    private Date leaveDate;
    private Integer resumeId;

    private Resume resume;


}
