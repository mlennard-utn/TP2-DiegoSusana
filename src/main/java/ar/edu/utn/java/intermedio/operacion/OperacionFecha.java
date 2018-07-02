package ar.edu.utn.java.intermedio.operacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OperacionFecha {
	
	//protected abstract LocalDate calcularDia(int anio, int mes); 
	
	public int calcular(int anio, int mes){
		LocalDate date = null;
	    date = LocalDate.of(anio,mes,1);
	    int ultimoDia=date.lengthOfMonth();
		return ultimoDia;
	}
	
	public String generarFecha(int anio, int mes) {
		LocalDate date = null;
	    date = LocalDate.of(anio,mes,1);
	    int ultimoDia=date.lengthOfMonth();
	    date =LocalDate.of(anio,mes,ultimoDia);
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String out = date.format(format);
	    System.out.printf("Fecha %s, con el Último dia del mes %d del año %d: ", out, mes, anio);
	    return out;
	}

}
