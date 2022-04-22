package com.homeward.website.bean.PO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ItemCart implements Serializable {
    private String id;
    private Integer amount;
    private String name;
    private String category;
    private Integer price;
    private Boolean discount;
    private Integer discountPercent;
    private Long inCart;
}
