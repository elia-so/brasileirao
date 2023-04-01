package br;
import java.util.List;
import java.util.ArrayList;

public class teste {	
	public static void main(String[] args) {
		
		Clube c1 = new Clube("Flamengo");
		Clube c2 = new Clube("Vasco");
		Clube c3 = new Clube("Sao Paulo");
		Clube c4 = new Clube("Corinthians");
		Clube c5 = new Clube("Palmeiras");
		Clube c6 = new Clube("Ceara");
		
		List<Clube> clubes = new ArrayList<>();
		clubes.add(c1);
		clubes.add(c2);
		clubes.add(c3);
		clubes.add(c4);
		clubes.add(c5);
		clubes.add(c6);
		
		Campeonato brasileirao = new Campeonato(clubes);
		brasileirao.jogarCampeonato();
		
		brasileirao.setClassificacao();
		brasileirao.setCampeao();
	}
}