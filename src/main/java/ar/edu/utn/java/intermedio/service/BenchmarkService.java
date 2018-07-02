package ar.edu.utn.java.intermedio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import ar.edu.utn.java.intermedio.domain.BenchmarkResponse;
import ar.edu.utn.java.intermedio.operacion.Benchmark;
import ar.edu.utn.java.intermedio.operacion.OperacionFor;
import ar.edu.utn.java.intermedio.operacion.OperacionStreams;
import ar.edu.utn.java.intermedio.operacion.OperacionWhile;

@Service
public class BenchmarkService {
	
	private static final Integer CANTIDAD_MAXIMA_ITEMS = 50000000;
	
	public BenchmarkResponse imprimir(Integer cantidadItems) {
		
		if(cantidadItems > CANTIDAD_MAXIMA_ITEMS) {
			throw new RuntimeException(String.format("Error: la cantidad maximo de items %d no debe superar el valor %d", 
					cantidadItems, CANTIDAD_MAXIMA_ITEMS));
		}
		else {
			BenchmarkResponse response = inicializarResponse(cantidadItems);
			long tiempo = System.currentTimeMillis();
			tiempo=tiempoSeg(tiempo);
		
			Benchmark operacion = new OperacionStreams();
			operacion.imprimirListado(response.getItems());
		
			response.setTiempoStreams(((System.currentTimeMillis()/1) - tiempo) );
		
			tiempo = System.currentTimeMillis();
			tiempo=tiempoSeg(tiempo);
			
			operacion = new OperacionFor();
			operacion.imprimirListado(response.getItems());
			response.setTiempoFor(((System.currentTimeMillis()/1) - tiempo));
			

			tiempo = System.currentTimeMillis();
			tiempo=tiempoSeg(tiempo);
			
			operacion = new OperacionWhile();
			operacion.imprimirListado(response.getItems());
			response.setTiempoWhile(((System.currentTimeMillis()/1) - tiempo));
			

			return response;
		}
	}

	
	public long tiempoSeg(long tiempo) {
		return tiempo/1;
	}

	
	public BenchmarkResponse sumar(Integer cantidadItems) {
		
		if(cantidadItems > CANTIDAD_MAXIMA_ITEMS) {
			throw new RuntimeException(String.format("Error: la cantidad maximo de items %d no debe superar el valor %d", 
					cantidadItems, CANTIDAD_MAXIMA_ITEMS));
		}
		else {
			BenchmarkResponse response = inicializarResponse(cantidadItems);
			long tiempo = System.currentTimeMillis();
			tiempo=tiempoSeg(tiempo);
		
			Benchmark operacion = new OperacionStreams();
			response.setResultado(operacion.sumarValores(response.getItems()));
			response.setTiempoStreams(((System.currentTimeMillis()/1) - tiempo) );
		
			tiempo = System.currentTimeMillis();
			tiempo=tiempoSeg(tiempo);
			
			operacion = new OperacionFor();
			response.setResultado(operacion.sumarValores(response.getItems()));
			response.setTiempoFor(((System.currentTimeMillis()/1) - tiempo));
			
			tiempo = System.currentTimeMillis();
			tiempo=tiempoSeg(tiempo);
			
			operacion = new OperacionWhile();
			response.setResultado(operacion.sumarValores(response.getItems()));
			response.setTiempoWhile(((System.currentTimeMillis()/1) - tiempo) );
			
			tiempo = System.currentTimeMillis();
			tiempo=tiempoSeg(tiempo);
		
			return response;
		}
	}
	
	public BenchmarkResponse maximo(Integer cantidadItems) {
		if(cantidadItems > CANTIDAD_MAXIMA_ITEMS) {
			throw new RuntimeException(String.format("Error: la cantidad maximo de items %d no debe superar el valor %d", 
					cantidadItems, CANTIDAD_MAXIMA_ITEMS));
		}
		else {
			BenchmarkResponse response = inicializarResponse(cantidadItems);
			long tiempo = System.currentTimeMillis();
			tiempo=tiempoSeg(tiempo);
		
			Benchmark operacion = new OperacionStreams();
			response.setResultado(operacion.maximoValor(response.getItems()));
			response.setTiempoStreams(((System.currentTimeMillis()/1) - tiempo) );
		
			tiempo = System.currentTimeMillis();
			tiempo=tiempoSeg(tiempo);
			
			Benchmark operacion2 = new OperacionFor();
			response.setResultado(operacion2.maximoValor(response.getItems()));
			response.setTiempoFor(((System.currentTimeMillis()/1) - tiempo));
		
			tiempo = System.currentTimeMillis();
			tiempo=tiempoSeg(tiempo);
			
			
			Benchmark operacion3 = new OperacionWhile();
			response.setResultado(operacion3.maximoValor(response.getItems()));
			response.setTiempoWhile(((System.currentTimeMillis()/1) - tiempo));
		
			tiempo = System.currentTimeMillis();
			tiempo=tiempoSeg(tiempo);
		
			return response;
		}
	}
	
	private List<Integer> generarItems(Integer cantidadItems){
		if(cantidadItems > CANTIDAD_MAXIMA_ITEMS) {
			throw new RuntimeException(String.format("Error: la cantidad maximo de items %d no debe superar el valor %d", 
					cantidadItems, CANTIDAD_MAXIMA_ITEMS));
		}
		else {
			List<Integer> items = new ArrayList<>();
			Random rnd = null;
			int num=0;
			for(int i = 0; i < cantidadItems; i++) {
				rnd=new Random();
				num=rnd.nextInt(cantidadItems);
				items.add(num);
				//items.add(i);
				System.out.println("Item aleatorio: "+num);
			}
			if(cantidadItems>100) {
				return mostrarItems(items);
			}
			return items;
		}
	}
	
	private List<Integer> mostrarItems(List<Integer> items){
		List<Integer> itemsMostrar = new ArrayList<>();
		int i=0;
		for (i=0;i<50;i++) {
			itemsMostrar.add(items.get(i));
		}
		i=0;
		for(i=(items.size()-50); i<items.size();i++) {
			itemsMostrar.add(items.get(i));
		}
		return itemsMostrar;
	}

	private BenchmarkResponse inicializarResponse(Integer cantidadItems) {
		BenchmarkResponse response = new BenchmarkResponse();
		List<Integer> items = generarItems(cantidadItems);
		response.setItems(items);
		return response;
	}
	
}
