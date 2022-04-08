package com.homeward.website.service;

import com.homeward.website.bean.PO.PostPreview;
import com.homeward.website.bean.VO.Page;
import com.homeward.website.mapper.PostMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private final PostMapper postMapper;

    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public Page selectBlogPagePosts(Page page) {
        Integer pageNum = page.getPageNum();
        Integer pageSize = page.getPageSize();
        if (null == pageNum || pageNum.equals(0) || null == pageSize || pageSize.equals(0)) return null;
        List<PostPreview> result = postMapper.selectBlogPagePosts(page);
        if (result.size() == 0) return null;
        Integer total = postMapper.countBlogPosts();
        int rawPageSum = total / pageSize;

        int pageSum = rawPageSum == 0 ? 1 : rawPageSum;
        Integer next = pageNum == pageSum || pageNum >= pageSum ? null : pageNum + 1;
        Integer prev = pageNum == 1 ? null : pageNum - 1;

        return page.setTotal(total).setPageSum(pageSum).setNext(next).setPrev(prev).setPosts(result);
    }

    @Override
    public List<PostPreview> selectHomeShowcasePosts() {
        return postMapper.selectHomeShowcasePosts();
    }
}
