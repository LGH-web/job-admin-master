package com.gsupl.framework.exception;

import com.gsupl.utils.Result;
import com.gsupl.utils.Status;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author LGH
 * @Date 2022/11/14 22:34
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(TokenException.class)
    @ResponseBody
    public Result handle(TokenException tokenException) {
        tokenException.printStackTrace();
        return Result.error(Status.TOKEN_ERROR.getCode(), Status.TOKEN_ERROR.getMsg());
    }

    @ExceptionHandler(NoAuthException.class)
    @ResponseBody
    public Result handle(NoAuthException noAuthException) {
        noAuthException.printStackTrace();
        return Result.error(Status.NO_AUTH.getCode(), Status.NO_AUTH.getMsg());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result handle(Exception e) {
        e.printStackTrace();
        return Result.error("操作失败");
    }
}
