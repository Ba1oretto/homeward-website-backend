package com.homeward.website.bean.VO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Player implements Serializable {
    private String name;
    private String uuid;
}
