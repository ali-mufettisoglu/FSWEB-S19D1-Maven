package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.validations.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {

    VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    public List<Vegetable> getByPriceDesc(){
        return vegetableRepository.getByPriceDesc();
    }

    public List<Vegetable> getByPriceAsc(){
        return vegetableRepository.getByPriceAsc();
    }

    public List<Vegetable> searchByName(String name){
        return vegetableRepository.searchByName(name);
    }

    public List<Vegetable> findAll(){
        return vegetableRepository.findAll();
    }

    public Vegetable getById(Long id){
        Validations.checkId(id);
        Optional<Vegetable> vegetable = vegetableRepository.findById(id);
        if(vegetable.isPresent()){
            return vegetable.get();
        }
        throw new PlantException("Id is not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.saveAndFlush(vegetable);
    }

    @Override
    public Vegetable delete(Long id) {
        Validations.checkId(id);
        Vegetable vegetable = getById(id);
        vegetableRepository.delete(vegetable);
        return vegetable;
    }
}
