package rp.test3;

import java.util.ArrayList;

public class Tresor {

	private ArrayList<Gegenstand> gegenstaende = new ArrayList<Gegenstand>();

	public void addGegenstand(Gegenstand g) {
		gegenstaende.add(g);
	}

	public void nimmGegenstand(int index) {
		try {
			if(index < gegenstaende.size()){
				gegenstaende.remove(index);
			} else {
				throw new GegenstandNichtGefundenException(index);
			}
		} catch(GegenstandNichtGefundenException e){
			System.out.println(e);
		}

	}

	public Gegenstand getGegenstand(int index) {
		return gegenstaende.get(index);
	}

	public void druckeListe() {
		double verWert = 0;
		for(int i = 0;i < gegenstaende.size();i++) {
			verWert += gegenstaende.get(i).versicherungswert;
			gegenstaende.get(i).drucken();
		}
		System.out.println("\nGesammter Versicherungswert: " +verWert);
	}

}

