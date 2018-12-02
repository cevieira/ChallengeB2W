package com.apistarwars.repository;

import com.apistarwars.entity.Planeta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String> {
    @Query("{'nome' : ?0}")
    Planeta findyByNome(String nome);
}
