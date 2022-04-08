package com.homeward.website.service;

import com.homeward.website.bean.PO.ItemDetail;
import com.homeward.website.bean.PO.ItemShowCaseInfo;

import java.util.List;

public interface ItemService {
    List<ItemShowCaseInfo> getItemList(String type);

    ItemDetail getSpecificItem(Integer itemId);

    String getRuleDetails(Integer ruleId);
}
