package PampaLoca;

public class Locacao {
     
    private Cliente cliente;
    private Veiculo veiculo;

    public Locacao(Veiculo v, Cliente c){
        this.veiculo = v;
        this.cliente = c;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public String toString() {
        return "Locação {" + veiculo.getPlaca() +" "+ cliente.getCNH()+"}" ;
    }
}