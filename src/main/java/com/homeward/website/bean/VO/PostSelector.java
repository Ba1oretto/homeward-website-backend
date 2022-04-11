package com.homeward.website.bean.VO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PostSelector implements Serializable {
    private Integer offset;
    private Integer records;
}
