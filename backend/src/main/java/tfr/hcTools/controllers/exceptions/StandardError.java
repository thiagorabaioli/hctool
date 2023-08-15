package tfr.hcTools.controllers.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String cause;
	private Long timeStamp;
	
	public StandardError() {}

	public StandardError(Integer status, String cause, Long timeStamp) {
		super();
		this.status = status;
		this.cause = cause;
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}

