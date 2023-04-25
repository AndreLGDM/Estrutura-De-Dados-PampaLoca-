package PampaLoca;

public class Noh {
    private Object objeto;
    private Noh anterior;
    private Noh proximo;

    public Noh(Object objeto) {
        
        this.objeto = objeto;
        this.anterior = null;
        this.proximo = null;
        
    }

    public Object getObjeto() { return objeto; }
    public Noh getAnterior() { return anterior; }
    public Noh getProximo() { return proximo; }

    public void setAnterior(Noh anterior) { this.anterior = anterior; }
    public void setProximo(Noh proximo) { this.proximo = proximo; }
}