public class LDE implements ILista {
    private Noh inicio;
    private Noh fim;

    public LDE() {
        this.inicio = null;
        this.fim = null;
    }

    public void insereInicio(Object obj) { 
        Noh novo = new Noh(obj);

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

    public void insereFim(Object obj) { 
        Noh novo = new Noh(obj);

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

    private Noh busca(Object obj) {
        Noh noh = inicio;

        while (noh != null && noh.getObjeto() != obj) {
            noh = noh.getProximo();
        }
        return noh;
    }
    
    public boolean remove(Object obj) {
        Noh noh = busca(obj);

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

        for(Noh i = inicio; i != null; i = i.getProximo()) {
            tam++;
        }
        return tam;
    }
}
