package cat.itacademy.barcelonactiva.serrano.victor.s04.t02.n03.model.services;

import java.util.Optional;

import cat.itacademy.barcelonactiva.serrano.victor.s04.t02.n03.model.domain.Fruta;

public interface FrutaService {
	
	public Iterable<Fruta> findAll();
	
	public Fruta save(Fruta fruta);
	
	public void deleteById(String id);
	
	public Optional<Fruta> findById(String id);

}

