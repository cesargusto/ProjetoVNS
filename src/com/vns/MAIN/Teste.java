package com.vns.MAIN;

import java.util.ArrayList;

import com.vns.LOCALSEARCH.LocalSearch;
import com.vns.STRUCTURE.Instance;
import com.vns.STRUCTURE.Solution;

public class Teste {

	public static void main(String[] args){

		ArrayList<Integer>teste = new ArrayList<>();
		teste.add(96);
		teste.add(24);
		teste.add(38);
		teste.add(45);
		teste.add(15);
		
		int indice_menor = 0;
		int indice_maior = 0;
		int valor_menor = Integer.MAX_VALUE;
		int valor_maior = Integer.MIN_VALUE;
		int aux = 0;
		
		for(int i = 0;i < teste.size();i++){
			aux = teste.get(i);
			if(aux < valor_menor){
				valor_menor = aux;
				indice_menor = i;
			}
			else if(aux > valor_maior){
				valor_maior = aux;
				indice_maior = i;
			}
		}
		System.out.println("Menor: "+valor_menor);
		System.out.println("Maior: "+valor_maior);
		

	}

}
