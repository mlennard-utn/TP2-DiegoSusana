package ar.edu.utn.java.intermedio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.utn.java.intermedio.domain.Response;
import ar.edu.utn.java.intermedio.domain.ResultadoOperacion;
import ar.edu.utn.java.intermedio.service.DateService;

@RestController
@RequestMapping("/dates")
public class DateController {

	@Autowired
	private DateService dateService;
	
	@GetMapping(value = "/ultimoDiaMesAno/{anio}")
	public ResponseEntity<Response> getUltimoDiaMesAno(@PathVariable Integer anio, @RequestParam(value="mes") Integer mes ) {
		ResultadoOperacion responseOperation = new ResultadoOperacion();
    	try {
    		responseOperation = dateService.ultimoDiaMesAno(mes, anio);
    	} catch(RuntimeException e) {
    		e.printStackTrace();
    		Response response = new Response();
    		response.setResponseCode(400);
    		response.setResponseMessage(e.getMessage());
    		return ResponseEntity.badRequest().body(response);
    	}
		return ResponseEntity.ok(responseOperation);
		
	}
    
    
}
