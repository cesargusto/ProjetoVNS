package com.vns.PROBLEM.UPMSTP;

import java.util.ArrayList;
import java.util.Collections;

import com.vns.STRUCTURE.Instance;

public class Maquina {

	private ArrayList maquina;
	
	public Maquina(){
		this.maquina = new ArrayList<Integer>();
	}

	public int tempoMaq(int nummaq){
		int tempo_total = 0;
		int tempo_prep = 0;
		int tempo_exec = 0;
		for(int t = 0;t < this.maquina.size();t++){
			if(t!=0){
				tempo_prep = Instance.getMat(nummaq)[this.getJob(t - 1)][this.getJob(t)];
			}
			tempo_exec = Instance.getMaq(nummaq)[this.getJob(t)];
			tempo_total = tempo_total + tempo_prep + tempo_exec;
		}
		return tempo_total;
	}
	public int getTamMaq() {
		return maquina.size();
	}
	
	public ArrayList getMaquina() {
		return maquina;
	}

	public int getJob(int i){
		return (Integer)this.maquina.get(i);
	}
	public void setJobMaq(Integer job) {
		this.maquina.add(job);
	}
	
	public void setJobMaq(int pos, int job) {
		this.maquina.add(pos, job);
	}
	
	public void removeJob(int pos){
		this.maquina.remove(pos);
	}

	public void trocaJob(int i, int j){
		Collections.swap(this.maquina, i, j);
	}
	
	
}
