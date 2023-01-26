package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

import java.util.Date;

/**
 * @Author LGH
 * @Date 2022/11/10 15:46
 * @Version 1.0
 */
@Data
public class Certificate extends Entity {
    private Integer id;
    private String name;
    private String file;
    private Date obtainDate;
    private Integer resumeId;
    private Resume resume;

}
