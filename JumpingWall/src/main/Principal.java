package main;

import interfaces.Interfaz;
import interfaces.ListaDeInterfaces;

public class Principal {
	ListaDeInterfaces ldi;
	
	public Principal() {
		System.out.println(Interfaz.getNumeroInterfaces());
		ldi = new ListaDeInterfaces();
		ldi.imprimirInformacionNombresYDirecciones();
		System.out.println(Interfaz.getNumeroInterfaces());
		
		System.out.println("------------------------------------------");
		
		for (byte i=0; i < Interfaz.getNumeroInterfaces(); i++){
			System.out.println("Interfaz en la posición " + i + ":");
			System.out.println("Nombre = " + ldi.devolverArrayInterfaces()[i].getNombre());
			System.out.println("Dirrección IP = " + ldi.devolverArrayInterfaces()[i].getDireccionRed());
			
			System.out.println("-----");
			System.out.println("");
		}
		
	}
	
	public static void main(String[] args){
		new Principal();
	}
}
