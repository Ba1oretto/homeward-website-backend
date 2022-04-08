package com.homeward.website.bean.BO;

import com.homeward.website.bean.PO.PlayerBasicInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PlayerInfoBO implements Serializable {
    PlayerBasicInfo playerBasicInfo;
}
