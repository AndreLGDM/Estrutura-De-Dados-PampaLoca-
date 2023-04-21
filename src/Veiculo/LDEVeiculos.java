package Veiculo;

public class LDEVeiculos {
    private NohVeiculos inicio;
    private NohVeiculos fim;

    public LDEVeiculos() {
        this.inicio = null;
        this.fim = null;
    }

    public void insereInicio(Veiculo veiculo) { 
        NohVeiculos novo = new NohVeiculos(veiculo);

        if(inicio == null) {
            inicio = novo;
            fim = novo;
        }
        else {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        }
    }

    public void insereFim(Veiculo veiculo) { 
        NohVeiculos novo = new NohVeiculos(veiculo);

        if(inicio == null){
            inicio = novo;
            fim = novo;
        }
        else {
            novo.setAnterior(fim);
            fim.setProximo(novo);
            fim = novo;
        }
    }

    public boolean estahVazia() { 
        if(inicio == null) {
            return true;
        }
        return false;
    }

    public NohVeiculos busca(String placaVeiculo) {
        NohVeiculos noh = inicio;

        while (noh != null && !noh.getVeiculo().getPlacaVeiculo().equals(placaVeiculo)) {
            noh = noh.getProximo();
        }
        return noh;
    }

    public boolean remove(String placaVeiculo) {
        NohVeiculos noh = busca(placaVeiculo);

        if(noh == null) {
            return false;
        }
        if(noh == inicio) {
            inicio = noh.getProximo();
            
            if(inicio != null) {
                inicio.setAnterior(null);
            }
            else {
                fim = null;
            }
        } 
        else if(noh.getProximo() == null) {
            noh.getAnterior().setProximo(null);
            fim = noh.getAnterior();
        } 
        else {
            noh.getAnterior().setProximo(noh.getProximo());
            noh.getProximo().setAnterior(noh.getAnterior());
        }
        return true;
    }

    public int tamanho() { 
        int tam = 0;

        for(NohVeiculos i = inicio; i != null; i = i.getProximo()) {
            tam++;
        }
        return tam;
    }

    public String inicioFim() {
        String str = "\n";
        NohVeiculos veiculo = inicio;

        while(veiculo != null) {
            str += "- "+veiculo.getVeiculo()+"\n";
            veiculo = veiculo.getProximo();
        }

        return str;
    }

    public String fimInicio() {
        String str = "\n";
        NohVeiculos veiculo = fim;

        while(veiculo != null) {
            str += veiculo.getVeiculo()+"\n";
            veiculo = veiculo.getAnterior();
        }

        return str;
    }
}
