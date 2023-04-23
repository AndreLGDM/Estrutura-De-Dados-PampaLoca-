package PampaLoca;

public class Cliente{
    private String nome;
    private long CNH;
    private String telefone;
    private long CPF;
    
	public Cliente(String nome, long cNH, String telefone, long cPF) {
		super();
		this.nome = nome;
		CNH = cNH;
		this.telefone = telefone;
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCNH() {
		return CNH;
	}

	public void setCNH(long cNH) {
		CNH = cNH;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public long getCPF() {
		return CPF;
	}

	public void setCPF(long cPF) {
		CPF = cPF;
	}

	@Override
	public String toString() {
		return "Cliente {" + " Nome: " + nome + " | CNH: " + CNH + " | Telefone: " + telefone + " | CPF: " + CPF + " } ";
	}
    
}
