package rp.lk.test1;

public class Pokemon {
	
	private String name;
	private int kampfpunkte;
	private int angriffspunkte;
	private int verteidigungspunkte;
	private int initiativepunkte;
	private float groesse;
	private float gewicht;

	public Pokemon() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKampfpunkte() {
		return kampfpunkte;
	}

	public void setKampfpunkte(int kampfpunkte) {
		this.kampfpunkte = kampfpunkte;
	}

	public int getAngriffspunkte() {
		return angriffspunkte;
	}

	public void setAngriffspunkte(int angriffspunkte) {
		this.angriffspunkte = angriffspunkte;
	}

	public int getVerteidigungspunkte() {
		return verteidigungspunkte;
	}

	public void setVerteidigungspunkte(int verteidigungspunkte) {
		this.verteidigungspunkte = verteidigungspunkte;
	}

	public int getInitiativepunkte() {
		return initiativepunkte;
	}

	public void setInitiativepunkte(int initiativepunkte) {
		this.initiativepunkte = initiativepunkte;
	}

	public float getGroesse() {
		return groesse;
	}

	public void setGroesse(float groesse) {
		this.groesse = groesse;
	}

	public float getGewicht() {
		return gewicht;
	}

	public void setGewicht(float gewicht) {
		this.gewicht = gewicht;
	}
	
}
