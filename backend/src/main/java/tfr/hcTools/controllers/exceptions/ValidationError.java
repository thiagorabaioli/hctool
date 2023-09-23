package tfr.hcTools.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> erros = new ArrayList<>();

	public ValidationError() {
		super();
	
	}

	public ValidationError(Integer status, String cause, Long timeStamp) {
		super(status, cause, timeStamp);
		
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErros(String fieldName, String fieldMessage) {
		erros.add(new FieldMessage(fieldName, fieldMessage));
	}
	
	

}
