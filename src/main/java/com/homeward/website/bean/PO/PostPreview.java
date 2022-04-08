package com.homeward.website.bean.PO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PostPreview implements Serializable {
    private String slug;
    private String title;
    private String excerpt;
    private String featureImage;
    private String tag;
    private String tagColor;
    private String createTime;
}
