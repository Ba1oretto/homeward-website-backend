package com.homeward.website.consts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SystemConst implements BaseConst {
    PROJECT_NAME("homeward"),
    PROJECT_DOMAIN("store.fantang.com"),
    PLAYER_IDENTIFY("homeward-player"),
    AUTHORIZATION_NAME("Authorization"),
    AUTHORIZATION_PREFIX("Bearer ");

    private final String value;

    @Override
    public String value() {
        return value;
    }
}
