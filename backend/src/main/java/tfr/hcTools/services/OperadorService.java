package tfr.hcTools.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfr.hcTools.entities.Operador;
import tfr.hcTools.repositories.OperadorRepository;
import tfr.hcTools.services.exceptions.ObjectNotFoundException;

@Service
public class OperadorService {
	
	@Autowired
	private OperadorRepository repo;
	
	public Operador findById(Long id) {
		Optional<Operador> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found: ID " + id + " of class: " + Operador.class.getName()));
	}
	
	public List<Operador> findAll(){
	 return repo.findAll();
	}
	
	public Operador insert (Operador obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
