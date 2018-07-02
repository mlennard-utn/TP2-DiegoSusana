package ar.edu.utn.java.intermedio.service;

import org.springframework.stereotype.Service;
import ar.edu.utn.java.intermedio.domain.ResultadoOperacion;
import ar.edu.utn.java.intermedio.operacion.OperacionFecha;

@Service
public class DateService {
	
	public ResultadoOperacion ultimoDiaMesAno(Integer mes, Integer anio) {
		if(mes > 12 || mes <1) {
			throw new RuntimeException(String.format("Error: Mes inválido %d, (Valores de meses entre 1 y 12)", mes));
		}
		else {
			ResultadoOperacion resultado = generarResponse(mes,anio);
			
			/*LocalDate date = null;
		    date = LocalDate.of(anio,mes,1);
		    int ultimoDia=date.lengthOfMonth();
		    date =LocalDate.of(anio,mes,ultimoDia);
		    DateTimeFormatter format;
		    String out = null;
		    format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    out = date.format(format);
		    System.out.printf("Fecha %s, con el Último dia del mes %d del año %d: ", out, mes, anio);*/
		    return resultado;
		}
	}
	
	private ResultadoOperacion generarResponse(int mes, int anio) {
		ResultadoOperacion response = new ResultadoOperacion();
		OperacionFecha fecha = new OperacionFecha();
		response.setFecha(fecha.generarFecha(anio, mes));
		return response;
	}
}
