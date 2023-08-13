package tfr.hcTools.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfr.hcTools.entities.Operador;
import tfr.hcTools.repositories.OperadorRepository;

@Service
public class OperadorService {
	
	@Autowired
	private OperadorRepository repo;
	
	public Operador findById(Long id) {
		Optional<Operador> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
