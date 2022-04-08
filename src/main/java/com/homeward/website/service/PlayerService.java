package com.homeward.website.service;

import com.alibaba.fastjson.JSONObject;
import com.homeward.website.aop.annotations.JoinPointSymbol;
import com.homeward.website.bean.BO.PlayerInfoBO;

public interface PlayerService {
    @JoinPointSymbol
    JSONObject getPlayerProfile(String playerUUID);

    void insertPlayer(String id, String playerName);

    PlayerInfoBO selectPlayer(String id);
}
