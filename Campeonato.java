package br;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Campeonato {
	private List<Clube> clubes;
	
	public Campeonato(List<Clube> clubes) {
		this.clubes = clubes;		
	}
	public void jogarCampeonato() {
		for(int i = 0; i < clubes.size(); i++) {
			Clube c1 = clubes.get(i);
			for(int j = 0; j <clubes.size(); j++) {
				Clube c2 = clubes.get(j);
				if(c1.getNome().equals(c2.getNome()) == true) {
					
				} else {
					jogarPartida(c1, c2);
				}
			}
		}
	}
	
	private void jogarPartida(Clube m, Clube v) {
		
		Random gols = new Random();
		int mgol = gols.nextInt(5);
		int vgol = gols.nextInt(5);
		
		int msaldoGols = mgol - vgol;
		int vsaldoGols = vgol - mgol;
		
		System.out.printf("%-13s %dx%d    %-13s\n", m.nome, mgol, vgol, v.nome);
		
		if(msaldoGols > vsaldoGols) {
			m.ganhar(msaldoGols);
			v.perder(vsaldoGols);
		} else if(msaldoGols < vsaldoGols) {
			m.perder(msaldoGols);
			v.ganhar(vsaldoGols);
		} else {
			m.empatar();
			v.empatar();
		}
	}
	//BUBBLESORT
	public void comparador() {
		int n = clubes.size();
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n - i-1; j++) {
				Clube m = clubes.get(j);
				Clube v = clubes.get(j+1);
				if(m.getPontos() < v.getPontos()) {
					clubes.set(j, v);
					clubes.set(j+1, m);
				} else if(m.getPontos() == v.getPontos()) {
					if(m.getSaldoGols() < v.getSaldoGols()) {
						clubes.set(j, v);
						clubes.set(j+1, m);
					}
				}
			}
		}
	}
	
	public void setClassificacao() {
		comparador();
		
		System.out.println("\t\t\t\tCLASSIFICACAO");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\tClube\t\t|\tPontuacao\t|\tSaldo Gols\t|");
		System.out.println("+-----------------------------------------------------------------------+");
		for(int i = 0; i < clubes.size(); i++) {
			Clube c = clubes.get(i);
			System.out.printf("|\t%-13s\t|\t%d\t\t|\t%d\t\t|\n",c.getNome(), c.getPontos(), c.getSaldoGols());
		}
		System.out.println("+-----------------------------------------------------------------------+");
	}
	
	public void setCampeao() {
		System.out.println("Campeao: " + clubes.get(0).getNome());
	}		
}