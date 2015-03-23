package interfaces;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class ListaDeInterfaces {
	//atributos
	private static Enumeration<NetworkInterface> listaNICSCompleta;
	private static ArrayList<NetworkInterface> listaNICSDepurada;
	private static Interfaz[] interfaces;
	
	//constructor
	public ListaDeInterfaces(){
		obtenerInterfaces(); //obteniendo interfaces y metiéndolas en la enumeración
		listaNICSDepurada = depurarInterfaces(listaNICSCompleta); //quitando las intefaces no útiles de la enumeración
		pasarListaInterfacesAArray();
	}
	
	//métodos
	private void obtenerInterfaces(){
		try {
			listaNICSCompleta = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private ArrayList<NetworkInterface> depurarInterfaces(Enumeration<NetworkInterface> nets){
		//aquí se eliminan las interfaces innecesarias de la lista
		//necesario pasar a lista ya que las Enumeration son estáticas y no permiten borrar miembros
		ArrayList<NetworkInterface> listaTemporal = Collections.list(nets);
		
		for (byte i = 0; i < listaTemporal.size(); i++){
			if(!comprobarSiEstaEncendida(listaTemporal.get(i))){
				listaTemporal.remove(i);
				i--;
			}
		}
		return listaTemporal;
	}
	
	private boolean comprobarSiEstaEncendida(NetworkInterface n){
		boolean b = false;
		try {
			b = n.isUp();
		} catch (SocketException e) {
			System.out.println(e.getMessage());
		}
		return b;
	}
	
	private void pasarListaInterfacesAArray(){
		interfaces = new Interfaz[listaNICSDepurada.size()];
		byte i=0;
		for (NetworkInterface n : listaNICSDepurada){
			interfaces[i] = new Interfaz(n.getDisplayName(), n.getInetAddresses());
			i++;
		}
	}
	
	public void imprimirInformacionNombresYDirecciones() {
		ArrayList<NetworkInterface> al = listaNICSDepurada;
		for (NetworkInterface n : al){
			System.out.println(n.getDisplayName());
			Enumeration<InetAddress> ia = n.getInetAddresses();
			for (InetAddress i : Collections.list(ia)){
				System.out.println(i.getHostAddress());
			}
		}
		
	}
	
	public Enumeration<NetworkInterface> devolverListaNICSCompleta(){
		return listaNICSCompleta;
	}
	
	public ArrayList<NetworkInterface> devolverListaNICSDepurada(){
		return listaNICSDepurada;
	}
	//el array tiene sólo la información justa y necesaria. El nombre de la NIC y su IP
	public Interfaz[] devolverArrayInterfaces(){
		
		return interfaces;
	}
}
