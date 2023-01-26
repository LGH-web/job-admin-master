package com.gsupl.framework.role;


import java.lang.annotation.*;

/**
 * @Author LGH
 * @Date 2022/11/14 15:23
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequiresRoles {
    Role type();

}
