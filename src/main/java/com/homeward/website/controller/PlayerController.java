package com.homeward.website.controller;

import com.homeward.website.bean.VO.Player;
import com.homeward.website.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/login")
    public Boolean playerLogin(Player player, HttpServletResponse response) {
        return playerService.playerLogin(player, response);
    }

    @GetMapping("/login/pre")
    public Player playerPreLogin(HttpServletRequest request) {
        return playerService.playerPreLogin(request);
    }
}
