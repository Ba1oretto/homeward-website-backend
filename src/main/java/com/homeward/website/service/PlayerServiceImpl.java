package com.homeward.website.service;

import com.homeward.website.bean.VO.Player;
import com.homeward.website.consts.SystemConst;
import com.homeward.website.mapper.PlayerMapper;
import com.homeward.website.util.CookieUtils;
import com.homeward.website.util.JwtUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final PlayerMapper playerMapper;

    public PlayerServiceImpl(RedisTemplate<String, Object> redisTemplate, PlayerMapper playerMapper) {
        this.redisTemplate = redisTemplate;
        this.playerMapper = playerMapper;
    }

    @Override
    @Transactional
    public Boolean playerLogin(Player player, HttpServletResponse response) {
        String name = player.getName();
        String uuid = player.getUuid();
        Boolean redisCached = redisTemplate.hasKey(uuid);
        if (Objects.equals(redisCached, false)) redisTemplate.opsForValue().set(uuid, name, 604800L, TimeUnit.SECONDS);
        Long mysqlCached = playerMapper.selectPlayerByUUID(uuid);
        if (mysqlCached == 0) playerMapper.insertPlayerInformation(player);
        String token = JwtUtils.createToken(uuid);
        Cookie cookie = CookieUtils.generate(SystemConst.PLAYER_IDENTIFY.value(), token);
        response.addCookie(cookie);
        return true;
    }

    @Override
    public Player playerPreLogin(HttpServletRequest request) {
        Player player = new Player();
        Iterator<Cookie> cookieIterator = Arrays.stream(request.getCookies()).iterator();
        cookieIterator.forEachRemaining((cookie -> {
            String name = cookie.getName();
            if (name != null && !name.isBlank() && name.equals(SystemConst.PLAYER_IDENTIFY.value())) {
                player.setUuid(JwtUtils.getValue(cookie.getValue()));
            }
        }));
        if (player.getUuid() == null) return null;
        player.setName((String) redisTemplate.opsForValue().get(player.getUuid()));
        return player;
    }
}
