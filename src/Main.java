

public class Main {

	public static void main(String[] args) {
		Sinal sinalInicial = new SinalVermelho();
		Semaforo epitacio = new Semaforo("12356", sinalInicial);

		System.out.println("Estado Atual: " + epitacio.getSinal().getCor());
		System.out.println("Significado : " + epitacio.getSinal().getAcao());
		epitacio.exibir();
		
		epitacio.start();
		
		System.out.println("Fim da simulacao.");
		
		System.out.println(epitacio);
				

	}

}
