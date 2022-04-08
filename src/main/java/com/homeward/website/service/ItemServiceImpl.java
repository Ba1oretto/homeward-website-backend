package com.homeward.website.service;

import com.homeward.website.mapper.ItemMapper;
import com.homeward.website.bean.PO.ItemShowCaseInfo;
import com.homeward.website.bean.PO.ItemDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemMapper itemMapper;
    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemShowCaseInfo> getItemList(String category) {
        return itemMapper.getItemList(category);
    }

    @Override
    public ItemDetail getSpecificItem(Integer itemId) {
        return itemMapper.getSpecificItem(itemId);
    }

    @Override
    public String getRuleDetails(Integer ruleId) {
        return itemMapper.getRuleDetails(ruleId);
    }
}
