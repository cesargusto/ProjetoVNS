package com.vns.STRUCTURE;

import java.util.ArrayList;

public class Neighborhood {
	
	private ArrayList<Solution> neighbors = new ArrayList<>();

	public ArrayList<Solution> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<Solution> neighbors) {
		this.neighbors = neighbors;
	}

}
