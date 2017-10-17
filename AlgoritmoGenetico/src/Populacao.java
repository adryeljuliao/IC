

import java.util.ArrayList;
import java.util.Collections;

public class Populacao {
	private ArrayList<Individuo> individuos;

	public Populacao(){
		individuos = new ArrayList<>();
	}
	
	public void iniciarPopulacao(int tamPop) {
		for (int i = 0; i < tamPop; i++) {
			individuos.add(new Individuo());
		}
		ordenarPopulacao();
	}

	// ordenar populacao (ordem crescente)
	public void ordenarPopulacao() {
		Collections.sort(individuos, Collections.reverseOrder());
		for (Individuo individuo : individuos) {
			System.out.println(individuo + "\n");
		}
	
	}

	public Individuo getIndividuo(int pos) {
		return individuos.get(pos);
	}

	// coloca um individuo na proxima posicao disponivel da populacao
	public void setIndividuo(Individuo individuo) {
		individuos.add(individuo);

	}

	// numero de individuos existentes na populacao
	public int getNumIndividuos() {
		return individuos.size();
	}

}
