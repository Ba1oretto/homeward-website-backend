package com.homeward.website.bean.BO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ItemName implements Serializable, Cloneable {
    Integer id;
    Integer amount;
    String name;
    String descriptionId;

    @Override
    public ItemName clone() {
        try {
            return (ItemName) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
