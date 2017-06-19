package models;

import java.awt.Component;
import java.util.ArrayList;


public class Pokemon {

	//atributos
	protected String nombre;
	protected String numero;
	protected String nivelEvolucion;
	protected String region;
	protected String tipo;
	protected String comentarios;
	private ArrayList<Pokemon> listaPokemon;
	
	//Constructor
	public Pokemon(String nombre, String numero, String nivelEvolucion, String region, String tipo, String Comentarios) {
		this.nombre = nombre;
		this.numero = numero;
		this.nivelEvolucion = nivelEvolucion;
		this.region = region;
		this.tipo = tipo;
		this.comentarios=comentarios;
	}
	
	//Metodo ToString
	@Override
	public String toString() {
		return "Pokemon [nombre=" + nombre + ", numero=" + numero + ", nivelEvolucion=" + nivelEvolucion + ", region="
				+ region + ", tipo=" + tipo + ", comentarios=" + comentarios + "]";
	}


	//Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNivelEvolucion() {
		return nivelEvolucion;
	}

	public void setNivelEvolucion(String nivelEvolucion) {
		this.nivelEvolucion = nivelEvolucion;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	
	public ArrayList<Pokemon> getListaPokemon() {
		return listaPokemon;
	}

	public void setListaCoches(ArrayList<Pokemon> listaPokemon) {
		this.listaPokemon = listaPokemon;
	}
	
	
	
	
}
