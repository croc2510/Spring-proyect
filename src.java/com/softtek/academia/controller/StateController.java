package com.softtek.academia.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.softtek.academia.conf.MyConnection;
import com.softtek.academia.model.City;
import com.softtek.academia.model.State;

public class StateController {
	
	public static void main(String[] args) {
		StateController controller = new StateController();
		List<State> states = controller.getStates();
		
		for(State s : states) {
			System.out.println(s.getDescription());
		}
	}

	public List<State> getStates(){
		
		// nueva instancia de la conexion
		Connection connection = MyConnection.getConnection();
		
		// query para obtener los estados (states)
		String sqlQuery = "SELECT * FROM state";
		
		// lista final de todos los estados 
		List<State> statesDB = new ArrayList<State>();
		
		// instancia del statment
		Statement stmt = null;

		try {
			
			//de la instancia de conexion crea un statement.
			stmt = connection.createStatement();
			
			// ejecuta el statement con el query indicado.
		    ResultSet rs = stmt.executeQuery(sqlQuery);
		    
		    // loop para leer los resultados de la consulta.
		    while(rs.next()) {
		    	
		    	State estado = new State();
		    	estado.setDescription(rs.getString("description"));
		    	estado.setId(rs.getInt("state_id"));
		    	
		    	statesDB.add(estado);
		    	
		    	
		    }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return statesDB;
	}
	
	
	public List<City> getCities(){
		
		
		// nueva instancia de la conexion
		Connection connection = MyConnection.getConnection();
				
		// query para obtener los estados (states)
		String sqlQuery = "SELECT * FROM city";
		
		List<City> cities = new ArrayList<City>();
		
		List<State> estados = this.getStates();
		
		
		// instancia del statment
		Statement stmt = null;
		
	try {
			
			//de la instancia de conexion crea un statement.
			stmt = connection.createStatement();
			
			// ejecuta el statement con el query indicado.
		    ResultSet rs = stmt.executeQuery(sqlQuery);
		    
		    // loop para leer los resultados de la consulta.
		    while(rs.next()) {
		    	
		    	City city = new City();
		    	city.setDescription(rs.getString("description"));
		    	city.setId(rs.getInt("city_id"));
		    	
		    	// solo el id
		    	for(State estado : estados) {
		    		if(estado.getId() == rs.getInt("state_id")) {
				    	city.setState(estado);
		    		}
		    	}
		    	
		    	cities.add(city);
		    	
		    	
		    }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return cities;
	}
	
	
	
	
	
	
	

}
