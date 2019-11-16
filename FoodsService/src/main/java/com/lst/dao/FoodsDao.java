package com.lst.dao;

import com.lst.pojo.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FoodsDao extends JpaRepository<Foods,Integer>, JpaSpecificationExecutor<Foods> {

}
