package com.luohuasheng.exception;

import com.luohuasheng.convert.BaseResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResult> handleHWException(BaseException e) {
        BaseResult resultVO = new BaseResult();
        resultVO.setCode(e.getCode());
        return new ResponseEntity<>(resultVO, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResult> defaultErrorHandler(Exception e) {
        BaseResult resultVO = new BaseResult();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            status = HttpStatus.NOT_FOUND;
            resultVO.setCode(String.valueOf(status.value()));
        } else {
            resultVO.setCode(String.valueOf(status.value()));

        }
        return new ResponseEntity<>(resultVO,status);
    }
}
