package com.homeward.website.service;

public interface CartService {
    Long cartIncrease(String playerId, String packageId);
    Long cartDecrease(String playerId, String packageId);
    Boolean cartReset(String playerId);
    Long cartCount(String playerId);
    Long packageCount(String playerId, String packageId);
}
