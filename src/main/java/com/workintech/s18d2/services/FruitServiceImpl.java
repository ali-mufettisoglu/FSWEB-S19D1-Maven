package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.validations.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {

    FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public List<Fruit> getByPriceDesc(){
       return fruitRepository.getByPriceDesc();
    }

    public List<Fruit> getByPriceAsc(){
        return fruitRepository.getByPriceAsc();
    }

    public List<Fruit> searchByName(String name){
        return fruitRepository.searchByName(name);
    }

    public List<Fruit> findAll(){
        return fruitRepository.findAll();
    }

    public Fruit getById(Long id){
        Validations.checkId(id);
        Optional<Fruit> fruit = fruitRepository.findById(id);
        if(fruit.isPresent()){
            return fruit.get();
        }
        throw new PlantException("Id is not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.saveAndFlush(fruit);
    }

    @Override
    public Fruit delete(Long id) {
        Validations.checkId(id);
        Fruit fruit = getById(id);
         fruitRepository.delete(fruit);
         return fruit;
    }

}
