/*
 * Nombre: Isaac Aiman Salas
 * Asignatura: Complejidad Computacional
 */
package ull.esit.cuarto.cc.modulo2;

import java.util.ArrayList;


/**
 * Clase que implementa las clausulas del problema 3-SAT-
 * @author Isaac Aiman Salas
 *
 */
public class Clausula {
	
	private ArrayList<String> literales;
	
	/**
	 * Constructor por defecto.
	 */
	public Clausula() {
		
		setLiterales(new ArrayList<String>());
		
	}
	
	public String toString() {
		
		String output = "{";
		
		for (String key : getLiterales()) {
			
			output += key + ", ";
			
		}
		output = output.substring(0, output.length() - 2);
		output += "}";
		
		return output;
		
	}

	/**
	 * @return the literales
	 */
	public ArrayList<String> getLiterales() {
		return literales;
	}

	/**
	 * @param literales the literales to set
	 */
	public void setLiterales(ArrayList<String> literales) {
		this.literales = literales;
	}
	
	
	


	

}
