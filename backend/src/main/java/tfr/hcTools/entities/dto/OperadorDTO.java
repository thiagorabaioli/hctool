package tfr.hcTools.entities.dto;


import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import tfr.hcTools.entities.Operador;

public class OperadorDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String name;
	private String email;
	private String nif;
	public OperadorDTO() {}
	



	public OperadorDTO(Operador obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
		nif = obj.getNif();
		
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

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	
	

}
