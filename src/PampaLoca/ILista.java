package PampaLoca;

public interface ILista {
    
    void insereInicio(Object o);

    void insereFim(Object o);

    boolean estahVazia();

    int tamanho();

    Object remove(Object o);

    Noh buscaPlaca(String placa);

    Noh buscaCategoria(int id);

    String inicioFim();

    String fimInicio();

}
