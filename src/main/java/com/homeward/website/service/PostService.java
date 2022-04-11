package com.homeward.website.service;

import com.homeward.website.bean.PO.PostDetail;
import com.homeward.website.bean.PO.PostPreview;
import com.homeward.website.bean.VO.Page;
import com.homeward.website.bean.VO.PostSelector;

import java.util.List;

public interface PostService {
    Page selectBlogPagePosts(Page page);
    List<PostPreview> postsSelector(PostSelector postSelector);
    PostDetail selectPostDetail(String slug);
    void clearCache();
}
