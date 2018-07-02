package ar.edu.utn.java.intermedio.operacion;

import java.util.List;

public class OperacionFor extends Benchmark{

	@Override
	public void imprimir(List<Integer> items) {
		for(Integer item:items) {
			System.out.println("item en for: "+item.toString());
		}
		
	}

	@Override
	public Double sumar(List<Integer> items) {
		double suma=0;
		for(Integer item:items) {
			suma+=item;
		}
		return suma;
	}

	@Override
	public Double maximo(List<Integer> items) {
		double maximo, minimo;
		minimo=maximo=items.get(0);
		for(Integer item:items) {
			if(minimo>item)
			{
				minimo=item;
			}
			if(maximo<item)
			{
				maximo=item;
			}
		}
		System.out.println("El máximo es " + maximo + " y el minimo es " + minimo);
		
		return maximo;
	}

}
