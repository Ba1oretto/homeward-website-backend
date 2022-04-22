package com.homeward.website.service;

import com.homeward.website.bean.PO.ItemCart;

import java.util.List;

public interface CartService {
    Long cartIncrease(String playerId, String packageId);
    Long cartDecrease(String playerId, String packageId);
    Boolean itemReset(String playerId, String packageId);
    List<ItemCart> cartPreview(String playerId);
}
