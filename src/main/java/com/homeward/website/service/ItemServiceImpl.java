package com.homeward.website.service;

import com.homeward.website.bean.PO.ItemPackage;
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
        if (category == null || category.isBlank()) return null;
        return itemMapper.selectItemsListByCategory(category);
    }

    @Override
    public ItemPackage selectItemPackage(String id) {
        if (id == null || id.isBlank()) return null;
        return itemMapper.selectItemPackageById(id);
    }
}