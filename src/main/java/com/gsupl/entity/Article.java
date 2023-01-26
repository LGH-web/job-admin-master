package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

import java.util.Date;

/**
 * @Author LGH
 * @Date 2022/11/10 15:39
 * @Version 1.0
 */
@Data
public class Article extends Entity {
    private Integer id;
    private Integer channelId;
    private String title;
    private String titleImg;
    private String summary;
    private String author;
    private String url;
    private String content;
    private Integer sort;
    private Date createDate;
    private Integer createUser;
    private Date updateDate;
    private Integer views; //浏览量

}
