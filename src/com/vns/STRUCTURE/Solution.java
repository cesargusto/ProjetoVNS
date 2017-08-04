package com.vns.STRUCTURE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.vns.PROBLEM.UPMSTP.Job;
import com.vns.PROBLEM.UPMSTP.Machine;

public class Solution implements Cloneable{
	
	private ArrayList<Machine> solution;
	private ArrayList<Integer> makespan;//armazena os tempos totais de cada maquina
	private int qtMqs;
	private int of;
	
	public Solution(ArrayList<Machine> solucao){
		this.solution = solucao;
		this.makespan = null;
		this.of = 0;
	}
	public Solution(){
		this.solution = new ArrayList<>();
		this.makespan = new ArrayList<>();//deve ter o tamanho do numero de maquinas
		this.of = 0;
	}

	@Override
	public Solution clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Solution) super.clone();
	}

	public void RandInitSolution(){

		for(int i = 0;i < Instance.numMachines;i++){
			solution.add(new Machine());
		}
		Random rnd = new Random();
		Job jobaux = null;
		
		for(int i = 0;i < Instance.numJobs;i++){
			int rmaq = rnd.nextInt(Instance.numMachines);
			if(solution.get(rmaq).getMachine().isEmpty())
				solution.get(rmaq).setJob(new Job(i, rmaq, null));
			else{
				int ultimo = solution.get(rmaq).getMachine().size() -1;
				jobaux = solution.get(rmaq).getMachine().get(ultimo);
				solution.get(rmaq).setJob(new Job(i, rmaq, jobaux));
			}
		}
	}

	public ArrayList<Machine> getSolution() {
		return solution;
	}
	public Machine getMac(int posicao) {
		return solution.get(posicao);
	}
	public void setSolution(Machine machine) {
		this.solution.add(machine);
	}

	public int getMakespan() {
		for(int i = 0; i < this.solution.size();i++){
			this.makespan.add(solution.get(i).getTempofinal());
		}
		return Collections.max(this.makespan);
	}

	public int getQtMqs() {
		return this.solution.size();
	}

	public void setQtMqs(int qtMqs) {
		this.qtMqs = qtMqs;
	}

	public int getOf() {
		return of;
	}

	public void setOf(int of) {
		this.of = of;
	}

	public void imprimeSolution(){
		int qJobs = 0;
		for(int i = 0; i < this.getQtMqs();i++){
			qJobs = this.solution.get(i).getMachine().size();
			int x = i+1;
			System.out.println("\nMaquina "+x);
			
			for(int j = 0; j < qJobs;j++){
				System.out.printf(" { %d } ", this.getMac(i).getMachine().get(j).getNumJob());
			}
			System.out.println();
			for(int j = 0;j < qJobs;j++){
				System.out.printf(" [ %d ]--", this.getMac(i).getMachine().get(j).getJobPrepTime());
				System.out.printf("( %d ) ", this.getMac(i).getMachine().get(j).getJobExecTime());
			}
			System.out.printf("\n TF... %d \n", this.getMac(i).getTempofinal());
		}
	}
	public void imprimeMaq(int i) {
		int qJobs = this.solution.get(i).getMachine().size();
		for(int j = 0; j < qJobs;j++){
			System.out.printf(" { %d } ", this.getMac(i).getMachine().get(j).getNumJob());
		}
		System.out.println();
		for(int j = 0;j < qJobs;j++){
			System.out.printf(" [ %d ]--", this.getMac(i).getMachine().get(j).getJobPrepTime());
			System.out.printf("( %d ) ", this.getMac(i).getMachine().get(j).getJobExecTime());
		}
		System.out.printf("\n TF... %d \n", this.getMac(i).getTempofinal());
		
	}
	
	public void printDados(){
		System.out.println(this.getMac(0).getMachine().get(0).getJobExecTime());
	}
	
}
