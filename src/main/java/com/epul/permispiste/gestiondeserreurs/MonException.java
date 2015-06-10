package com.epul.permispiste.gestiondeserreurs;

public class MonException extends RuntimeException {

	/**
	 * 
	 */
	private String message;
	private String lacause;

	public String getLacause() {
		return lacause;
	}

	public void setLacause(String lacause) {
		this.lacause = lacause;
	}

	private static final long serialVersionUID = 1L;

	public MonException(String m, String c) {
		super();
		this.message = m;
		this.lacause = c;
	}

	public MonException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String m) {
		this.message = m;
	}

}
