package com.homeward.website.controller;

import com.alibaba.fastjson.JSONObject;
import com.homeward.website.service.PlayerService;
import com.homeward.website.aop.annotations.JoinPointSymbol;
import com.homeward.website.consts.SystemConst;
import com.homeward.website.util.JwtUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/name/{id}")
    @JoinPointSymbol
    // public R getPlayerProfile(@PathVariable("id") String playerName, HttpServletResponse response) {
    public Object getPlayerProfile(@PathVariable("id") String playerName, HttpServletResponse response) {
        JSONObject playerProfile = playerService.getPlayerProfile(playerName);
        String uuid = playerProfile.getString("id");

        if (!JwtUtils.verity()) {
            String playerEncryptedUUId = JwtUtils.createToken(uuid);
            response.setHeader(SystemConst.AUTHORIZATION_NAME.getInformation(),
                    SystemConst.AUTHORIZATION_PREFIX.getInformation() + playerEncryptedUUId
            );
        }

        // return R.ok(playerProfile.toJavaObject(Object.class));
        return playerProfile.toJavaObject(Object.class);
    }
}
