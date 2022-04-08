package com.homeward.website.controller;

import com.homeward.website.bean.VO.Page;
import com.homeward.website.bean.VO.R;
import com.homeward.website.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/blog")
    public R selectAllPost(Page page) {
        return R.ok(postService.selectBlogPagePosts(page));
    }

    @GetMapping("/home")
    public R selectRecentPosts() {
        return R.ok(postService.selectHomeShowcasePosts());
    }
}