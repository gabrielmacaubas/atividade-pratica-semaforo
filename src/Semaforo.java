import java.util.HashMap;
import java.util.Map;

import java.lang.Thread;

public class Semaforo {
	
	private String numTombamento = null;
	private Sinal sinal;
	private Map<String, Integer> transicao = new HashMap<String,Integer>();
	
	public Semaforo(String numTombamento, Sinal sinalInicial) {
        this.numTombamento = numTombamento;
        this.sinal = sinalInicial;
        this.sinal.setSemaforo(this);
        
        
        // tempo de transicao em segundos
        transicao.put("Vermelho",3);
        transicao.put("Amarelo",2);
        transicao.put("Verde",5);
	}
	
	public String getNumTombamento() {
		return numTombamento;
	}
	
	public Sinal getSinal() {
		return this.sinal;
	}
	
	public void setSinal(Sinal sinalNovo) {
		this.sinal = sinalNovo;
	}

	public void setNumTombamento(String numTombamento) {
		this.numTombamento = numTombamento;
	}
	
	public void exibir() {
		System.out.println(" vermelho  ( " + (sinal.getCor() == "Vermelho" ?"X":" ") + " )");
		System.out.println(" amarelo   ( " + (sinal.getCor() == "Amarelo" ?"X":" ") + " )");
		System.out.println(" verde     ( " + (sinal.getCor() == "Verde" ?"X":" ") + " )");
	}
	
	public void efetuarTransicao() {
	    this.sinal.proximo();
	}
	
	public void showVisorRegressivo() {
		for (int i = transicao.get(getSinal().getCor()); i >0 ; i--) {
			System.out.println(i + " segundo(s)");
			try {
				// 1000 milisegundos equivale a 1 segundo
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void start() {
		this.start(10);
	}

	public void start(int time_in_seconds) {
		while(time_in_seconds > 0) {
			System.out.println("Tempo restante da simulacao: " + time_in_seconds + " segundos");
			System.out.println( getSinal() + " : " + transicao.get(getSinal().getCor()) + " segundos.");
			exibir();
			time_in_seconds -= transicao.get(getSinal().getCor());
			showVisorRegressivo();
			efetuarTransicao();
			System.out.println();
			
		}
		
	}
	
	public String toString() {
		String s = "";
		s += "Numero Tombamento: " + numTombamento + "\n";
		s += "Tempo de permanencia em cada estagio:\n";
		s += "Vermelho : " + transicao.get("Vermelho") + " segundos\n";
		s += "Amarelo : " + transicao.get("Amarelo") + " segundos\n";
		s += "Verde : " + transicao.get("Verde") + " segundos\n";
		return s;
	}
}
