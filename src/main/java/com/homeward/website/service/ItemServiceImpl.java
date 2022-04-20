package com.homeward.website.service;

import com.homeward.website.bean.PO.ItemPreview;
import com.homeward.website.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemMapper itemMapper;

    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemPreview> selectItemsList(String category) {
        return itemMapper.selectItemsListByCategory(category);
    }
}
