package com.homeward.website.mapper;

import com.homeward.website.bean.VO.Player;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlayerMapper {
    Long selectPlayerByUUID(String uuid);
    void insertPlayerInformation(Player player);
}
