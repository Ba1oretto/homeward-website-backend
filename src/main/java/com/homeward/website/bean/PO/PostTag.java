package com.homeward.website.bean.PO;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostTag implements Serializable {
    private String name;
    private String color;
}
