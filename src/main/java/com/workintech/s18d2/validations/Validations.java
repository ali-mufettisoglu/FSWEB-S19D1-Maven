package com.workintech.s18d2.validations;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;

public class Validations {

    public static void checkId(Long id){
        if(id < 0){
            throw new PlantException("Id value must be bigger than 0", HttpStatus.BAD_REQUEST);
        }
    }
}
