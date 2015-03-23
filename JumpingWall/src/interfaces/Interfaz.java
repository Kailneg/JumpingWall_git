package interfaces;

import java.net.InetAddress;
import java.util.Enumeration;

public class Interfaz {
	//atributos
	private static byte numeroInterfaces = 0;
	private String nombre;
	private byte posicion;
	private String direccionRed;
	
	
	//constructor
	public Interfaz(String nombre, Enumeration<InetAddress> direccionRed) {
		this.nombre = nombre;
		this.direccionRed = direccionRed.nextElement().getHostAddress();
		this.posicion = numeroInterfaces;
		numeroInterfaces++;
	}

	//métodos
	
	
	
	
	
	//GETTERS AND SETTERS----------------------------------

	public Interfaz getInterfaz() {
		return this;
	}

	public String getNombre(){
		return nombre;
	}
	
	public byte getPosicion(){
		return posicion;
	}
	
	public String getDireccionRed(){
		return direccionRed;
	}
	
	public static byte getNumeroInterfaces(){
		return numeroInterfaces;
	}
}
