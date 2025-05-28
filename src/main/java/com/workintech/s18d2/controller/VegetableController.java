package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService){
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getPriceAsc(){
        return vegetableService.getByPriceAsc();
    }
    @GetMapping("/desc")
    public List<Vegetable> getPriceDesc() {
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public Vegetable findById(@PathVariable Long id) {
        return vegetableService.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> getSearchByName(@PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @DeleteMapping("{id}")
    public Vegetable remove(@PathVariable Long id){
        return vegetableService.delete(id);
    }


}
