package com.lst.service;

import com.lst.pojo.Foods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface FoodsService {

    Page<Foods> list(Foods foods, Pageable pageable);

}
