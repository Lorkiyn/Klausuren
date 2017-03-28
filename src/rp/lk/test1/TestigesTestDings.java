package rp.lk.test1;

public class TestigesTestDings {

	public static void main(String[] args) throws PokemonNotFoundException {
		PokemonDao dao = new PokemonDao();
		dao.clearTable();
		dao.printDB();		
	}
}
