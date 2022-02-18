package com.homeward.webstore.mapper;

import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.pojo.playerinfo.PlayerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlayerInfoMapper {
    PlayerInfo selectPlayer(String uuid);

    @JoinPointSymbol
    void insertPlayer(
            @Param("uuid") String uuid,
            @Param("name") String name
    );
}
