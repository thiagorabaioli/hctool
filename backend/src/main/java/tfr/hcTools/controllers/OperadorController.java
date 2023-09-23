package tfr.hcTools.controllers;

import java.net.URI;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tfr.hcTools.entities.Operador;
import tfr.hcTools.entities.dto.OperadorDTO;
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
	public ResponseEntity<Void> insert(@Valid @RequestBody  OperadorDTO objDto){
		Operador obj = service.fromDto(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping (value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody OperadorDTO objDto, @PathVariable Long id){
		Operador obj = service.fromDto(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<OperadorDTO>> findPage(
			@RequestParam(value="page", defaultValue ="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC") String direction){
		Page<Operador> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<OperadorDTO> listDto = list.map(obj -> new OperadorDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
}
