package tfr.hcTools.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfr.hcTools.entities.Pedido;
import tfr.hcTools.repositories.PedidoRepository;
import tfr.hcTools.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found: ID " + id + " of class: " + Pedido.class.getName()));
	}

}
