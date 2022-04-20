package com.homeward.website.service;

import com.homeward.website.bean.VO.Player;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PlayerService {
    Boolean playerLogin(Player player, HttpServletResponse response);
    Player playerPreLogin(HttpServletRequest request);
}
