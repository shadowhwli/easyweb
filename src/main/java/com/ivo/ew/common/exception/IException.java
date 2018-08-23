package com.ivo.ew.common.exception;

/**
 * 自定义异常基类
 *
 * @author wangjian
 * @date 2018/8/13
 */
public abstract class IException extends RuntimeException {
    private static final long serialVersionUID = -1582874427218948396L;
    private Integer code;

    public IException() {
    }

    public IException(String message) {
        super(message);
    }

    public IException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

