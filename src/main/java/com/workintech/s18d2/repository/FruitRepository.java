package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit,Long> {

    @Query(value="Select * from fsweb.fruit f order by f.price desc",nativeQuery = true)
    List<Fruit> getByPriceDesc();

    @Query(value ="Select * from fsweb.fruit f order by f.price asc",nativeQuery = true)
    List<Fruit> getByPriceAsc();

    @Query(value="Select * from fsweb.fruit f where f.name ilike %:name%",nativeQuery = true)
    List<Fruit> searchByName(String name);
}
