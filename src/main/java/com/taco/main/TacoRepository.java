package com.taco.main;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.taco.tacoEntity.DatabasePojo;

public interface TacoRepository extends MongoRepository<DatabasePojo, String> {

	public DatabasePojo findByKey(String key);

}
