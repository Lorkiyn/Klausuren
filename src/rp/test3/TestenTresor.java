package rp.test3;

public class TestenTresor {

	public static void main(String[] args) {

		//Instanziierung
		Tresor t1 = new Tresor();
		Aktie a1 = new Aktie(0, 2246, "Testunternehmen a", 2001);
		Aktie a2 = new Aktie(1, 1300, "Testunternehmen b", 3211);
		Schmuck s1 = new Schmuck(2, 200, "Halskette");
		Schmuck s2 = new Schmuck(3, 5400, "Rolex");

		//Hinzufügen der Gegenstände
		t1.addGegenstand(a1);
		t1.addGegenstand(a2);
		t1.addGegenstand(s1);
		t1.addGegenstand(s2);
		
		//Ausgeben und verändern der ArrayList
		t1.druckeListe();
		t1.nimmGegenstand(3);
		t1.nimmGegenstand(3);
		
	}

}
