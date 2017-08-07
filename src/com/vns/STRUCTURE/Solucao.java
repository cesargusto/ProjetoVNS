package com.vns.STRUCTURE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.vns.PROBLEM.UPMSTP.*;

public class Solucao {

	private ArrayList<Maquina> solucao;
	
	public Solucao(){
		this.solucao = new ArrayList<>();
	}
	public Solucao(Maquina maq){
		this.solucao = new ArrayList<>();
		this.solucao.add(maq);
	}
	
	public void ConstroiSolution(){
		ArrayList<Integer> candidatos = new ArrayList<>(Instance.numJobs);
		for(int i = 0;i < Instance.numJobs;i++){
			candidatos.add(i);
		}
		for(int x = 0;x < Instance.numMachines;x++){
			this.setMaqSolucao(new Maquina());
		}
		
		int k = 0;
		while(k < Instance.numJobs){
			for(int j = 0;j < Instance.numMachines;j++){
				this.solucao.get(j).setJobMaq(candidatos.get(k));
				k++;
				if(k >= Instance.numJobs)
					break;
				} 
		}
	}
	
	public int makespan(){
		int mspan = 0;
		ArrayList<Integer>mspans = new ArrayList<>(Instance.numMachines);
		for(int t = 0;t < Instance.numMachines;t++){
			mspans.add(this.getMaq(t).tempoMaq(t));
		}
		mspan = Collections.max(mspans);
		return mspan;
	}	
	

	public ArrayList<Integer> maior_menor(){
		ArrayList<Integer> maior_menor = new ArrayList<>();
		int indice_menor = -1;
		int indice_maior = -1;
		int valor_menor = Integer.MAX_VALUE;
		int valor_maior = Integer.MIN_VALUE;
		int aux = 0;
		
		for(int i = 0;i < Instance.numMachines;i++){
			aux = this.getMaq(i).tempoMaq(i);
			if(aux < valor_menor){
				valor_menor = aux;
				indice_menor = i;
				if(valor_menor > valor_maior){
					valor_maior = valor_menor;
					indice_maior = i;
					}
			}
			if(aux > valor_maior){
				valor_maior = aux;
				indice_maior = i;
				if(valor_maior < valor_menor){
					valor_menor = valor_maior;
					indice_maior = i;
				}
			}
		}
		maior_menor.add(indice_menor);
		maior_menor.add(valor_menor);
		maior_menor.add(indice_maior);
		maior_menor.add(valor_maior);
		
		return maior_menor;
	}
	
	public void task_move(){
		Random rnd = new Random();
		ArrayList<Integer> maior_menor = new ArrayList<>(this.maior_menor());
		
		int indice_menor = maior_menor.get(0);
		int indice_maior = maior_menor.get(2);
		
		int pm1 = rnd.nextInt(this.getMaq(indice_maior).getTamMaq());
		int pm2 = rnd.nextInt(this.getMaq(indice_menor).getTamMaq());
		
		int job = this.solucao.get(indice_maior).getJob(pm1);
		this.solucao.get(indice_menor).setJobMaq(pm2, job);
		this.solucao.get(indice_maior).removeJob(pm1);
		
		
	}
	
	public void shift(){
		Random rnd = new Random();
		ArrayList<Integer> maior_menor = new ArrayList<>(this.maior_menor());
		
		int indice_maior = maior_menor.get(2);
		
		int pm1 = -1;
		int pm2 = -1;
		
		while(pm1 == pm2){
			pm1 = rnd.nextInt(this.getMaq(indice_maior).getTamMaq());
			pm2 = rnd.nextInt(this.getMaq(indice_maior).getTamMaq());
		}
		
		int job = this.solucao.get(indice_maior).getJob(pm1);
		this.solucao.get(indice_maior).setJobMaq(pm2, job);
		this.solucao.get(indice_maior).removeJob(pm1);
	}
	
	public void Switch() {
		Random rnd = new Random();
		ArrayList<Integer> maior_menor = new ArrayList<>(this.maior_menor());
		
		int indice_maior = maior_menor.get(2);
		
		int pm1 = -1;
		int pm2 = -1;
		
		while(pm1 == pm2){
			pm1 = rnd.nextInt(this.getMaq(indice_maior).getTamMaq());
			pm2 = rnd.nextInt(this.getMaq(indice_maior).getTamMaq());
		}
		
		this.solucao.get(indice_maior).trocaJob(pm1, pm2);
		
	}
	
	public void Swap() {
		Random rnd = new Random();
		
		int indice_maq1 = -1;
		int indice_maq2 = -1;
		
		while(indice_maq1 == indice_maq2) {
			indice_maq1 = rnd.nextInt(Instance.numMachines);
			indice_maq2 = rnd.nextInt(Instance.numMachines);
		}
		int tamanho_maq = this.getMaq(indice_maq1).getTamMaq();
		int pm1_m1 = rnd.nextInt(tamanho_maq);
		int	pm2_m1 = rnd.nextInt(this.getMaq(indice_maq1).getTamMaq());
		
		int pm1_m2 = rnd.nextInt(this.getMaq(indice_maq2).getTamMaq());
		int	pm2_m2 = rnd.nextInt(this.getMaq(indice_maq2).getTamMaq());
		
		int job_m1 = this.solucao.get(indice_maq1).getJob(pm1_m1); 
		this.solucao.get(indice_maq2).setJobMaq(pm1_m2, job_m1);
		this.solucao.get(indice_maq1).removeJob(pm1_m1);
		
		int job_m2 = this.solucao.get(indice_maq2).getJob(pm2_m2); 
		this.solucao.get(indice_maq1).setJobMaq(pm2_m1, job_m2);
		this.solucao.get(indice_maq2).removeJob(pm2_m2);
		
	}
	
	public void two_realloc(){
		Random rnd = new Random();
		
		ArrayList<Integer> maior_menor = new ArrayList<>(this.maior_menor());
		
		int indice_maior = maior_menor.get(2);
		
		int pm1 = -1;
		int pm2 = -1;
		
		while(pm1 == pm2){
			pm1 = rnd.nextInt(this.getMaq(indice_maior).getTamMaq());
			pm2 = rnd.nextInt(this.getMaq(indice_maior).getTamMaq());
		}
		
		this.solucao.get(indice_maior).trocaJob(pm1, pm2);
		
		pm1 = -1;
		pm2 = -1;
		
		while(pm1 == pm2){
			pm1 = rnd.nextInt(this.getMaq(indice_maior).getTamMaq());
			pm2 = rnd.nextInt(this.getMaq(indice_maior).getTamMaq());
		}
		
		this.solucao.get(indice_maior).trocaJob(pm1, pm2);
	}
	
	public ArrayList<Maquina> getSolucao() {
		return solucao;
	}
	
	public Maquina getMaq(int i) {
		return solucao.get(i);
	}
	public void setMaqSolucao(Maquina maq) {
		this.solucao.add(maq);
	}
	
	public void imprimeSolucao(){
		for(int x = 0;x < Instance.numMachines;x++){
			System.out.printf("Maq-%d\tTempo: %d\n",x,this.solucao.get(x).tempoMaq(x));
			for(int y = 0;y < this.getMaq(x).getTamMaq();y++){
				System.out.printf("%d ",this.solucao.get(x).getJob(y));
			}
			//System.out.printf("\nTempo:\t%d \n",this.solucao.get(x).tempoMaq(x));
			System.out.println();
		}
		System.out.println("Makespan .........:"+this.makespan());
		System.out.println();
	}
	
	
}
