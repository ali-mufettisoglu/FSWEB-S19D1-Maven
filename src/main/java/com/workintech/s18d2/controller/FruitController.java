package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.FruitResponseRecord;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getPriceAsc(){
        return fruitService.getByPriceAsc();
    }
    @GetMapping("/desc")
    public List<Fruit> getPriceDesc() {
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public FruitResponseRecord findById(@PathVariable Long id) {
         return new FruitResponseRecord("get by id succeed", fruitService.getById(id));
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getSearchByName(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @DeleteMapping("{id}")
    public Fruit remove(@PathVariable Long id){
        return fruitService.delete(id);
    }


}
