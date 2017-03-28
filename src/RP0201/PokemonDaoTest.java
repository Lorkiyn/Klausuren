package RP0201;

import java.util.ArrayList;

public class PokemonDaoTest {

	public static void main(String[] main) {

		Pokemon despotar = new Pokemon();
		despotar.setName("Despotar");
		despotar.setKampfpunkte(100);
		despotar.setAngriffspunkte(164);
		despotar.setVerteidigungspunkte(150);
		despotar.setInitiativepunkte(71);
		despotar.setGroesse(2.0f);
		despotar.setGewicht(202.0f);

		Pokemon botogel = new Pokemon();
		botogel.setName("Botogel");
		botogel.setKampfpunkte(45);
		botogel.setAngriffspunkte(55);
		botogel.setVerteidigungspunkte(45);
		botogel.setInitiativepunkte(75);
		botogel.setGroesse(0.9f);
		botogel.setGewicht(16.0f);

		Pokemon zurrokex = new Pokemon();
		zurrokex.setName("Zurrokex");
		zurrokex.setKampfpunkte(50);
		zurrokex.setAngriffspunkte(70);
		zurrokex.setVerteidigungspunkte(70);
		zurrokex.setInitiativepunkte(48);
		zurrokex.setGroesse(0.6f);
		zurrokex.setGewicht(11.8f);

		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		pokemons.add(despotar);
		pokemons.add(botogel);
		pokemons.add(zurrokex);

		// Test Pokemon Setter
		System.out.print("Pokemon Setter...                                           ");
		try {
			Pokemon pokemon = new Pokemon();
			pokemon.setName("Despotar");
			pokemon.setKampfpunkte(100);
			pokemon.setAngriffspunkte(164);
			pokemon.setVerteidigungspunkte(150);
			pokemon.setInitiativepunkte(71);
			pokemon.setGroesse(2.0f);
			pokemon.setGewicht(202.0f);
			System.out.println("checked");
		} catch (Exception exception) {
			System.out.println("failed: " + exception.getMessage());
		}

		// Test Konstruktor PokemonDao
		System.out.print("PokemonDao PokemonDao()...                                  ");
		PokemonDao pokemonDao = null;
		try {
			pokemonDao = new PokemonDao();
			System.out.println("checked");
		} catch (Exception exception) {
			System.out.println("failed: " + exception.getMessage());
		}

		pokemonDao.clearTable();

		// Test PokemonDao Factory
		System.out.print("PokemonDao create()...                                      ");
		Pokemon pokemon = null;
		try {
			pokemon = pokemonDao.create();
			if (null != pokemon) {
				System.out.println("checked");
			} else {
				System.out.println("failed");
			}
		} catch (Exception exception) {
			System.out.println("failed: " + exception.getMessage());
		}

		// Test PokemonDao insert()
		System.out.print("PokemonDao insert()...                                      ");
		try {
			pokemon = despotar;
			pokemonDao.insert(pokemon);

			Pokemon insertedPokemon = pokemonDao.search(pokemon.getName());
			if (compare(pokemon, insertedPokemon)) {
				System.out.println("checked");				
			} else {
				System.out.println("failed");
			}
		} catch (Exception exception) {
			System.out.println("failed: " + exception.getMessage());
		}

		// Test PokemonDao update()
		System.out.print("PokemonDao update()...                                      ");
		try {
			despotar.setGewicht(255.0f);
			despotar.setGroesse(2.5f);
			pokemonDao.update(despotar);
			System.out.println("checked");
		} catch (Exception exception) {
			System.out.println("failed: " + exception.getMessage());
		}

		// Test PokemonDao insert() 
		System.out.print("Injecting two more pokemons...                              ");
		try {
			pokemonDao.insert(botogel);
			pokemonDao.insert(zurrokex);
			System.out.println("checked");
		}  catch (Exception exception) {
			System.out.println("failed: " + exception.getMessage());
		}

		// Test PokemonDao search() positive
		System.out.print("PokemonDao search() positive...                             ");
		try {
			pokemon = pokemonDao.search("Botogel");
			System.out.println("checked");
		} catch (Exception exception) {
			System.out.println("failed: " + exception.getMessage());
		}

		// Test PokemonDao search() negative
		System.out.print("PokemonDao search() negative...                             ");
		try {
			pokemon = pokemonDao.search("Foobar");
			System.out.println("failed: No exception");
		} catch (PokemonNotFoundException pokemonNotFoundException) {
			System.out.println("checked");
		} catch (Exception exception) {
			System.out.println("failed: Wrong exception: " + exception.getMessage());
		}

		// Test PokemonDao getPokemonWithMaxFeature() positive
		System.out.print("PokemonDao getPokemonWithMaxFeature() positive...           ");
		try {
			Pokemon bestPokemon = pokemonDao.getPokemonWithMaxFeature("gewicht");			
			if (compare(bestPokemon, despotar)) {
				System.out.println("checked");
			} else {
				System.out.println("failed");
			}
		} catch (Exception exception) {
			System.out.println("failed: " + exception.getMessage());
		}

		// Test PokemonDao getPokemonWithMaxFeature() negative
		System.out.print("PokemonDao getPokemonWithMaxFeature() negative...           ");
		try {
			Pokemon bestPokemon = pokemonDao.getPokemonWithMaxFeature("name");
			System.out.println("failed");
		} catch (PokemonFeatureNotFoundException exception) {
			System.out.println("checked");
		} catch (Exception exception) {
			System.out.println("failed: " + exception.getMessage());
		}

		// Test PokemonDao getPokemonsWithFeatureAboveAverage() positive
		System.out.print("PokemonDao getPokemonsWithFeatureAboveAverage() positive... ");
		try {
			ArrayList<Pokemon> betterPokemons = pokemonDao.getPokemonsWithFeatureAboveAverage("gewicht");			
			if (betterPokemons.size() == 1 && compare(betterPokemons.get(0), despotar)) {
				System.out.println("checked");
			} else {
				System.out.println("failed");
			}
		} catch (Exception exception) {
			System.out.println("failed: " + exception.getMessage());
		}

		// Test PokemonDao getPokemonsWithFeatureAboveAverage() negative
		System.out.print("PokemonDao getPokemonsWithFeatureAboveAverage() negative... ");
		try {
			ArrayList<Pokemon> betterPokemons = pokemonDao.getPokemonsWithFeatureAboveAverage("name");			
			System.out.println("failed");
		} catch (PokemonFeatureNotFoundException exception) {
			System.out.println("checked");
		} catch (Exception exception) {
			System.out.println("failed: " + exception.getMessage());
		}

		// Test PokemonDao delete() positive
		System.out.print("PokemonDao delete()...                                      ");
		try {
			pokemon = pokemonDao.delete("Botogel");
			System.out.println("checked");
		} catch (Exception exception) {
			System.out.println("failed: " + exception.getMessage());
		}
	}

	private static boolean compare(Pokemon pokemon1, Pokemon pokemon2) {
		return (pokemon1.getName().equals(pokemon2.getName()) &&
				pokemon1.getKampfpunkte() == pokemon2.getKampfpunkte() &&
				pokemon1.getAngriffspunkte() == pokemon2.getAngriffspunkte() &&
				pokemon1.getVerteidigungspunkte() == pokemon2.getVerteidigungspunkte() &&
				pokemon1.getGroesse() == pokemon2.getGroesse() &&
				pokemon1.getGewicht() == pokemon2.getGewicht());
	}

	// http://gamingnewstime.de/pokemon-go-dieser-statistik-wert-von-abra-wird-die-meisten-von-euch-ueberraschen/

	// http://www.pokewiki.de/Rangliste_der_Pok%C3%A9mon
}
