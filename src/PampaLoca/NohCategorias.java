package Categoria;

public class NohCategorias {
    private Categoria categoria;
    private NohCategorias anterior;
    private NohCategorias proximo;

    public NohCategorias(Categoria categoria) {
        this.categoria = categoria;
        this.anterior = null;
        this.proximo = null;
    }

    public Categoria getCategoria() { return categoria; }
    public NohCategorias getAnterior() { return anterior; }
    public NohCategorias getProximo() { return proximo; }

    public void setAnterior(NohCategorias anterior) { this.anterior = anterior; }
    public void setProximo(NohCategorias proximo) { this.proximo = proximo; }
}
