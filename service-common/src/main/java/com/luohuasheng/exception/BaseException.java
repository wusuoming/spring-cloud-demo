package com.luohuasheng.exception;


/**
 * @author panda
 */
public class BaseException extends RuntimeException {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}