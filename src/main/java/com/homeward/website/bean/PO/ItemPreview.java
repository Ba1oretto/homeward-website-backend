package com.homeward.website.bean.PO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ItemPreview implements Serializable {
    private String groupName;
    private String imageRegular;
    private String imageHover;
    private List<ItemPreviewCollection> itemList;
}
