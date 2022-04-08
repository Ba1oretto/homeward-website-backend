package com.homeward.website.bean.PO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PlayerBasicInfo implements Serializable {
    private String name;
    private String uuid;
}
