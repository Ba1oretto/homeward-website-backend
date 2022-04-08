package com.homeward.website.mvc;

import com.homeward.website.bean.PO.PostPreview;
import com.homeward.website.bean.VO.Page;
import com.homeward.website.mapper.PostMapper;
import com.homeward.website.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostBusinessTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostMapper postMapper;

    @Test
    void testSelectBlogPagePosts() {
        Page page = new Page().setPageNum(114).setPageSize(8);
        Integer pageNum = page.getPageNum();
        Integer pageSize = page.getPageSize();
        List<PostPreview> result = postMapper.selectBlogPagePosts(page);

        Integer total = postMapper.countBlogPosts();

        int pageSum = total / pageSize;
        Integer next = pageNum + 1 == pageSum ? null : pageNum + 1;
        Integer prev = pageNum == 1 ? null : pageNum - 1;

        page.setTotal(total).setPageSum(pageSum).setNext(next).setPrev(prev).setPosts(result);
    }

    @Test
    void testSelectHomeShowcasePosts() {
        List<PostPreview> postPreviews = postService.selectHomeShowcasePosts();
        assert !postPreviews.isEmpty();
    }
}

//meta: {
//  pagination: {
//      limit: 8; //per pgae post limit
//      next: 2; //next page position (1 -> 2)
//      page: 1; //current page
//      page: 6; //all pages
//      prev: null; //previous page
//      total: 41; //all posts
//  }
//}
//posts: [{
//  excerpt: 'aabbcc...', //description (180 char limited)
//  feature_image: 'https://xxxx.com/', //image address
//  tags: {
//      accent_color: '#...', //color
//      name: 'Update' //type
//  },
//  published_at: '2022-03-18T22:28:05.000+00:00', //create time
//  slug: 'gigs-and-jigs', //post id
//  title: '0.18.0 - Gigs & Jigs Update' //title
//}]