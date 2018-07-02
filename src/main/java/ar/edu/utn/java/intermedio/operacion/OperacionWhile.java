package ar.edu.utn.java.intermedio.operacion;

import java.util.List;

public class OperacionWhile extends Benchmark {

	@Override
	public void imprimir(List<Integer> items) {
		int n=0;
		while(n<items.size()) {
			System.out.println("item en while: "+items.get(n).toString());
			n++;
		}
	}

	@Override
	public Double sumar(List<Integer> items) {
		double suma=0;
		int n=0;
		while(n<items.size()) {
			suma+=items.get(n);
			n++;
		}
		return suma;
	}

	@Override
	public Double maximo(List<Integer> items) {
		double maximo=0;
		int n=0;
		maximo=items.get(n);
		while(n<items.size()) {
			if(maximo<items.get(n))
				maximo=items.get(n);
			n++;
		}
		return maximo;
	}

}
