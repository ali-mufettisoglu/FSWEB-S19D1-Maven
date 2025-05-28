package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    @Query(value="Select * from fsweb.vegetable v order by v.price desc",nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    @Query(value="Select * from fsweb.vegetable v order by v.price",nativeQuery = true)
    List<Vegetable> getByPriceAsc();

    @Query(value="Select * from fsweb.vegetable v where v.name ilike %:name%",nativeQuery = true)
    List<Vegetable> searchByName(String name);
}
