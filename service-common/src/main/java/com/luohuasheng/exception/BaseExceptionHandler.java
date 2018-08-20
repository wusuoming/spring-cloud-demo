package com.luohuasheng.exception;

import com.luohuasheng.convert.BaseResult;
import com.luohuasheng.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class BaseExceptionHandler {

    @Autowired
    private MessageSource messageSource;


    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResult> handleHWException(BaseException e) {
        BaseResult resultVO = new BaseResult();
        resultVO.setCode(e.getCode());
        resultVO.setMsg(messageSource.getMessage(e.getCode(), e.getArgs(), e.getMessage(), ServletUtils.request().getLocale()));
        return new ResponseEntity<>(resultVO, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResult> defaultErrorHandler(Exception e) {
        e.printStackTrace();
        BaseResult resultVO = new BaseResult();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            status = HttpStatus.NOT_FOUND;
            resultVO.setCode(String.valueOf(status.value()));
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            resultVO.setCode(String.valueOf(status.value()));
            resultVO.setMsg(e.getMessage());
        } else {
            resultVO.setCode(String.valueOf(status.value()));
        }
        resultVO.setMsg(messageSource.getMessage(resultVO.getCode(), null, e.getMessage(), ServletUtils.request().getLocale()));

        return new ResponseEntity<>(resultVO, status);
    }
}
