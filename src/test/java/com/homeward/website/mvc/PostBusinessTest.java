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
        Page page = new Page().setPageNum(1).setPageSize(3);
        Integer pageNum = page.getPageNum();
        Integer pageSize = page.getPageSize();

        List<PostPreview> result = postMapper.selectBlogPagePosts(page);
        Integer total = postMapper.countBlogPosts();

        int rawPageSum = total / pageSize;
        int pageSum = total % pageSize == 0 ? rawPageSum : rawPageSum + 1;
        Integer next = pageNum == pageSum ? null : pageNum + 1;
        Integer prev = pageNum == 1 ? null : pageNum - 1;

        System.out.println("total: " + total);
        System.out.println("rawPageSum: " + rawPageSum);
        System.out.println("pageSum: " + pageSum);
        System.out.println("next: " + next);
        System.out.println("prev: " + prev);
        System.out.println("result: " + result);
    }

    @Test
    void testPostsSelector() {
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