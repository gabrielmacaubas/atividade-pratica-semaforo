
public class SinalVermelho implements Sinal {
	private String cor = "Vermelho";
	private String acao = "PARE";
	private Semaforo semaforo;

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
		Sinal novoSinal = new SinalVerde();
		this.semaforo.setSinal(novoSinal);
		novoSinal.setSemaforo(semaforo);
	}
	
	@Override
	public String toString() {
		String s = "Sinal " + this.cor + " - " + this.acao;
		return s;
	}
}
