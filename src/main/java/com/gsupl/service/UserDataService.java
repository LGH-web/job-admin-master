package com.gsupl.service;

import com.gsupl.framework.exception.TokenException;
import com.gsupl.framework.redis.RedisUtil;
import com.gsupl.utils.Status;
import com.gsupl.utils.UserThreadLocal;
import com.gsupl.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author LGH
 * @Date 2022/11/14 15:08
 * @Version 1.0
 */
@Service
public class UserDataService {
    @Autowired
    private RedisUtil redisUtil;

    public UserData getUser() {
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        if(userData != null) {
            return userData;
        } else {
            throw new TokenException(Status.TOKEN_ERROR.getMsg());
        }
    }
}
