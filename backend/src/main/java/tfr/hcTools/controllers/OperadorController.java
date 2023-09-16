package tfr.hcTools.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tfr.hcTools.entities.Operador;
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
	public ResponseEntity<List<Operador>> findAll(){
		List<Operador> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	
}
