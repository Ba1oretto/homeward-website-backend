package com.homeward.website.controller;

import com.homeward.website.bean.PO.ItemCart;
import com.homeward.website.service.CartService;
import com.homeward.website.util.JwtUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping("/increase")
    public Long cartIncrease(String playerId, String packageId) {
        String playerUUID = JwtUtils.getValue(playerId);
        if (playerUUID == null || playerUUID.isBlank()) return null;
        return cartService.cartIncrease(playerUUID, packageId);
    }

    @PutMapping("/decrease")
    public Long cartDecrease(String playerId, String packageId) {
        String playerUUID = JwtUtils.getValue(playerId);
        if (playerUUID == null || playerUUID.isBlank()) return null;
        return cartService.cartDecrease(playerUUID, packageId);
    }

    @PutMapping("/reset")
    public Boolean itemReset(String playerId, String packageId) {
        String playerUUID = JwtUtils.getValue(playerId);
        if (playerUUID == null || playerUUID.isBlank()) return null;
        return cartService.itemReset(playerUUID, packageId);
    }

    @PutMapping("/preview")
    public List<ItemCart> cartPreview(String playerId) {
        String playerUUID = JwtUtils.getValue(playerId);
        if (playerUUID == null || playerUUID.isBlank()) return null;
        return cartService.cartPreview(playerUUID);
    }
}
