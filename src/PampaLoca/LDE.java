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

    
    public Noh busca(String placaVeiculo) {
        Noh noh = inicio;
        while (noh != null) {
            Object objeto = noh.getObjeto();
            if (objeto instanceof Veiculo) {
                Veiculo veiculoBusca = (Veiculo) objeto;
                if (veiculoBusca.getPlacaVeiculo().equals(placaVeiculo)) {
                    return noh;
                }
            }
            noh = noh.getProximo();
        }
        return null;
    }

    @Override
    public boolean remove(Object objeto) {
        Noh nohRemovido = null;
        if (objeto instanceof Categoria) {
            System.out.print("Digite a id da categoria a ser removida: ");
            int idCategoria = in.nextInt();
            System.out.println();
            nohRemovido = busca(idCategoria);
        } else if (objeto instanceof Veiculo) {
            System.out.print("Digite a placa do veículo a ser removido: ");
            String placaVeiculo = in.next();
            System.out.println();
            nohRemovido = busca(placaVeiculo);
        }
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
            for (int i = 0; i < 116; i++)
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
            for (int i = 0; i < 116; i++)
                System.out.print("-");
            System.out.println();
            atual = atual.getAnterior();
        }
    }
}
