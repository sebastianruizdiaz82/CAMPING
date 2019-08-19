package Logica;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Vector;

//import persistencia.Persistencia;

public class Sistema implements Serializable {
	private ColeccionEstadias Estadias;
	private ColeccionLugares Lugares;
	private Personas Personas;
	private int CapacidadMaxCabana;
	private int CapacidadMaxParcela;
	private double montoDiarioCabania;
	private double montoDiarioParcela;

	
	
	public Sistema(){
		//Sistema s =this.recuperarSistema();
		Estadias= new ColeccionEstadias(150);
		Lugares= new ColeccionLugares();
		Personas =new Personas(150);
		CapacidadMaxCabana = CapacidadMaxParcela = 0;
		montoDiarioCabania = montoDiarioParcela = 0;
			
	}
	
	public Sistema recuperarSistema(){
		Sistema s=null;
		s=Persistencia.Persistencia.recuperar();
		return s;
		
		
	}
	public ColeccionEstadias getEstadias() {
		return Estadias;
	}
	public void setEstadias(ColeccionEstadias estadias) {
		Estadias = estadias;
	}
	public ColeccionLugares getLugares() {
		return Lugares;
	}
	public void setLugares(ColeccionLugares lugares) {
		Lugares = lugares;
	}
	public int getCapacidadMaxCabana() {
		return CapacidadMaxCabana;
	}
	public void setCapacidadMaxCabana(int capacidadMaxCabana) {
		CapacidadMaxCabana = capacidadMaxCabana;
	}
	public int getCapacidadMaxParcela() {
		return CapacidadMaxParcela;
	}
	public void setCapacidadMaxParcela(int capacidadMaxParcela) {
		CapacidadMaxParcela = capacidadMaxParcela;
	}
	public double getMontoDiarioCabania() {
		return montoDiarioCabania;
	}
	public void setMontoDiarioCabania(int montoDiarioCabania) {
		this.montoDiarioCabania = montoDiarioCabania;
	}
	public double getMontoDiarioParcela() {
		return montoDiarioParcela;
	}
	public void setMontoDiarioParcela(int montoDiarioParcela) {
		this.montoDiarioParcela = montoDiarioParcela;
	}
	
	
	public void Configurar (int cantCab, int cantParc, int maxOcupCab, int maxOcupParc, double precioCab, double precioParc){
			
		this.CapacidadMaxCabana=maxOcupCab;
		this.CapacidadMaxParcela=maxOcupParc;
		this.montoDiarioCabania=precioCab;
		this.montoDiarioParcela=precioParc;
		Lugares.inicializar(cantCab, cantParc); 
		Lugares.guardarencoleccion(precioCab, precioParc);	
	}
	

	
	
public Estadia getestadia(long documento)
{
	return Estadias.getestadia(documento);
}
public Personas getPersonas() {
		return Personas;
	}

	public void setPersonas(Personas personas) {
		Personas = personas;
	}

public Persona buscarPersona(long documento)
{	
	return Personas.buscarPersona(documento);
}



public void ingresarPersona(Persona per) {
	Personas.agregarPersona(per);
	
}



public void IngresoEstadia (Estadia est){

	Estadias.ingresarEstadia(est);
	
}



public Vector <String> listarcabaniasdisponibles (){
	
	return Lugares.listarCabdisponibles() ;
}



public Vector <String> listarParcelasDisponibles (){
	
	return Lugares.listarPardisponibles () ;
}

	
public double promedioLugarCabania (){
	double promedioC=0;
	promedioC=Estadias.promediodiasCabanias();
	
	return promedioC;
}
		
		
public double promedioLugarParcela (){
	double promedioP=0;
	promedioP=Estadias.promediodiasParcelas();
	
	return promedioP;}


		
public int cantidadpersonas (Calendar fecha){
	int cantpersonas=0;
	cantpersonas=Estadias.totalhuspedesdia(fecha);
	
	return cantpersonas;
}
	
public Vector <String> listaCabaniasOcupadasConTitular (Calendar fecha){
	Vector<String> listaCconT=Estadias.listarCabaniasOcupadasEnFecha(fecha);
	System.out.println(listaCconT.size()+" es la cantidad");
	return listaCconT;
	
}

public Vector <String> listaParcelasOcupadasConTitular (Calendar fecha){
	Vector<String> listaPconT=Estadias.listarParcelasOcupadasEnFecha(fecha);
	return listaPconT;}



public void guardar() throws Exception {
	// Persistencia.guardar(this);
	Persistencia.Persistencia.guardar(this);
	
}


public boolean esVacio (){
	boolean esVacio=true;
	if(montoDiarioParcela!=0){
		esVacio=false;}
	return esVacio;
	}

public boolean esTexto (String s){
	boolean esTexto=true;
	char  letra;
	for (int i=0;i<s.length();i++){
		letra=s.charAt(i);
		if (!Character.isLetter(letra)){
			esTexto=false;
		}
	}
	return esTexto;
	
	

	}
	

public Cabania buscarLugarCab (char n){
	return Lugares.buscarLugarCab(n);
}


public Parcela buscarLugarPar (int n){
	
	return Lugares.buscarLugarPar(n);
}


public Vector<String> listarCabaniasOcupadasEnFecha (Calendar Fecha){
	
	return Estadias.listarCabaniasOcupadasEnFecha(Fecha);
}



public boolean tieneEstadiasActivas (Persona p){
	
	return Estadias.tieneEstadiasActivas(p);
}



public void  registrarEgreso(long documento){
	Estadias.registrarEgreso(documento);
}

public int totalhuspedesdia (Calendar dia){
	
	return Estadias.totalhuspedesdia(dia);
}


public double promediodiasParcelas (){
	return Estadias.promediodiasParcelas();
}

public double promediodiasCabanias (){
	
	return Estadias.promediodiasCabanias();
}

public double montoIngresadoenelMes (int Mes, int Año){
	
	return Estadias.montoIngresadoenelMes(Mes, Año);
}




}
