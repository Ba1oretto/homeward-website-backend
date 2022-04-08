package com.homeward.website.bean.VO;


import com.homeward.website.enums.BaseEnum;
import com.homeward.website.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R implements Serializable {
    private Integer status;
    private String message;
    private Object data;

    private static R resultSet(Integer status, String message, Object data) {
        R res = new R();
        res.setStatus(status);
        res.setMessage(message);
        res.setData(data);
        return res;
    }

    public static R ok() {
        return resultSet(200, "ok", null);
    }

    public static R ok(String message) {
        return resultSet(StatusEnum.SUCCESS.getCode(), message, null);
    }

    public static R ok(Object data) {
        return resultSet(StatusEnum.SUCCESS.getCode(), StatusEnum.SUCCESS.getMessage(), data);
    }

    public static R ok(String message, Object data) {
        return resultSet(StatusEnum.SUCCESS.getCode(), message, data);
    }

    public static R no() {
        return resultSet(StatusEnum.FAILURE.getCode(), StatusEnum.FAILURE.getMessage(), null);
    }

    public static R no(String message) {
        return resultSet(StatusEnum.FAILURE.getCode(), message, null);
    }

    public static R no(Object data) {
        return resultSet(StatusEnum.FAILURE.getCode(), StatusEnum.FAILURE.getMessage(), data);
    }

    public static R no(String message, Object data) {
        return resultSet(StatusEnum.FAILURE.getCode(), message, data);
    }

    public static R no(Integer code, String message, Object data) {
        return resultSet(code, message, data);
    }

    public static R no(BaseEnum baseEnum) {
        return resultSet(baseEnum.getCode(), baseEnum.getMessage(), null);
    }
}
