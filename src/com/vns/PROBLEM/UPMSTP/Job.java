package com.vns.PROBLEM.UPMSTP;

import com.vns.STRUCTURE.Instance;

public class Job {
	private int numJob;
	private int numMaq;
	private Job jobAnt;
	private int jobExecTime;
	private int jobPrepTime;
	private int jobTempToal;
	
	public Job(){
		
	}
	
	public Job(int numjob){
		this.numJob = numjob;
	}
	
	public Job(int numjob, int nummaq, Job ant){
		this.numJob = numjob;
		this.numMaq = nummaq;
		this.jobAnt = ant;
		this.jobExecTime = Instance.getMaq(nummaq)[numJob];
		if(ant != null)
			this.jobPrepTime = Instance.getMat(nummaq)[jobAnt.getNumJob()][numJob];
		else
			this.jobPrepTime = 0;
		this.jobTempToal = jobExecTime + jobPrepTime;
	}

	public int getNumJob() {
		return numJob;
	}

	public void setNumJob(int numJob) {
		this.numJob = numJob;
	}

	public int getNumMaq() {
		return numMaq;
	}

	public void setNumMaq(int numMaq) {
		this.numMaq = numMaq;
	}

	public Job getJobAnt() {
		return jobAnt;
	}

	public void setJobAnt(Job jobAnt) {
		this.jobAnt = jobAnt;
	}

	public int getJobExecTime() {
		return jobExecTime;
	}

	public void setJobExecTime(int jobExecTime) {
		this.jobExecTime = jobExecTime;
	}

	public int getJobPrepTime() {
		return jobPrepTime;
	}

	public void setJobPrepTime(int jobPrepTime) {
		this.jobPrepTime = jobPrepTime;
	}

	public int getJobTempToal() {
		return jobExecTime + jobPrepTime;
	}

	public void setJobTempToal(int jobTempToal) {
		this.jobTempToal = jobTempToal;
	}
//	@Override
//	public String toString() {
//		return "[" + jobPrepTime + ", " + jobExecTime + ", " + numJob + "]";
//	}
	@Override
	public String toString() {
		return "" + jobExecTime + "";
	}
	
}
