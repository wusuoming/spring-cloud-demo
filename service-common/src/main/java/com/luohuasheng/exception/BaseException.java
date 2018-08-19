package com.luohuasheng.exception;


/**
 * @author panda
 */
public class BaseException extends RuntimeException {

    private String code;

    private Object[] args;

    private BaseException(String defaultMessage) {
        super(defaultMessage);
    }

    private BaseException() {
        super();
    }

    public static BaseException create(String code, String defaultMessage, Object... args) {
        BaseException baseException = new BaseException(defaultMessage);
        baseException.setCode(code);
        baseException.setArgs(args);
        return baseException;
    }

    public static BaseException create(String code, String defaultMessage) {
        BaseException baseException = new BaseException(defaultMessage);
        baseException.setCode(code);
        return baseException;
    }

    public static BaseException create(String code, Object... args) {
        BaseException baseException = new BaseException();
        baseException.setCode(code);
        baseException.setArgs(args);
        return baseException;
    }

    public static BaseException create(String code) {
        BaseException baseException = new BaseException();
        baseException.setCode(code);
        return baseException;
    }

    String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }


    Object[] getArgs() {
        return args;
    }

    private void setArgs(Object[] args) {
        this.args = args;
    }
}