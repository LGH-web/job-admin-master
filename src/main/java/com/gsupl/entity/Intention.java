package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

/**
 * @Author LGH
 * @Date 2022/11/10 15:55
 * @Version 1.0
 */
@Data
public class Intention extends Entity {
    private Integer id;
    private String name;
    private String salary;
    private String city;
    private String type;
    private String industry;
    private Integer resumeId;

    private Resume resume;
}
