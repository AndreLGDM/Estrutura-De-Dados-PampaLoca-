package PampaLoca;

public class Cliente{
    
	private String nome;
    private String CNH;
    private String telefone;
    private String CPF;
    
	public Cliente() {
	}

	public Cliente(String nome, String CNH){
		
		this.nome = nome;
		this.CNH = CNH;

	}

	public Cliente(String nome, String CNH, String Telefone, String CPF){
		
		this.nome = nome;
		this.CNH = CNH;
		this.telefone = Telefone;
		this.CPF = CPF;
		
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
		this.CNH = cNH;
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

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	@Override
	public String toString() {
		return "Cliente {" + " Nome: " + nome + " | CNH: " + CNH + " | Telefone: " + telefone + " | CPF: " + CPF + " } ";
	}
    
}
