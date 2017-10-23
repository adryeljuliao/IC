import java.util.ArrayList;
import java.util.Random;


public class Genetico {
	private Populacao populacao;
	private Random r = new Random();
	private int tamanhoPopulacao = 10;
	
	public Genetico(){
		populacao = new Populacao();
		populacao.iniciarPopulacao(tamanhoPopulacao);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public Populacao gerarPopulacao(){
		
		Populacao tempPop = new Populacao();
		ArrayList<Individuo> filhos = new ArrayList<>();
		
		while(tempPop.getNumIndividuos() <= populacao.getNumIndividuos()){
			
			filhos = cruzamento(selecao());
			tempPop.setIndividuo(filhos.get(0));
			tempPop.setIndividuo(filhos.get(1));
			
		}
		
		return tempPop;
	}
	
	
	public ArrayList<Individuo> cruzamento(ArrayList<Individuo> pais){
		ArrayList<Individuo> filhos = new ArrayList<>();
		
		
		
		
		
		
		return filhos;
	}
	
	public ArrayList<Individuo> selecao (){
		
		ArrayList<Individuo> pais = new ArrayList<>();
		
		int individuoA = 0;
		int individuoB = 0;
		
		for (int i = 0; i < 2; i++){
			
			individuoA = r.nextInt(tamanhoPopulacao);
			individuoB = r.nextInt(tamanhoPopulacao);
			
			//verificar aptidao
			if(populacao.getIndividuo(individuoA).getAptidao() > populacao.getIndividuo(individuoB).getAptidao()){
				pais.add(populacao.getIndividuo(individuoA));
			}else{
				pais.add(populacao.getIndividuo(individuoB));
			}
			
		}
		
		return pais;
	}
	
}
