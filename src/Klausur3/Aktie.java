package Klausur3;

public class Aktie extends Gegenstand {
	
	private String unternehmen;
	private int nennwert;
	
	Aktie(int id, double versicherungswert, String unternehmen, int nennwert) {
		this.id = id;
		this.versicherungswert = versicherungswert;
		this.unternehmen = unternehmen;
		this.nennwert = nennwert;
	}

	public String getUnternehmen() {
		return unternehmen;
	}

	public void setUnternehmen(String unternehmen) {
		this.unternehmen = unternehmen;
	}

	public int getNennwert() {
		return nennwert;
	}

	public void setNennwert(int nennwert) {
		this.nennwert = nennwert;
	}

	@Override
	void drucken() {
		System.out.println("\n\nID: " +id
				+"\nTyp: Aktie"
				+"\nVersicherungswert: " +versicherungswert
				+"\nUnternehmen: " +unternehmen
				+"\nNennwert: " +nennwert);
	}
	
}
