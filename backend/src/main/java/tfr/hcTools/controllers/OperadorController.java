package tfr.hcTools.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tfr.hcTools.entities.Operador;
import tfr.hcTools.entities.OperadorDTO;
import tfr.hcTools.services.OperadorService;

@RestController
@RequestMapping(value="/operadores")
public class OperadorController {
	
	
	@Autowired
	private OperadorService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Operador> findbyId(@PathVariable Long id){
		Operador obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<OperadorDTO>> findAll(){
		List<Operador> list = service.findAll();
		List<OperadorDTO> listDto = list.stream().map(obj -> new OperadorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody  Operador obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping (value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Operador obj, @PathVariable Long id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
}
