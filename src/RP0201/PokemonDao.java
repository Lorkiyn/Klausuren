// DQM15 - RP - LK1
// Name: Köhler
// Vorname: Darian

package RP0201;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PokemonDao {

	private final String DBNAME = "Pokemon";
	private final String PATH = "jdbc:sqlite:" + DBNAME + ".db";
	private Connection conn;

	public PokemonDao() {
		getConn();
		createTable();
	}

	public void printDB() {
		Statement s = null;
		String sql = "SELECT * FROM " +DBNAME;

		try {
			s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);

			System.out.println("Name\t\tKP\tAP\tVP\tIP\tGR\tGE");
			while(rs.next()) {
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("kampfpunkte") + "\t");
				System.out.print(rs.getString("angriffspunkte") + "\t");
				System.out.print(rs.getString("verteidigungspunkte") + "\t");
				System.out.print(rs.getString("initiativepunkte") + "\t");
				System.out.print(rs.getString("groesse") + "\t");
				System.out.print(rs.getString("gewicht") + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void getConn() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(PATH);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void createTable() {
		PreparedStatement ps = null;
		String table = "CREATE TABLE IF NOT EXISTS " +DBNAME
				+ "("
				+ "name VARCHAR(30) PRIMARY KEY NOT NULL,"
				+ "kampfpunkte INTEGER NOT NULL,"
				+ "angriffspunkte INTEGER NOT NULL,"
				+ "verteidigungspunkte INTEGER NOT NULL,"
				+ "initiativepunkte INTEGER NOT NULL,"
				+ "groesse DOUBLE NOT NULL,"
				+ "gewicht DOUBLE NOT NULL"
				+ ")";

		try {
			ps = conn.prepareStatement(table);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Pokemon create() {
		return new Pokemon();
	}

	public void insert(Pokemon pokemon) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO " + DBNAME
				+"("
				+ "name,"
				+ "kampfpunkte,"
				+ "angriffspunkte,"
				+ "verteidigungspunkte,"
				+ "initiativepunkte,"
				+ "groesse,"
				+ "gewicht"
				+ ")"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pokemon.getName());
			ps.setInt(2, pokemon.getKampfpunkte());
			ps.setInt(3, pokemon.getAngriffspunkte());
			ps.setInt(4, pokemon.getVerteidigungspunkte());
			ps.setInt(5, pokemon.getInitiativepunkte());
			ps.setDouble(6, pokemon.getGroesse());
			ps.setDouble(7, pokemon.getGewicht());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void clearTable() {
		String sql = "SELECT * FROM " + DBNAME;
		String sqlDelete = "DELETE FROM " + DBNAME + " WHERE name=?";
		Statement s = null;
		ResultSet rs = null;
		try {
			s = conn.createStatement();
			s.executeQuery(sql);

			rs = s.executeQuery(sql);
			while(rs.next()) {
				PreparedStatement ps = conn.prepareStatement(sqlDelete);
				ps.setString(1, rs.getString("name"));
				ps.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				s.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Pokemon search(String name) throws PokemonNotFoundException {
		Pokemon pokemon = new Pokemon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + DBNAME + " WHERE name=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeQuery();

			rs = ps.executeQuery();
			pokemon.setName(rs.getString("name"));
			pokemon.setKampfpunkte(rs.getInt("kampfpunkte"));
			pokemon.setAngriffspunkte(rs.getInt("angriffspunkte"));
			pokemon.setVerteidigungspunkte(rs.getInt("verteidigungspunkte"));
			pokemon.setInitiativepunkte(rs.getInt("initiativepunkte"));
			pokemon.setGroesse(rs.getFloat("groesse"));
			pokemon.setGewicht(rs.getFloat("gewicht"));

		} catch (SQLException e) {
			throw new PokemonNotFoundException(name);
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pokemon;
	}

	public void update(Pokemon pokemon) {
		String sql = "UPDATE " +DBNAME +" SET kampfpunkte=?, angriffspunkte=?, verteidigungspunkte=?, initiativepunkte=?, groesse=?, gewicht=? WHERE name=?";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pokemon.getKampfpunkte());
			ps.setInt(2, pokemon.getAngriffspunkte());
			ps.setInt(3, pokemon.getVerteidigungspunkte());
			ps.setInt(4, pokemon.getInitiativepunkte());
			ps.setDouble(5, pokemon.getGroesse());
			ps.setDouble(6, pokemon.getGewicht());
			ps.setString(7, pokemon.getName());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean isAllowedFeature(String feature) {
		String[] features = {"kampfpunkte", "angriffspunkte", "verteidigungspunkte", "initiativepunkte", "groesse", "gewicht"};
		for(int i = 0; i < features.length; i++) {
			if(feature.equalsIgnoreCase(features[i])) {
				return true;
			}
		}
		return false;
	}

	public Pokemon getPokemonWithMaxFeature(String feature) throws PokemonFeatureNotFoundException {
		if(!isAllowedFeature(feature)) {
			throw new PokemonFeatureNotFoundException(feature);
		}
		
		String sql = "SELECT * FROM " + DBNAME + " WHERE " + feature + "=(SELECT MAX(" + feature + ") FROM " + DBNAME + ")";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pokemon pokemon = new Pokemon();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
			
			rs = ps.executeQuery();
			pokemon.setName(rs.getString("name"));
			pokemon.setKampfpunkte(rs.getInt("kampfpunkte"));
			pokemon.setAngriffspunkte(rs.getInt("angriffspunkte"));
			pokemon.setVerteidigungspunkte(rs.getInt("verteidigungspunkte"));
			pokemon.setInitiativepunkte(rs.getInt("initiativepunkte"));
			pokemon.setGroesse(rs.getFloat("groesse"));
			pokemon.setGewicht(rs.getFloat("gewicht"));
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return pokemon;
	}
	
	private double getAvgFeature(String feature) {
		String sql = "SELECT AVG(" +feature + ") AS AVG FROM " + DBNAME;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps =  conn.prepareStatement(sql);
			ps.executeQuery();
			
			rs = ps.executeQuery();
			return rs.getDouble("AVG");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	public ArrayList<Pokemon> getPokemonsWithFeatureAboveAverage(String feature) throws PokemonFeatureNotFoundException {
		if(!isAllowedFeature(feature)) {
			throw new PokemonFeatureNotFoundException(feature);
		}
		
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		String sql = "SELECT * FROM " + DBNAME + " WHERE " + feature + ">" +getAvgFeature(feature);
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Pokemon pokemon = new Pokemon();
				pokemon.setName(rs.getString("name"));
				pokemon.setKampfpunkte(rs.getInt("kampfpunkte"));
				pokemon.setAngriffspunkte(rs.getInt("angriffspunkte"));
				pokemon.setVerteidigungspunkte(rs.getInt("verteidigungspunkte"));
				pokemon.setInitiativepunkte(rs.getInt("initiativepunkte"));
				pokemon.setGroesse(rs.getFloat("groesse"));
				pokemon.setGewicht(rs.getFloat("gewicht"));
				
				pokemons.add(pokemon);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pokemons;
	}

	public Pokemon delete(String string) {
		return null;
	}

}
