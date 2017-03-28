package RP0201;

public class PokemonNotFoundException extends Exception {

	/**
	 * This is an Exception.
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public PokemonNotFoundException(String name) {
		this.name = name;
	}

	public String getMessage() {
		return "Man eyyyy voll kein " + name + " gefunden... was gibst n ein da.";
	}
}
