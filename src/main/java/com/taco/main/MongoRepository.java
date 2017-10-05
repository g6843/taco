package com.taco.main;

import com.taco.tacoEntity.Entity;
import org.springframework.data.repository.CrudRepository;

public interface MongoRepository extends CrudRepository<Entity, String> {

    @Override
    Entity findOne(String s);


}
