package Logica;

import java.io.Serializable;
import java.util.Calendar;

public class Estadia implements Serializable {
	
	private Calendar fechaIngreso;
	private Calendar fechaSalida;
	private int cantidad;
	private double monto;
	private Persona persona;
	private Lugar lugar;
	
	//constructores
	public Estadia(Calendar fechaIngreso, Calendar fechaSalida, int cantidad, Persona persona, Lugar lugar) {
		super();
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.cantidad = cantidad;
		this.persona = persona;
		this.lugar = lugar;
		this.monto=0;
	}


	public Estadia(Calendar fechaIngreso, Calendar fechaSalida, int cantidad, double monto, Persona persona, Lugar lugar) {
		super();
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.cantidad = cantidad;
		this.monto = monto;
		this.persona = persona;
		this.lugar = lugar;
	}


	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public Calendar getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getMonto() {
		return monto;
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public Lugar getLugar() {
		return lugar;
	}


	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	//se invoca para saber si en determinada fecha, la estadía está trasncurriendo.

	public boolean estaActiva (Calendar dia) {
		boolean activa=false;
		if ((dia.before(fechaSalida))&&(dia.after(fechaIngreso)))
			activa=true;
			else
				activa=false;
		
				return activa;
		
	}
	
         ////se invoca al hacer el INGRESO para calcular la cantidad de dias.
	
	public int duracionestadia (){
		int dias=1;
		Calendar fi=Calendar.getInstance();
		fi.setTimeInMillis(fechaIngreso.getTimeInMillis());
	     fi.add(Calendar.DAY_OF_MONTH,1);
         while(fi.before(fechaSalida))
         {        	 
        	 fi.add(Calendar.DAY_OF_MONTH, 1);
        	 dias++;
        }         		
		return dias;
	}
	

 	//se invoca al hacer el ingreso para cobrar al titular la cantidad de dias.
	
		public double calcularMonto (){ 
			double montoacobrar=0;
			montoacobrar=(duracionestadia())*lugar.getmontodiario();
			if (lugar instanceof Parcela){
			montoacobrar=montoacobrar*cantidad;}
			setMonto(montoacobrar);
			System.out.println(duracionestadia());
			return montoacobrar;		
			
		}
		
		
		
	
		//se invoca al hacer el egreso, se compara con DURACIONESTADIA(), dentro de ESTADIAOK, comparando
	//si la duración prevista en el check in, es igual a la duración del check out
	public int duracionestadiatotal (){
		int duracionestadiatotal=0;
		Calendar hoy=Calendar.getInstance();
		
		if (fechaSalida==hoy)
			duracionestadiatotal=duracionestadia();
		else 
			
		
	     fechaIngreso.add(Calendar.DAY_OF_MONTH,1);
        while(fechaIngreso.before(hoy))
        {        	 
       	 fechaIngreso.add(Calendar.DAY_OF_MONTH, 1);
       	 duracionestadiatotal++;
       	 }
		
		return duracionestadiatotal;
		}
		
	////Compara si la duración prevista en el check in, es igual a la duración del check out

	public boolean estadiaok (){
	 boolean estadiaok=false;
		if (duracionestadiatotal()==duracionestadia()){
			estadiaok=true;
		}
		else 
			estadiaok=false;
		
		return estadiaok;
	}
	
	  
}

