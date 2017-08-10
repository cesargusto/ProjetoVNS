package com.vns.METAHEURISTICA;

import com.vns.STRUCTURE.Solucao;

public class ILS {
	private Solucao solucao;
	private int temp_inicial;
	private float alfa;
	private int samax;
	
	public ILS(Solucao solucao, int temp_inical, float alfa, int samax) {
		this.solucao = solucao;
		this.temp_inicial = temp_inicial;
		this.alfa = alfa;
		this.samax = samax;
	}
	
	public void execute() {
		
	}
}
