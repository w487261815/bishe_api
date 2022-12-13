package com.example.demo.common;

public enum ServiceResultEnum {
    NOT_LOGIN_ERROR("未登录！"),
    ADMIN_NOT_LOGIN_ERROR("管理员未登录！"),
    TOKEN_EXPIRE_ERROR("无效认证！请重新登录！"),
    ADMIN_TOKEN_EXPIRE_ERROR("管理员登录过期！请重新登录！");

    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
