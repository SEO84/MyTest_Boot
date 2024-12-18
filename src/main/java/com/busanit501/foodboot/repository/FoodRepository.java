package com.busanit501.foodboot.repository;

import com.busanit501.foodboot.domain.Food;
import com.busanit501.foodboot.repository.search.FoodSearch;
import com.busanit501.foodboot.repository.search.FoodSearchImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FoodRepository extends JpaRepository<Food, Long> , FoodSearch {

    Page<Food> findByFnameContainingOrderByFnoDesc(String fname, Pageable pageable);


    @Query("select b from Food b where b.fname like concat('%',:keyword,'%')")
    Page<Food> findByKeyword(String keyword, Pageable pageable);

    @Query(value = "select now()" , nativeQuery = true)
    String now();



}
