package tfr.hcTools.entities.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import tfr.hcTools.entities.Cliente;
import tfr.hcTools.services.validations.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String name;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	
	
	public ClienteDTO() {}
	
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		name=obj.getName();
		email = obj.getEmail();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}
