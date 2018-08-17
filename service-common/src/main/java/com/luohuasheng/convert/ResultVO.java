package com.luohuasheng.convert;

/**
 * @author panda
 */
public class ResultVO<T> extends BaseResult {


    /**
     * 结果内容
     */
    private T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}