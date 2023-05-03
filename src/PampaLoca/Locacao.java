package PampaLoca;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Locacao {

    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate DataDeRetirada;
    private LocalDate DataDeDevolucao;

    public Locacao(Cliente c, Veiculo v) {

        this.cliente = c;
        this.veiculo = v;

    }

    public Locacao(Cliente c, Veiculo v, LocalDate Retirada, LocalDate Devolucao){

        this.cliente = c;
        this.veiculo = v;
        this.DataDeRetirada = Retirada;
        this.DataDeDevolucao = Devolucao;
        
    }

    public Locacao() {
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

    public LocalDate getDataDeRetirada() {
        return DataDeRetirada;
    }

    public void setDataDeRetirada(LocalDate dataDeRetirada) {
        DataDeRetirada = dataDeRetirada;
    }

    public LocalDate getDataDeDevolucao() {
        return DataDeDevolucao;
    }

    public void setDataDeDevolucao(LocalDate dataDeDevolucao) {
        DataDeDevolucao = dataDeDevolucao;
    }

    @Override
    public String toString() {
        return "Locação { Modelo: " + veiculo.getModeloVeiculo() +" | Nome: "+ cliente.getNome() + " | CNH: " +cliente.getCNH()+ " | Data de Retirada: " +getDataDeRetirada()+ " | Data de Devolução: " +getDataDeDevolucao()+" }" ;
    }
}