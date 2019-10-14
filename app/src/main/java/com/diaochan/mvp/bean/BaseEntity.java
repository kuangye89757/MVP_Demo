package com.diaochan.mvp.bean;

public class BaseEntity {
    private int code;
    private boolean success;
    private String error;

    public int getCode() {
        return code;
    }

    public BaseEntity setCode(int code) {
        this.code = code;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public BaseEntity setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getError() {
        return error;
    }

    public BaseEntity setError(String error) {
        this.error = error; 
        return this;
    }
}
