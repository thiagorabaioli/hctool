package tfr.hcTools.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import tfr.hcTools.entities.Operador;
import tfr.hcTools.entities.dto.OperadorDTO;
import tfr.hcTools.repositories.OperadorRepository;
import tfr.hcTools.services.exceptions.DataIntegrityException;
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
	
	public Operador update(Operador obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteById(Long id) {
		findById(id);
		try {
		  repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar porque existem outros objectos associados");
		}
	}
	
	public Page<Operador> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Operador fromDto(OperadorDTO  objDto) {
		return new Operador(objDto.getId(), objDto.getName(), objDto.getEmail(), objDto.getNif());
	}
	
	
}
