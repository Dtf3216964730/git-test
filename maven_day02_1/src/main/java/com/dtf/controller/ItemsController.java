package com.dtf.controller;

import com.dtf.domain.Items;
import com.dtf.service.ItemsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsServices itemsServices;
    @RequestMapping("/findDetail")
    public String findDetail(Model model){
        Items items = itemsServices.findById(1);
        model.addAttribute("item",items);
        return "itemDetail";
    }

}
