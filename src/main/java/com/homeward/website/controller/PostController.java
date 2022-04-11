package com.homeward.website.controller;

import com.homeward.website.bean.VO.Page;
import com.homeward.website.bean.VO.PostSelector;
import com.homeward.website.bean.VO.R;
import com.homeward.website.service.PostService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{slug}")
    public R selectPostDetail(@PathVariable("slug") String slug) {
        return R.ok(postService.selectPostDetail(slug));
    }

    @GetMapping("/selector")
    public R postsSelector(PostSelector postSelector) {
        return R.ok(postService.postsSelector(postSelector));
    }

    @PostMapping("/refresh")
    public void clearCache() {
        postService.clearCache();
    }
}