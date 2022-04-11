package com.homeward.website.service;

import com.homeward.website.bean.PO.PostDetail;
import com.homeward.website.bean.PO.PostPreview;
import com.homeward.website.bean.VO.Page;
import com.homeward.website.bean.VO.PostSelector;
import com.homeward.website.mapper.PostMapper;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private final PostMapper postMapper;
    private final SqlSessionFactory sqlSessionFactory;

    public PostServiceImpl(PostMapper postMapper, SqlSessionFactory sqlSessionFactory) {
        this.postMapper = postMapper;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Page selectBlogPagePosts(Page page) {
        Integer pageNum = page.getPageNum();
        Integer pageSize = page.getPageSize();
        if (null == pageNum || 0 >= pageNum || null == pageSize || 0 >= pageSize) return null;

        List<PostPreview> result = postMapper.selectBlogPagePosts(page);
        if (result.size() == 0) return null;

        Integer total = postMapper.countBlogPosts();

        int rawPageSum = total / pageSize;
        int pageSum = total % pageSize == 0 ? rawPageSum : rawPageSum + 1;
        Integer next = pageNum == pageSum ? null : pageNum + 1;
        Integer prev = pageNum == 1 ? null : pageNum - 1;

        return page.setTotal(total).setPageSum(pageSum).setNext(next).setPrev(prev).setPosts(result);
    }

    @Override
    public List<PostPreview> postsSelector(PostSelector postSelector) {
        Integer records = postSelector.getRecords();
        if (records == null || records == 0) return null;
        return postMapper.postSelector(postSelector);
    }

    @Override
    public PostDetail selectPostDetail(String slug) {
        return postMapper.selectPostDetail(slug);
    }

    @Override
    public void clearCache() {
        Configuration sqlSessionFactoryConfiguration = sqlSessionFactory.getConfiguration();
        Cache postCache = sqlSessionFactoryConfiguration.getCache("com.homeward.website.mapper.PostMapper");
        if (postCache != null) postCache.clear();
    }
}
