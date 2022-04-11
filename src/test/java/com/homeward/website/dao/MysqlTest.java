package com.homeward.website.dao;

import com.homeward.website.bean.PO.PostDetail;
import com.homeward.website.bean.PO.PostPreview;
import com.homeward.website.bean.VO.Page;
import com.homeward.website.bean.VO.PostSelector;
import com.homeward.website.mapper.PostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MysqlTest {
    @Autowired
    private PostMapper postMapper;

    @Test
    void testSelectBlogPagePosts() {
        Page page = new Page().setPageNum(1).setPageSize(8);
        List<PostPreview> result = postMapper.selectBlogPagePosts(page);
        result.forEach(System.out::println);
    }

    @Test
    void testPostSelector() {
        PostSelector postSelector = new PostSelector();
        postSelector.setRecords(5).setOffset(1);
        List<PostPreview> result = postMapper.postSelector(postSelector);
        result.forEach(System.out::println);
    }

    @Test
    void selectPostDetail() {
        PostDetail postDetail = postMapper.selectPostDetail("road-to-1-0-0");
        System.out.println(postDetail.toString());
    }

    @Test
    void testCountAll() {
        assert postMapper.countBlogPosts() > 0;
    }
}
