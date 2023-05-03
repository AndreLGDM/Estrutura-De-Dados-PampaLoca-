package PampaLoca;

public interface ILista {
    
    void insereInicio(Object o);

    void insereFim(Object o);

    boolean estahVazia();

    int tamanho();

    boolean remove(Object o, int elem);

    boolean remove(Object o, String txt);

    Noh busca(int elem);

    Noh busca(String txt);

    void inicioFim();

    void fimInicio();

}
