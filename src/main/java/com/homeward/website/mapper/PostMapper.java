package com.homeward.website.mapper;

import com.homeward.website.bean.PO.PostPreview;
import com.homeward.website.bean.VO.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostPreview> selectBlogPagePosts(Page page);
    List<PostPreview> selectHomeShowcasePosts();
    Integer countBlogPosts();
}
