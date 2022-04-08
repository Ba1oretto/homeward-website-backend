package com.homeward.website.enums;

public interface BaseEnum {
    default Integer getCode() {
        return null;
    }

    String getMessage();
}
