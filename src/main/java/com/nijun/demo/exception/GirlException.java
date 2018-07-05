package com.nijun.demo.exception;

import com.nijun.demo.enums.ResultEnum;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/5
 * Time: 8:14 AM
 * description: 只有RuntimeException才会进行事务回滚
 */
public class GirlException extends RuntimeException{

    private  Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
