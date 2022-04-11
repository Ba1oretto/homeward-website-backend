package com.homeward.website.bean.PO;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostDetail implements Serializable {
    private String title;
    private String featureImage;
    private PostTag tag;
    private String html;
    private String createTime;
}
