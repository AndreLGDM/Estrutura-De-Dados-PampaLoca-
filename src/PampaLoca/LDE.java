package PampaLoca;

import java.util.Scanner;

public class LDE implements ILista {

    Scanner in = new Scanner(System.in);

    private int tamanho = 0;
    private Noh inicio;
    private Noh fim;

    public LDE() {
        this.inicio = null;
        this.fim = null;
    }

    public Noh getInicio() {
        return inicio;
    }

    public Noh getFim() {
        return fim;
    }

    @Override
    public void insereInicio(Object o) {
        Noh novo = new Noh(o);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        }
        tamanho++;
    }

    @Override
    public void insereFim(Object locacao) {
        Noh novo = new Noh(locacao);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setAnterior(fim);
            fim.setProximo(novo);
            fim = novo;
        }
        tamanho++;
    }

    @Override
    public boolean estahVazia() {
        if (inicio == null) {
            return true;
        }
        return false;
    }

    @Override
    public Noh busca(int idCategoria) {
        Noh noh = inicio;
        while (noh != null) {
            Object objeto = noh.getObjeto();
            if (objeto instanceof Categoria) {
                Categoria categoriaBusca = (Categoria) objeto;
                if (categoriaBusca.getIdCategoria() == idCategoria) {
                    return noh;
                }
            }
            noh = noh.getProximo();
        }
        return null;
    }

    @Override
    public Noh busca(String txt) {
        Noh noh = inicio;
        while (noh != null) {
            Object objeto = noh.getObjeto();
            if (objeto instanceof Veiculo) {
                Veiculo veiculoBusca = (Veiculo) objeto;
                if (veiculoBusca.getPlacaVeiculo().equals(txt)) {
                    return noh;
                }
            } else if (objeto instanceof Cliente) {
                Cliente clienteBusca = (Cliente) objeto;
                if (clienteBusca.getCPF().equals(txt)) {
                    return noh;
                }
            } else if (objeto instanceof Locacao) {
                Locacao LocacaoBusca = (Locacao) objeto;
                if (LocacaoBusca.getVeiculo().getPlacaVeiculo().equals(txt)) {
                    return noh;
                }
            }
            noh = noh.getProximo();
        }
        return null;
    }

    @Override
    public boolean remove(Object objeto, int elem) {
        Noh nohRemovido = null;
        if (objeto instanceof Categoria)
            nohRemovido = busca(elem);
        if (nohRemovido == null) {
            return false;
        }
        if (estahVazia()) {
            return false;
        }
        if (nohRemovido == inicio) { // info está no início
            inicio = nohRemovido.getProximo();
            if (inicio != null) {
                inicio.setAnterior(null);
            } else {
                fim = null;
            }
        } else if (nohRemovido == fim) { // info está no fim
            fim = nohRemovido.getAnterior();
            fim.setProximo(null);
        } else { // info está no meio
            nohRemovido.getAnterior().setProximo(nohRemovido.getProximo());
            nohRemovido.getProximo().setAnterior(nohRemovido.getAnterior());
        }
        tamanho--;
        return true;
    }

    @Override
    public boolean remove(Object objeto, String txt){
        Noh nohRemovido = null;
    if (objeto instanceof Veiculo) {
        nohRemovido = busca(txt);
    } else if (objeto instanceof Locacao) {
        nohRemovido = busca(txt);
    } else if (objeto instanceof Cliente) {
        nohRemovido = busca(txt);
    }
    if (estahVazia()) {
        return false;
    }
    if (nohRemovido == inicio) { // info está no início
        inicio = nohRemovido.getProximo();
        if (inicio != null) {
            inicio.setAnterior(null);
        } else {
            fim = null;
        }
    } else if (nohRemovido == fim) { // info está no fim
        fim = nohRemovido.getAnterior();
        fim.setProximo(null);
    } else { // info está no meio
        nohRemovido.getAnterior().setProximo(nohRemovido.getProximo());
        nohRemovido.getProximo().setAnterior(nohRemovido.getAnterior());
    }
    tamanho--;
    return true;
}

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public void inicioFim() {
        if (estahVazia()) {
            System.out.println("A lista está vazia.");
            return;
        }

        Noh atual = inicio;
        while (atual != null) {
            System.out.println(atual.getObjeto());
            for (int i = 0; i < 122; i++)
                System.out.print("-");
            System.out.println();
            atual = atual.getProximo();
        }
    }

    @Override
    public void fimInicio() {
        if (estahVazia()) {
            System.out.println("A lista está vazia.");
            return;
        }
        Noh atual = fim;
        while (atual != null) {
            System.out.println(atual.getObjeto());
            for (int i = 0; i < 122; i++)
                System.out.print("-");
            System.out.println();
            atual = atual.getAnterior();
        }
    }
}
