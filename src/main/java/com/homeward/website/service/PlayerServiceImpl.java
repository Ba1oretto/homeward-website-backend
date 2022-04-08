package com.homeward.website.service;

import com.alibaba.fastjson.JSONObject;
import com.homeward.website.mapper.PlayerMapper;
import com.homeward.website.aop.annotations.JoinPointSymbol;
import com.homeward.website.enums.DateEnum;
import com.homeward.website.enums.StatusEnum;
import com.homeward.website.util.CommonUtils;
import com.homeward.website.bean.BO.PlayerInfoBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


@Service
public class PlayerServiceImpl implements PlayerService {

    private final RestTemplate restTemplate;
    private final PlayerMapper playerMapper;

    public PlayerServiceImpl(RestTemplate restTemplate, PlayerMapper playerMapper) {
        this.restTemplate = restTemplate;
        this.playerMapper = playerMapper;
    }

    @Override
    @JoinPointSymbol
    public JSONObject getPlayerProfile(String playerId) {
        if (StringUtils.isBlank(playerId)) {
            CommonUtils.throwRuntimeException(StatusEnum.ILLEGAL_CHAR);
        }

        String originMessage = this.getPlayerBasicInfo(playerId);

        //名称是否可用
        if (StringUtils.isBlank(originMessage) || originMessage.contains("error")) {
            CommonUtils.throwRuntimeException(StatusEnum.PLAYER_NOT_FOUND);
        }

        JSONObject ObjectedMessage = JSONObject.parseObject(originMessage);

        String uuid = ObjectedMessage.getString("id");
        String name = ObjectedMessage.getString("name");
        String ProfileString = this.getPlayerDetails(uuid);

        JSONObject playerProfile = JSONObject.parseObject(ProfileString);

        // 查询数据库是否有数据, 没有则录入
        PlayerInfoBO playerInfoBO = this.selectPlayer(uuid);
        if (playerInfoBO == null) {
            this.insertPlayer(uuid, name);
        }

        return playerProfile;
    }

    @Override
    public PlayerInfoBO selectPlayer(String uuid){
        return this.playerMapper.selectPlayer(uuid);
    }

    @Override
    @Transactional
    public void insertPlayer(String uuid, String name) {
        String createTime = CommonUtils.currentFormattedDate(DateEnum.yyyyMMddHHmmss);
        Long rowAffected = this.playerMapper.insertPlayer(uuid, name, createTime);
        if (rowAffected == 0) {
            CommonUtils.throwRuntimeException(StatusEnum.DATABASE_ERROR);
        }
    }

    private String getPlayerBasicInfo(String playerId) {
        String getInfo = String.format("https://api.mojang.com/users/profiles/minecraft/%s", playerId);
        return this.restTemplate.getForObject(getInfo, String.class);
    }

    private String getPlayerDetails(String playerUUID) {
        String getProfile = String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", playerUUID);
        return this.restTemplate.getForObject(getProfile, String.class);
    }
}