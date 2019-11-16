package com.lst.service;

import com.lst.dao.FoodsDao;
import com.lst.pojo.Foods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodsServiceImpl implements FoodsService{

    @Autowired
    private FoodsDao foodsDao;

    public Page<Foods> list(Foods foods, Pageable pageable){


//        {
//        Specification<Foods> specification = new Specification<Foods>() {
//            @Override
//            public Predicate toPredicate(Root<Foods> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
//                Predicate predicate = cb.like(root.get("name"), "%" + foods.getName() + "%");
//                return predicate;
//            }
//        };























    Specification<Foods> specification = new Specification<Foods>() {
        @Override
        public Predicate toPredicate(Root<Foods> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
            List<Predicate> list=new ArrayList<>();
            if(foods.getName()!=null&&foods.getName()!=""){

                Predicate name = cb.like(root.get("name"), "%" + foods.getName() + "%");
                list.add(name);
            }
            Predicate[] predicates = list.toArray(new Predicate[list.size()]);
            return cb.and(predicates);
        }
    };
       return foodsDao.findAll(specification,pageable);
    }
}
