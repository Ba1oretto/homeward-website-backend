package com.homeward.website.controller;

import com.homeward.website.bean.PO.ItemDetail;
import com.homeward.website.bean.PO.ItemShowCaseInfo;
import com.homeward.website.bean.VO.R;
import com.homeward.website.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    /**
     * 返回所有的特定类型的商品Json
     *
     * @return CrateResult
     */
    @GetMapping("/category/{itemCategory}")
    public R getItemList(@PathVariable("itemCategory") String type) {
        List<ItemShowCaseInfo> itemList = itemService.getItemList(type);
        return R.ok(itemList);
    }

    /**
     * 返回的特定类型特定id的商品的Json
     *
     * @return CrateResult
     */
    @GetMapping("/production/{itemId}")
    public R getSpecificItem(@PathVariable("itemId") Integer id) {
        ItemDetail itemsLists = itemService.getSpecificItem(id);
        return R.ok(itemsLists);
    }

    /**
     * 返回特定id的rule的html格式的信息
     *
     * @return ruleInfo
     */
    @GetMapping("/rule/{ruleName}")
    public ModelAndView getTermDetails(@PathVariable("ruleName") String ruleName) {
        return new ModelAndView(ruleName);
    }
}