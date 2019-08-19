package Logica;

import java.io.Serializable;

public class Persona implements Serializable {
	
	private String nombre;
	
	private String apellido;
	
	private String ciudadania;
	
	private String direccion;
	
	private int Telefono;
	
	private String tipodoc;
	
    private long nrotarjeta;
    
    private int nrocedula;
    

	public Persona(String nombre, String apellido, String ciudadania, String direccion, int telefono, String tipodoc,
			long nrotarjeta, int nrocedula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudadania = ciudadania;
		this.direccion = direccion;
		Telefono = telefono;
		this.tipodoc = tipodoc;
		this.nrotarjeta = nrotarjeta;
		this.nrocedula = nrocedula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCiudadania() {
		return ciudadania;
	}


	public void setCiudadania(String ciudadania) {
		this.ciudadania = ciudadania;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getTelefono() {
		return Telefono;
	}


	public void setTelefono(int telefono) {
		Telefono = telefono;
	}


	public String getTipodoc() {
		return tipodoc;
	}


	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}


	public long getNrotarjeta() {
		return nrotarjeta;
	}


	public void setNrotarjeta(int nrotarjeta) {
		this.nrotarjeta = nrotarjeta;
	}


	public int getNrocedula() {
		return nrocedula;
	}


	public void setNrocedula(int nrocedula) {
		this.nrocedula = nrocedula;
	}
	
	
	



		
	}
