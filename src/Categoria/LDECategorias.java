package Categoria;

public class LDECategorias {
    private NohCategorias inicio;
    private NohCategorias fim;

    public LDECategorias() {
        this.inicio = null;
        this.fim = null;
    }

    public void insereInicio(Categoria categoria) { 
        NohCategorias novo = new NohCategorias(categoria);

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

    public void insereFim(Categoria categoria) { 
        NohCategorias novo = new NohCategorias(categoria);

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

    public NohCategorias busca(int idCategoria) {
        NohCategorias noh = inicio;

        while (noh != null && noh.getCategoria().getIdCategoria() != idCategoria) {
            noh = noh.getProximo();
        }
        return noh;
    }

    public boolean remove(int idCategoria) {
        NohCategorias noh = busca(idCategoria);

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

        for(NohCategorias i = inicio; i != null; i = i.getProximo()) {
            tam++;
        }
        return tam;
    }

    public String inicioFim() {
        String str = "\n";
        NohCategorias categoria = inicio;

        while(categoria != null) {
            str += "- "+categoria.getCategoria()+"\n";
            categoria = categoria.getProximo();
        }

        return str;
    }

    public String fimInicio() {
        String str = "\n";
        NohCategorias categoria = fim;

        while(categoria != null) {
            str += categoria.getCategoria()+"\n";
            categoria = categoria.getAnterior();
        }

        return str;
    }
}
