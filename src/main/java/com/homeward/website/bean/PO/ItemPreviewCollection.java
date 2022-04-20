package com.homeward.website.bean.PO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemPreviewCollection implements Serializable {
    private Integer amount;
    private Integer price;
    private Boolean discount;
    private Integer discountPercent;
}
