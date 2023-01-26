package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

import java.util.Date;

/**
 * @Author LGH
 * @Date 2022/11/10 15:49
 * @Version 1.0
 */
@Data
public class Channel  extends Entity {
    private Integer id;
    private String name;
    private Integer parentId;
    private String channelImg;
    private String summary;
    private String single; // Y单页|其他非单页
    private String url;
    private String content;
    private Integer sort;
    private Date createDate;
    private Integer createUser;
    private String deletedFlag;
    private Integer postion;

}
