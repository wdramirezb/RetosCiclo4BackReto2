package com.ciclo4.catalogo.repository.crud;

import com.ciclo4.catalogo.model.Fragance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FraganceCrudRepository extends MongoRepository<Fragance, String> {

}
