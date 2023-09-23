package tfr.hcTools.controllers.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String fildName;
	private String fildMessage;
	
	public FieldMessage() {}

	public FieldMessage(String fildName, String fildMessage) {
		super();
		this.fildName = fildName;
		this.fildMessage = fildMessage;
	}

	public String getFildName() {
		return fildName;
	}

	public void setFildName(String fildName) {
		this.fildName = fildName;
	}

	public String getFildMessage() {
		return fildMessage;
	}

	public void setFildMessage(String fildMessage) {
		this.fildMessage = fildMessage;
	}
	
	

}
