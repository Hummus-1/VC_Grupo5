/*
 * Nombre: Isaac Aiman Salas
 * Asignatura: Complejidad Computacional 
 */
package ull.esit.cuarto.cc.modulo2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Clase que representa la estructura de datos del problema del 3-SAT.
 * @author Isaac Aiman Salas
 *
 */
public class SAT3 {

	private ArrayList<String> literales;
	private Integer numeroLiterales;
	private ArrayList<Clausula> clausulas;
	private static final Integer SIZECLAUSULAS = 3; 
	private Integer k;
	
	/**
	 * @return the k
	 */
	public Integer getK() {
		return k;
	}

	/**
	 * @param k the k to set
	 */
	public void setK(Integer k) {
		this.k = k;
	}

	/**
	 * Constructor por defecto.
	 */
	public SAT3() {
		clear();
	}
	
	public void clear() {
		
		setLiterales(new ArrayList<String>());
		setNumeroLiterales(0);
		setClausulas(new ArrayList<Clausula>());
	}

	/**
	 * Carga una instacia del problema del 3-SAT a través de un fichero.
	 */
	public void cargarFichero(String nombreFichero) {
		
		clear();
		
		try {
			Scanner scanner = new Scanner(new File(nombreFichero));
			/*
			 * Añadimos el número de literales del problema. 
			 */
			setNumeroLiterales(scanner.nextInt());
			
			/*
			 * Añadimos los literales del problema del 3SAT al arrayList "literales".
			 */
			for (int i = 0; i < getNumeroLiterales(); i++) {
				getLiterales().add(scanner.next());
			}
			
			/*
			 * Añadimos las clausulas del problema. 
			 *
			 */
			while (scanner.hasNext()) {
				
				Clausula nuevaClausula = new Clausula();
				
				for (int i = 0; i < SIZECLAUSULAS; i++) {
					nuevaClausula.getLiterales().add(scanner.next());
				}
				
				getClausulas().add(nuevaClausula);
			}
			
			setK(new Integer(getLiterales().size() + 2*getClausulas().size()));
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String toString() {
		String output = "<html>U = {";
		
		for (int i = 0; i < numeroLiterales - 1; i++) {
			output += literales.get(i) + ", ";
		}
		
		output += literales.get(numeroLiterales - 1) + "} ";
		
		output += "C = {";
		
		for (Clausula c : getClausulas()) {
			
			output += c + ",";
			
		}
		
		output = output.substring(0, output.length() - 1);
		output += "}<br>k = " + getK() + "</html>";
		
		
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

	/**
	 * @return the numeroLiterales
	 */
	public Integer getNumeroLiterales() {
		return numeroLiterales;
	}

	/**
	 * @param numeroLiterales the numeroLiterales to set
	 */
	public void setNumeroLiterales(Integer numeroLiterales) {
		this.numeroLiterales = numeroLiterales;
	}

	/**
	 * @return the clausulas
	 */
	public ArrayList<Clausula> getClausulas() {
		return clausulas;
	}

	/**
	 * @param clausulas the clausulas to set
	 */
	public void setClausulas(ArrayList<Clausula> clausulas) {
		this.clausulas = clausulas;
	}
	
}
