package rp.lk.test1;

public class PokemonFeatureNotFoundException extends Exception {

	/**
	 * This is an Exception.
	 */
	private static final long serialVersionUID = 1L;
	
	private String feature;
	
	public PokemonFeatureNotFoundException(String feature) {
		this.feature = feature;
	}

	public String getMessage() {
		return "Man eyyyy voll kein Feature(" + feature + ") gefunden... was gibst n ein da.";
	}
}
