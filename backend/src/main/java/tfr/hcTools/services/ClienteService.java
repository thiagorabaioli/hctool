package tfr.hcTools.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfr.hcTools.entities.Cliente;
import tfr.hcTools.repositories.ClienteRepository;
import tfr.hcTools.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found: ID " + id + " of class: " + Cliente.class.getName()));
	}

}
