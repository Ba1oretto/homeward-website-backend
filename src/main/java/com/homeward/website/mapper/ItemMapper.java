package com.homeward.website.mapper;

import com.homeward.website.bean.PO.ItemPreview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemPreview> selectItemsListByCategory(String category);
}
