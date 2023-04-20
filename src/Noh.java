public class Noh {
    private Object obj;
    private Noh ant;
    private Noh prox;

    public Noh(Object obj) {
        this.obj = obj;
        this.ant = null;
        this.prox = null;
    }

    public Object getObjeto() { return obj; }
    public Noh getProximo() { return prox; }
    public Noh getAnterior() { return ant; }

    public void setProximo(Noh prox) { this.prox = prox; }
    public void setAnterior(Noh ant) { this.ant = ant; }
}