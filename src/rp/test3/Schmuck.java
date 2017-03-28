package rp.test3;

public class Schmuck extends Gegenstand {
	
	private String typ;

	Schmuck(int id, double versicherungswert, String typ) {
		this.id = id;
		this.versicherungswert = versicherungswert;
		this.typ = typ;
	}

	@Override
	void drucken() {
		System.out.println("\n\nID: " +id
				+"\nTyp: Schmuckstück"
				+"\nVersicherungswert: " +versicherungswert
				+"\nArt: " +typ);	
	}
	
}
