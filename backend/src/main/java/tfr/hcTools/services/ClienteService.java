package tfr.hcTools.services;

import java.util.Arrays;
import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.convert.PropertyValueConverter.ObjectToObjectPropertyValueConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tfr.hcTools.entities.Cliente;
import tfr.hcTools.entities.Endereco;
import tfr.hcTools.entities.Localidade;
import tfr.hcTools.entities.dto.ClienteDTO;
import tfr.hcTools.entities.dto.ClienteNewDTO;
import tfr.hcTools.entities.enums.TipoCliente;
import tfr.hcTools.repositories.ClienteRepository;
import tfr.hcTools.repositories.EnderecoRepository;
import tfr.hcTools.services.exceptions.DataIntegrityException;
import tfr.hcTools.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepo;
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found: ID " + id + " of class: " + Cliente.class.getName()));
	}
	
	public List<Cliente> findAll(){
		 return repo.findAll();
		}
	
	@Transactional
	public Cliente insert (Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepo.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = findById(obj.getId()); //Recebe o cliente por inteiro 
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void deleteById(Long id) {
		findById(id);
		try {
		  repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar porque existem outros objectos associados");
		}
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDto(ClienteDTO  objDto) {
		return new Cliente(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null);
	}
	
	//Atualiza com os dados que veio no Cliente obj
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public Cliente fromDto(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getName(), objDto.getEmail(), objDto.getNif(), TipoCliente.toEnum(objDto.getTipo()));
		Localidade localidade1 = new Localidade(objDto.getLocalidadeId(), null,null);
		Endereco end1 = new Endereco(null, objDto.getMorada(), objDto.getNumero(), objDto.getComplemento() , objDto.getCep(), cli, localidade1);
		cli.getEnderecos().add(end1);
		cli.getTelefone().add(objDto.getTelefone1());
		if(objDto.getTelefone2() != null) {
			cli.getTelefone().add(objDto.getTelefone2());
		}
		if(objDto.getTelefone3() != null) {
			cli.getTelefone().add(objDto.getTelefone3());
		}
		
		return cli;
	}
	
	

}
