package com.lst.controller;

import com.lst.pojo.Foods;
import com.lst.service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FoodsController {

    @Autowired
    private FoodsService foodsService;

    @GetMapping("list")
    public Page<Foods> list(Foods foods, @RequestParam(value = "pageNo",defaultValue = "0") Integer pageNo,@RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize){
        PageRequest pageRequest = PageRequest.of(pageNo,pageSize);
        return foodsService.list(foods,pageRequest);
    }

}
