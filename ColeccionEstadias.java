package Logica;

import java.io.Serializable;
import java.util.Calendar;import java.util.Vector;

import javax.swing.JOptionPane;

public class ColeccionEstadias implements Serializable {
	
	private Estadia [] estadias;
	private int tope;
	
	public ColeccionEstadias(int tamanio){
	estadias=new Estadia[tamanio];
	tope=0;}
	
	
	public void ingresarEstadia(Estadia est){
		estadias[tope] = est;
		tope++;
	}

	
	public Estadia getestadia (long documento){ 
		int i = 0;
		boolean loencontre=false;
	while ((estadias[i]!=null) && (loencontre==false)){
			if (estadias[i].getPersona().getNrocedula()==documento)
				loencontre=true;
				
			else
				i++;
			}
		return estadias[i];
	}
	
	
	
	public void  registrarEgreso(long documento){
		int i = 0;
		boolean loencontre=false;
		while ((estadias[i]!=null) && (loencontre==false)){
			if (estadias[i].getPersona().getNrocedula()==documento){
				loencontre=true;
			} else{
				i++;
			}
		}
		if ((loencontre==true)&&(estadias[i].estadiaok()==false)){  //DEBERIA LANZAR UN MENSAJE CON EL MONTO A COBRAR
				estadias[i].setFechaSalida(Calendar.getInstance());
				estadias[i].calcularMonto();
				double montoacobrar=estadias[i].getMonto();
				JOptionPane.showMessageDialog(null, "El monto de la estadía se modificó. Se deberá cobrar la diferencia"+montoacobrar,
						"CORRECCIÓN DE MONTO", JOptionPane.INFORMATION_MESSAGE);}	
			
		}
	
	//Lista las cabañas ocupadas con el nombre y apellido del titular
	
	public Vector<String> listarCabaniasOcupadasEnFecha (Calendar Fecha){
		Vector <String> CabaniasOcupadasconTitular=new Vector<String>();
		String titularnombre = null;
		String titularapellido=null;
		String id=null;
		char idAux;
		Cabania auxc=null;
		
		for(int i=0;i<tope;i++){
			if(estadias[i].estaActiva(Fecha)) { // (Elimina la posiblidad de listar estadias anteriores)
				if(estadias[i].getLugar() instanceof Cabania){
					titularnombre=estadias[i].getPersona().getNombre();
					titularapellido=estadias[i].getPersona().getApellido();
					auxc =(Cabania)estadias[i].getLugar();
					idAux=auxc.getIdentificador();
					id=Character.toString(idAux);
					CabaniasOcupadasconTitular.addElement(id+"  "+titularnombre+"  "+titularapellido);}
				}
		}

		return CabaniasOcupadasconTitular;
			
		}
	
	//Lista las Parcelas ocupadas con el nombre y apellido del titular
	
	public Vector<String> listarParcelasOcupadasEnFecha (Calendar Fecha){
		Vector <String> ParcelasOcupadasconTitular=new Vector<String>(20, 5);
		String titularnombre = null;
		String titularapellido=null;
		String id=null;
		Parcela auxp=null; //necesario para castear y poder pedirle el id a la clase derivada.
		
		for(int i=0;i<tope;i++){
			if (estadias[i]!=null){
			if(estadias[i].estaActiva(Fecha)) { // (Elimina la posiblidad de listar estadias anteriores)
				if(estadias[i].getLugar() instanceof Parcela){
					titularnombre=estadias[i].getPersona().getNombre();
					titularapellido=estadias[i].getPersona().getApellido();
					auxp =(Parcela)estadias[i].getLugar();
					id=Integer.toString(auxp.getNumero());
					ParcelasOcupadasconTitular.addElement(id+"  "+titularnombre+" "+titularapellido);}}}}

			return ParcelasOcupadasconTitular;
			
		}
	
	//Cuenta la cantidad de huespedes en determinado dia
	
	public int totalhuspedesdia (Calendar dia){
		int totalhuespedes=0;
		for(int i=0;i<tope;i++){
			if(estadias[i]!=null){
			if(estadias[i].estaActiva(dia)){
				totalhuespedes=totalhuespedes+estadias[i].getCantidad();}}}
		
		return totalhuespedes;
		}
	
	
	//para un determinado mes y año, calcula el monto total ingresado por estadias.
	
	public double montoIngresadoenelMes (int Mes, int Año){
		double montoIngresado=0;
		
		for(int i=0;i<tope;i++){
			if (estadias[i].getFechaIngreso().get(Calendar.MONTH)==Mes&&estadias[i].getFechaIngreso().get(Calendar.YEAR)==Año){
				
			montoIngresado=montoIngresado+estadias[i].getMonto();
		}}
		return montoIngresado;
	}
	
	//Calcula el promedio historico de dias de las estadias para las parcelas
	
	public double promediodiasParcelas (){
		int dias=0;
		int cantestadias=0;
		boolean puedodividir= false;
		double promediodias=0;
		for(int i=0;i<tope;i++){
			if ((estadias[i]!=null)&&(estadias[i].getLugar()instanceof Parcela)){
			dias=dias+estadias[i].duracionestadia();
			cantestadias++;
			puedodividir= true;
		}}
		if (puedodividir)
			promediodias=dias/cantestadias;
		return promediodias;
	}
	
	
	//Calcula el promedio historico de dias de las estadias para las Cabañas
	
	public double promediodiasCabanias (){
		int dias=0;
		int cantestadias=0;
		double promediodias=0;
		boolean puedodividir= false;
		for(int i=0;i<tope;i++){
			if ((estadias[i].getLugar()instanceof Cabania)){
			dias=dias+estadias[i].duracionestadia();
			cantestadias++;
			puedodividir= true;
		}}
		if (puedodividir)
		promediodias=dias/cantestadias;
		return promediodias;
	}
	

	public boolean tieneEstadiasActivas (Persona p){
		boolean tieneestadias = false;
		
		for (int i=0;i<tope;i++){
			if (p.equals(estadias[i].getPersona() )&& estadias[i].estaActiva(Calendar.getInstance())){
					tieneestadias=true;
			}
		}
		return tieneestadias;
	}
}
	
