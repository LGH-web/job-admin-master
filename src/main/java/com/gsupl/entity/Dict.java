package com.gsupl.entity;

import com.gsupl.utils.Entity;
import lombok.Data;

/**
 * @Author LGH
 * @Date 2022/11/10 15:51
 * @Version 1.0
 */
@Data
public class Dict extends Entity {
    private Integer id;
    private String dictKey;
    private String dictVal;
    private Integer sort;
    private Integer status; // 0正常|1删除
    private Integer typeId;

}
