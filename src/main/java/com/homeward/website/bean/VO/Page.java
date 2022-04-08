package com.homeward.website.bean.VO;

import com.homeward.website.bean.PO.PostPreview;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class Page implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
    private Integer pageSum;
    private Integer next;
    private Integer prev;
    private Integer total;
    private List<PostPreview> posts;
}
