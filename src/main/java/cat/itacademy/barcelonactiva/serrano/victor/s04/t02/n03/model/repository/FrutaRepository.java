package cat.itacademy.barcelonactiva.serrano.victor.s04.t02.n03.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import cat.itacademy.barcelonactiva.serrano.victor.s04.t02.n03.model.domain.Fruta;

public interface FrutaRepository extends MongoRepository<Fruta, String> {

}