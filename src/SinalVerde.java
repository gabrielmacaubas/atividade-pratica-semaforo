
public class SinalVerde implements Sinal {
	String cor = "Verde";
	String acao = "SIGA";
	Semaforo semaforo;

	@Override
	public String getAcao() {
		return this.acao;
		
	}

	@Override
	public String getCor() {
		return this.cor;
		
	}
	
	@Override
	public void setSemaforo(Semaforo novoSemaforo) {
		this.semaforo = novoSemaforo;
	}

	@Override
	public void proximo() {
		Sinal novoSinal = new SinalAmarelo();
		this.semaforo.setSinal(novoSinal);
		novoSinal.setSemaforo(semaforo);
	}
	
	@Override
	public String toString() {
		String s = "Sinal " + this.cor + " - " + this.acao;
		return s;
	}
}
