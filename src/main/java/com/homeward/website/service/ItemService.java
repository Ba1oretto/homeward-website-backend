package com.homeward.website.service;

import com.homeward.website.bean.PO.ItemPreview;

import java.util.List;

public interface ItemService {
    List<ItemPreview> selectItemsList(String category);
}
