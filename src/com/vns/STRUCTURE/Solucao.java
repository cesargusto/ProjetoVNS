package com.vns.STRUCTURE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.vns.PROBLEM.UPMSTP.*;

public class Solucao implements Cloneable{

	private ArrayList<Maquina> solucao;
	
	public Solucao(){
		this.solucao = new ArrayList<>();
	}
	public Solucao(Maquina maq){
		this.solucao = new ArrayList<>();
		this.solucao.add(maq);
	}
	
	@Override
	public Solucao clone() throws CloneNotSupportedException {
		Solucao solCp = new Solucao();
		int tam = solucao.size();
		for(int i = 0;i < tam;i++){
			solCp.solucao.add(new Maquina());
			int tam_mq = this.solucao.get(i).getTamMaq();
			for(int j = 0;j < tam_mq;j++){
				int elemento = this.solucao.get(i).getJob(j);
				solCp.getMaq(i).setJobMaq(elemento);
			}
		}
		return solCp;
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
			pm2 = rnd.nextInt(this.getMaq(indice_maior).getTamMaq() - 1);
		}
		
		int job = this.solucao.get(indice_maior).getJob(pm1);
		this.solucao.get(indice_maior).removeJob(pm1);
		this.solucao.get(indice_maior).setJobMaq(pm2, job);
		
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
		
		//test if not same machines
		while(indice_maq1 == indice_maq2) {
			indice_maq1 = rnd.nextInt(Instance.numMachines);
			indice_maq2 = rnd.nextInt(Instance.numMachines);
		}
		
		//get the size of machine chosen
		int tamanho_maq1 = this.getMaq(indice_maq1).getTamMaq();
		int p1_m1 = rnd.nextInt(tamanho_maq1);//get a random position in this machine
		//get the job of random position
		int job_m1 = this.solucao.get(indice_maq1).getJob(p1_m1); 
		//get the size of the second machine
		int tamanho_maq2 = this.getMaq(indice_maq2).getTamMaq();
		int p1_m2 = rnd.nextInt(tamanho_maq2);
		//set the job of first machine in random position of the second machine
		this.solucao.get(indice_maq2).setJobMaq(p1_m2, job_m1);
		this.solucao.get(indice_maq1).removeJob(p1_m1);	//remove this job of first machine	
		
		
		tamanho_maq2 = this.getMaq(indice_maq2).getTamMaq();
		p1_m2 = rnd.nextInt(tamanho_maq2);
		
		int job_m2 = this.solucao.get(indice_maq2).getJob(p1_m2); 
		//test if it the same job
		while(job_m1 == job_m2) {
			p1_m2 = rnd.nextInt(tamanho_maq2);
			job_m2 = this.solucao.get(indice_maq2).getJob(p1_m2);
		}

		tamanho_maq1 = this.getMaq(indice_maq1).getTamMaq();
		int p2_m1 = rnd.nextInt(tamanho_maq1);
		
		this.solucao.get(indice_maq1).setJobMaq(p2_m1, job_m2);
		this.solucao.get(indice_maq2).removeJob(p1_m2);
		
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
	
	public void gera_vizinho(){
		ArrayList<Integer> maior_menor = new ArrayList<>(this.maior_menor());
		int indice_maior = maior_menor.get(2);
		
		Random rnd = new Random();
		int num_movimentos = 5;
		int opcao = 1 + rnd.nextInt(num_movimentos);
		switch(opcao){
		case 1:
			task_move();
			break;
		case 2:
			shift();
			break;
		case 3:
			Switch();
			break;
		case 4:
			if(solucao.get(maior_menor.get(0)).getTamMaq() > 2)
				Swap();
			else
				task_move();
			break;
		case 5:
			if(solucao.get(indice_maior).getTamMaq() > 2)
				two_realloc();
			else
				Switch();
			break;
		default:
			System.out.println("Problema com o valor aleatório.");
		}
		System.out.println("Movimento escolhido:\t"+opcao+"\n");
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
