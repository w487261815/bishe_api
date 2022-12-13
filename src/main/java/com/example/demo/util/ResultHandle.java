package com.example.demo.util;

import org.springframework.util.StringUtils;

public class ResultHandle {
    private static final String SUCCESS_MESSAGE = "SUCCESS";
    private static final String ERROR_MESSAGE = "FAIL";
    private static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE = 500;
    public static Result getSuccessResult() {
        Result result = new Result();
        result.setResultCode(SUCCESS_CODE);
        result.setMessage(SUCCESS_MESSAGE);
        return result;
    }
    public static Result getSuccessResult(String message) {
        Result result = new Result();
        result.setResultCode(SUCCESS_CODE);
        result.setMessage(message);
        return result;
    }
    public static Result getSuccessResult(Object data) {
        Result result = new Result();
        result.setResultCode(SUCCESS_CODE);
        result.setMessage(SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }
    public static Result getSuccessResult(Object data,String message) {
        Result result = new Result();
        result.setResultCode(SUCCESS_CODE);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    public static Result getFailResult(String message) {
        Result result = new Result();
        result.setResultCode(ERROR_CODE);
        if (StringUtils.isEmpty(message)) {
            result.setMessage(ERROR_MESSAGE);
        } else {
            result.setMessage(message);
        }
        return result;
    }

    public static Result getFailResult(int code, String message) {
        Result result = new Result();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }

}
