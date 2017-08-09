package com.vns.METAHEURISTICA;

import java.util.Random;

import com.vns.STRUCTURE.Solucao;

public class SA {
	
	private Solucao solucao;
	private double T_INICIAL;
	private double ALF;
	private int SAMAX;
	
	public SA(Solucao solucao, double t_inicial, float alfa, int samax) {
		this.solucao = solucao;
		this.T_INICIAL = t_inicial;
		this.ALF = alfa;
		this.SAMAX = samax;
	}
	
	public SA(Solucao solucao) {
		this.solucao = solucao;
		this.T_INICIAL = 800.0;
		this.ALF = 0.9;
		this.SAMAX = 100;
	}
	
	public void execute() throws CloneNotSupportedException {
		Solucao melhor_solucao;
		Solucao solucao_linha;
		long fo_solucao = Integer.MAX_VALUE;
		long fo_solucao_linha = Integer.MAX_VALUE;
		int IterT = 0;			// iterations number in temperature
		double T = T_INICIAL;	// initial temperature
		Random rnd = new Random();
		
		melhor_solucao = solucao.clone();	// best solution receive the solution was given
		
		while(T > 0.0001){
			while(IterT < SAMAX){
				IterT += 1;
				
				fo_solucao = solucao.makespan();
				solucao_linha = solucao.clone();
				solucao_linha.gera_vizinho();
				fo_solucao_linha = solucao_linha.makespan();
				
				long Alfa = fo_solucao_linha - fo_solucao;
				
				if(Alfa <= 0){
					solucao = solucao_linha.clone();					
					if(fo_solucao_linha > melhor_solucao.makespan()){
						melhor_solucao = solucao.clone();
					}
					//tb.setMelhores_fo(fo_s_linha); guardar evolução do algoritmo
				}
				else{
					Double x = rnd.nextDouble();
					Double exp = Math.pow(Math.E, (Alfa/T)); 
					if(x < exp){
						solucao = solucao_linha.clone();
					}
				}
			}
			System.out.printf("\nTemperatura:\t%.4f\tMakespan:\t%d\n", T, fo_solucao_linha);
			//tb.setMelhores_fo_sa(s_melhor.calculaFo());guarda evolucao
			T = ALF * T;
			IterT = 0;
		}
		//tb.setMelhor_so_sa_global(s_melhor);
		solucao = melhor_solucao.clone();
		System.out.println("\n\nMELHOR SOLUÇÃO ENCONTRDA:\t\t"+solucao.makespan());
	}
}
