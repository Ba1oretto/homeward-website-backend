package com.homeward.website.mapper;

import com.homeward.website.aop.annotations.JoinPointSymbol;
import com.homeward.website.bean.BO.PlayerInfoBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlayerMapper {
    PlayerInfoBO selectPlayer(String uuid);

    @JoinPointSymbol
    Long insertPlayer(
            @Param("uuid") String uuid,
            @Param("name") String name,
            @Param("createTime") String createTime
    );
}
