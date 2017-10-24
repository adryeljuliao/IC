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
		int geneX[] = new int [4];
		int geneY[] = new int [4];
		
		int aux, aux2;
		
		for (int i = 0; i < pais.size(); i++){
			
			if(r.nextDouble() < 0.5){
				
				geneX = pais.get(i).getGenes();
				geneY = pais.get(i+1).getGenes();
				
				aux = geneX[0];
				geneX[0] = geneY[0];
				geneY[0] = aux;
				
				aux2 = geneX[1];
				geneX[1] = geneY[1];
				geneY[1] = aux2;
				
				
				
			}else{
				filhos.add(pais.get(i));
			}
			
			
		}
		
		
		
		
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
