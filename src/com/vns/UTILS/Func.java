package com.vns.UTILS;

public class Func {

	public static String[] Corte(String valor){
			String[] x;
			x = valor.split(",");
			return x;
	}
	public static void printv(String[] v){
		for(int i = 0;i < v.length;i++)
			System.out.printf("%s ",v[i]);
		System.out.println();
	}
	public static int maior_v(int[] vetor){
		int maior = 0;
		for(int i = 0;i < vetor.length;i++){
			if(vetor[i] > maior)
				maior = vetor[i];
		}
		return maior;
	}
}
