package com.homeward.website.mapper;

import com.homeward.website.bean.PO.ItemCart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {
    ItemCart selectItemCartDetailById(String id);
}
