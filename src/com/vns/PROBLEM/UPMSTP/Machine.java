package com.vns.PROBLEM.UPMSTP;

import java.util.ArrayList;
import java.util.Collections;

import com.vns.STRUCTURE.Instance;

public class Machine {

	private ArrayList<Job> machine;
	private int qtJobs;
	private int tempofinal;
	
	public Machine(ArrayList<Job> maquina){
		this.machine = maquina;
		this.qtJobs = this.machine.size();
	}
	public Machine(){
		this.machine = new ArrayList<>();
		this.qtJobs = this.machine.size();
	}
	
	public void swapJob(int i, int x, int j){
		Collections.swap(machine, x, j);
		atualizaMaq(i);
	}
	
	public void atualizaMaq(int nummaq) {
		for(int i = 0;i < machine.size();i++) {
			if(i == 0){
				machine.get(i).setJobAnt(null);
				machine.get(i).setJobPrepTime(0);
			}
			else {
				machine.get(i).setJobAnt(machine.get(i - 1));
				machine.get(i).setJobPrepTime(Instance.getMat(nummaq)[machine.get(i-1).getNumJob()][machine.get(i).getNumJob()]);
			}
		}
	}
	
	public ArrayList<Job> getMachine() {
		return machine;
	}

	public void setMachine(ArrayList<Job> machine) {
		this.machine = machine;
	}


	public int getQtJobs() {
		return qtJobs;
	}

	public void setQtJobs(int qtJobs) {
		this.qtJobs = qtJobs;
	}

	public int getTempofinal() {
		this.tempofinal = 0;
		for(int i = 0;i < this.machine.size();i++){
			this.tempofinal += this.machine.get(i).getJobTempToal();
		}
		return tempofinal;
	}

	public void setJob(Job job) {
		this.machine.add(job);
	}

}
