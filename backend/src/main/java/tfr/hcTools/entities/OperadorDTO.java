package tfr.hcTools.entities;

import java.io.Serializable;

public class OperadorDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String nif;
	public OperadorDTO() {}
	
	
	
	public OperadorDTO(Long id, String name, String email, String nif) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.nif = nif;
	}



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
