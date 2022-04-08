package com.homeward.website.bean.PO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ItemInformation implements Serializable {
    private String type;
}
