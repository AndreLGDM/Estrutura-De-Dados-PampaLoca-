package Veiculo;

public class NohVeiculos {
    private Veiculo veiculo;
    private NohVeiculos anterior;
    private NohVeiculos proximo;

    public NohVeiculos(Veiculo veiculo) {
        this.veiculo = veiculo;
        this.anterior = null;
        this.proximo = null;
    }

    public Veiculo getVeiculo() { return veiculo; }
    public NohVeiculos getAnterior() { return anterior; }
    public NohVeiculos getProximo() { return proximo; }

    public void setAnterior(NohVeiculos anterior) { this.anterior = anterior; }
    public void setProximo(NohVeiculos proximo) { this.proximo = proximo; }
}
