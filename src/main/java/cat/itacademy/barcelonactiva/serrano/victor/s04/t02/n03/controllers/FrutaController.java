package cat.itacademy.barcelonactiva.serrano.victor.s04.t02.n03.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.serrano.victor.s04.t02.n03.model.domain.Fruta;
import cat.itacademy.barcelonactiva.serrano.victor.s04.t02.n03.model.services.FrutaService;


@RestController
@Controller
//@Slf4j
@RequestMapping("/fruta")
public class FrutaController {
	
	// static final Logger logger = LoggerFactory.getLogger(FrutaController.class);
	
	@Autowired
	private FrutaService frutaService;
	
	//Crear un registro de Fruta
	@PostMapping("/add")
	public ResponseEntity<?> create (@RequestBody Fruta fruta){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(frutaService.save(fruta));
	}
	
	//Leer un registro de fruta
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") String Id){
		
		Optional<Fruta> oFruta = frutaService.findById(Id);
		
		if (!oFruta.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oFruta);
		
	}
	
	//Acualizar un registro de fruta
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Fruta frutaDetalle,@PathVariable(value="id") String id){
		
		Optional<Fruta> fruta = frutaService.findById(id);
		
		if (!fruta.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(frutaDetalle, fruta.get());
		
		fruta.get().setNombre(frutaDetalle.getNombre());
		fruta.get().setCantidadKilos(frutaDetalle.getCantidadKilos());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(frutaService.save(fruta.get()));
	}
	
	//Borrar un registro de fruta
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id") String id){
		
		if(!frutaService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		frutaService.deleteById(id);
		return ResponseEntity.ok().build();
		
	}
	
	//Leer todos los registros de Frutas
	@GetMapping("/getAll")
	public List<Fruta> readAll(){
		
		List<Fruta> frutas = StreamSupport
				.stream(frutaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return frutas;
		
	}
		

}
