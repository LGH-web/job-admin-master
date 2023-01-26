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
public class Train extends Entity {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private String company;
    private String course;
    private Integer resumeId;
    private Resume resume;

}
