package PampaLoca;

public class Cliente{
    private String nome;
    private String CNH;
    private String telefone;
    private String CPF;
    
	public Cliente(String nome, String cNH, String telefone, String cPF) {
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

	public String getCNH() {
		return CNH;
	}

	public void setCNH(String cNH) {
		CNH = cNH;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	@Override
	public String toString() {
		return "Cliente {" + " Nome: " + nome + " | CNH: " + CNH + " | Telefone: " + telefone + " | CPF: " + CPF + " } ";
	}
    
}