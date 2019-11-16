package com.lst.service;

import com.lst.pojo.Foods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class FoodsServiceTest {

    @Autowired
    private FoodsService foodsService;
    @Test
    public void list() {
        PageRequest request = PageRequest.of(0,1);
        Foods foods = new Foods();
        foods.setName("干");
        Page<Foods> list = foodsService.list(foods, request);
        System.out.println(list.getContent());
    }
}