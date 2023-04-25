package PampaLoca;

public class Locacao {
     
    private Cliente cliente;
    private Veiculo veiculo;

    public Locacao(Cliente c, Veiculo v){
        
        this.cliente = c;
        this.veiculo = v;
        
    }

    public Locacao(){
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
        return "Locação { " + veiculo.getModeloVeiculo() +" - "+ cliente.getNome() + ", cnh: " +cliente.getCNH()+" }" ;
    }
}