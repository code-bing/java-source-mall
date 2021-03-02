package io.dobson.rpcx.exception;

import javax.servlet.http.HttpServletRequest;

import io.dobson.rpcx.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = GlobalException.class)
    public CommonResult<String> globalExceptionHandler(HttpServletRequest request, GlobalException e) {
        log.error(e.getErrorCode().getMsg());
        return CommonResult.error(e.getErrorCode());
    }
}
