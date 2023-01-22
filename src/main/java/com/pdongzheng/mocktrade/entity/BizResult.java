package com.pdongzheng.mocktrade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BizResult<T> {

    private int code;
    private String message;
    private T data;

    public static BizResult ofSuccess(Object data) {
        return new BizResult(0000, "success", data);
    }

    public static BizResult ofFailure(String message) {
        return new BizResult(-1, message, null);
    }
}
