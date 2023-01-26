package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

import java.util.Date;

/**
 * @Author LGH
 * @Date 2022/11/10 15:58
 * @Version 1.0
 */
@Data
public class Project extends Entity {
    private Integer id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Integer resumeId;

    private Resume resume;

}
