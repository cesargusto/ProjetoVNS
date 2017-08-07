package com.vns.STRUCTURE;

import java.util.ArrayList;

public class Instance {

	public static final int numMachines = 2;
	public static final int numJobs = 7;
	public static final int[] m0 = {20, 25, 28, 17, 43, 9, 65};
	public static final int[] m1 = {4, 21, 15, 32, 38, 23, 52};
	public static final int[][] time_pm0 = {
			{0, 1, 8, 1, 3, 9, 6},
			{4, 0, 7, 3, 7, 8, 4},
			{7, 3, 0, 2, 3, 5, 3},
			{3, 8, 3, 0, 5, 2, 2},
			{8, 3, 7, 9, 0, 5, 7},
			{8, 8, 1, 2, 2, 0, 9},
			{1, 4, 5, 2, 3, 5, 0}
			}; 
	public static final int[][] time_pm1 = {
			{0, 4, 6, 5, 10, 3, 2},
			{1, 0, 6, 2, 7, 7, 5},
			{2, 6, 0, 6, 8, 1, 4},
			{5, 7, 1, 0, 12, 10, 6},
			{7, 9, 5, 7, 0, 4, 8},
			{9, 3, 5, 4, 9, 0, 3},
			{3, 2, 6, 1, 5, 6, 0}
			};
	
	public static int[] getMaq(int i){
		int[] x = new int[m0.length];
		if (i == 0)
			x = m0;
		if (i == 1)
			x = m1;
		return x;
	}
	public static int[][] getMat(int i){
		int[][]x = new int[m0.length][m0.length];
		if (i == 0)
			x = time_pm0;
		if (i == 1)
			x = time_pm1;
		
		return x;
	}
	
}
