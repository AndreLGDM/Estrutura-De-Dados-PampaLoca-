package PampaLoca;

public interface ILista {
    
    void insereInicio(Object o);

    void insereFim(Object o);

    boolean estahVazia();

    int tamanho();

    boolean remove(Object o);

    Noh buscaPlaca(String placa);

    Noh buscaCategoria(int id);

    void inicioFim();

    void fimInicio();

}
