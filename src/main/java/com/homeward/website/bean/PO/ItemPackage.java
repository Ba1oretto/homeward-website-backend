package com.homeward.website.bean.PO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemPackage implements Serializable {
    private String id;
    private String amount;
    private String name;
    private String category;
    private Integer price;
    private Boolean discount;
    private Integer discountPercent;
    private String imageRegular;
    private String description;
}
