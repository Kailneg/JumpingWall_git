package datos;

public class DatosDeRed {
	//atributos
	private String ip, mascara, dns;
	private final String dnsPorDefecto = "8.8.8.8";
	
	//constructor
	DatosDeRed (String ip, String mascara, String dns){
		this.ip = ip;
		this.mascara = mascara;
		this.dns = dns; 
	}
	
	//métodos
	
	
	
	
	
	
	
	//GETTERS AND SETTERS -------------------------------------

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	public String getDns() {
		return dns;
	}

	public void setDns(String dns) {
		this.dns = dns;
	}

	public String getDnsPorDefecto() {
		return dnsPorDefecto;
	}
	
	
}
