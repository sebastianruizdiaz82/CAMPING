package Logica;

import java.io.Serializable;

public abstract class Lugar implements Serializable
{

private double montodiario;
private boolean estaOcupado;


public Lugar(double precio, boolean estaOcupado) 

{
	this.montodiario = precio;
	this.estaOcupado = estaOcupado;
}


public double getmontodiario() {
	return montodiario;
}

public void setmontodiario(double precio) {
	this.montodiario = precio;
}

public boolean isEstaOcupado() {
	return estaOcupado;
}

public void setEstaOcupado(boolean estaOcupado) {
	this.estaOcupado = estaOcupado;
}











}








