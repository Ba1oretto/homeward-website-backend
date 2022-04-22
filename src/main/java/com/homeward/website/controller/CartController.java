package com.homeward.website.controller;

import com.homeward.website.service.CartService;
import com.homeward.website.util.JwtUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Boolean cartReset(String playerId) {
        return cartService.cartReset(playerId);
    }

    @PutMapping("/count/pre")
    public Long cartCount(String playerId) {
        String playerUUID = JwtUtils.getValue(playerId);
        if (playerUUID == null || playerUUID.isBlank()) return null;
        return cartService.cartCount(playerUUID);
    }

    @PutMapping("/count/single")
    public Long packageCount(String playerId, String packageId) {
        String playerUUID = JwtUtils.getValue(playerId);
        if (playerUUID == null || playerUUID.isBlank()) return null;
        return cartService.packageCount(playerUUID, packageId);
    }
}
