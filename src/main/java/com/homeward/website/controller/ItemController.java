package com.homeward.website.controller;

import com.homeward.website.bean.VO.R;
import com.homeward.website.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/category/{category}")
    public R selectItemsList(@PathVariable("category") String category) {
        return R.ok(itemService.selectItemsList(category));
    }

    @GetMapping("/package/{id}")
    public R selectItemPackage(@PathVariable("id") String id) {
        return R.ok(itemService.selectItemPackage(id));
    }
}