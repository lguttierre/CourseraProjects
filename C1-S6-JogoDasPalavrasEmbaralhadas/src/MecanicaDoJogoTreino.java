
public class MecanicaDoJogoTreino implements MecanicaDoJogo {

	private int acertos = 0;

	private int erros  = 0;
	
	private String palavraNormal = "";
	
	private BancoDePalavras banco;
		
	private FabricaEmbaralhadores fabricaEmbraralhador; 
	
	public MecanicaDoJogoTreino() {
		super();
		banco = new BancoDePalavras();
		fabricaEmbraralhador = new FabricaEmbaralhadores();
	}

	@Override
	public String nomeDoJogo() {
		return "TREINO - NÀO HÁ LIMITE DE ERROS";
	}
	
	@Override
	public String proximaPalavra() {
        this.palavraNormal      = banco.retornaPlalavra(); 
        return fabricaEmbraralhador.buscarEmbaralhador().embaralhar(palavraNormal);
	}

	@Override
	public boolean acertouPalavra(String palavra) {
        
		if (palavra.equals(this.palavraNormal))
			return true;
		else
			return false;
	}

	@Override
	public void somaAcertos() {
		this.acertos++;
	}

	@Override
	public void somaErros() {
		this.erros++;
	}

	@Override
	public int getAcertos() {
		return this.acertos;
	}

	@Override
	public int getErros() {
		return this.erros;
	}

	@Override
	public boolean finalizouJogo() {
		if (banco.existePalavra())
			return false;
		else
			return true;
	}
}
