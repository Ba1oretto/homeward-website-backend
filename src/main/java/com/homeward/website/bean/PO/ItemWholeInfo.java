package com.homeward.website.bean.PO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ItemWholeInfo implements Serializable, Cloneable {
    private Integer id;
    private String type;
    private String name;
    private Integer price;
    private Boolean saleCondition;
    private Integer salePercent;
    private String rawSalePercent;
    private String command;
    private String imageAddress;
    private String imageHoverAddress;
    private String description;
    private String rawDescription;
    private String descriptionId;

    @Override
    public ItemWholeInfo clone() {
        try {
            return (ItemWholeInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}