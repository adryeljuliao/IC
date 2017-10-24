

import java.util.Arrays;
import java.util.Random;

public class Individuo implements Comparable<Individuo>{
	private Random random = new Random();
	private Integer aptidao;
	
	//atributos do problema especifico
	private int qtdMesa;
	private int qtdEscrivaninha;
	private int qtdArmario;
	private int qtdPrateleira;

	//cria um individuo aleatorio da primeira geracao
	public Individuo() {
		do {
			this.setQtdEscrivaninha();
			this.setQtdMesa();
			this.setQtdArmario();
			this.setQtdPrateleira();
		} while (!validar());
		avaliar();
	}

	// cria um individuo a partir de genes definidos
	public Individuo(int[] genes) {
		qtdEscrivaninha = genes[0];
		qtdMesa = genes[1];
		qtdArmario = genes[2];
		qtdPrateleira = genes[3];
		//testa se deve fazer mutacao
		if(random.nextDouble() <= 0.5){
			int posicaoRandom = random.nextInt(genes.length);
			mutacao(posicaoRandom);
		}
//		
		avaliar();
	}

	public boolean validar() {
			
		int tabua = qtdEscrivaninha + qtdMesa + qtdArmario + (4 * qtdPrateleira); // restricao maior que 250
		int pranchas = qtdMesa + qtdArmario + (2 * qtdPrateleira); // resticao menor igual que 600
		int paineis = (3 * qtdEscrivaninha) +( 2 * qtdMesa) + (4 * qtdArmario); // resticao menor igual que 600
		
		if(tabua <= 250 && pranchas <= 600 && paineis <= 500){
			return true;
		}
		
		return false;
	}

	public void mutacao(int posicao) {
		do {
			if (posicao == 0){
				this.setQtdEscrivaninha();
			}else if (posicao == 1){
				this.setQtdMesa();
			}else if (posicao == 2){
				this.setQtdArmario();
			}else if (posicao == 3){
				this.setQtdPrateleira();
			}
		} while (!validar());

	}

	public void setQtdMesa(int qtdMesa) {
		this.qtdMesa = qtdMesa;
	}
	
	public void setQtdEscrivaninhha(int qtdEscrivaninha) {
		this.qtdEscrivaninha = qtdEscrivaninha;
	}
	
	public void setQtdArmario(int qtdArmario) {
		this.qtdArmario = qtdArmario;
	}
	
	public void setQtdPrateleira(int qtdPrateleira) {
		this.qtdPrateleira = qtdPrateleira;
	}

	public void setQtdMesa() {
		this.qtdMesa = random.nextInt(100);
	}
	
	public void setQtdArmario() {
		this.qtdArmario = random.nextInt(100);
	}
	
	public void setQtdPrateleira() {
		this.qtdPrateleira = random.nextInt(100);
	}

	public void setQtdEscrivaninha() {
		this.qtdEscrivaninha = random.nextInt(100);
	}


	public int getAptidao() {
		return aptidao;
	}

	public int[] getGenes() {
		return new int[] { qtdEscrivaninha, qtdMesa, qtdArmario, qtdPrateleira };
	}

	public void avaliar() {
		
		aptidao = (100 * qtdEscrivaninha) + (80 * qtdMesa) + (120 * qtdArmario) + (20 * qtdPrateleira);

	}

	@Override
	public String toString() {
		return "Cromossomo " + Arrays.toString(getGenes()) + "\n";
	}

	@Override
	public int compareTo(Individuo i) {
		return this.aptidao.compareTo(i.aptidao);
	}
}
