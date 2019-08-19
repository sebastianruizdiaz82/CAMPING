package Logica;

import java.io.Serializable;
import java.util.Calendar;

public class Fechas implements Serializable {
	  Calendar fecha = Calendar.getInstance();
      //en este objeto fecha quedo cargado no solo el dia, sino el exacto momento en que se invoca. 
      // para saber el dia:
      int dia = fecha.get(Calendar.DAY_OF_MONTH);
      // de que mes se trata, considerando que enero es el mes 0, diciembre el mes 11
      int mes = fecha.get(Calendar.MONTH);
      //el anio
      int anio = fecha.get(Calendar.YEAR);
      
 
}
    