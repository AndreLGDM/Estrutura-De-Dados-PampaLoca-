package PampaLoca;

import java.util.Scanner;

public class LDE implements ILista {

    Scanner in = new Scanner(System.in);

    private Veiculo v;
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
    }

    @Override
    public boolean estahVazia() {
        if (inicio == null) {
            return true;
        }
        return false;
    }

    @Override
    public Noh buscaCategoria(int idCategoria) {
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
    public Noh buscaPlaca(String placaVeiculo) {
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
    public Object remove(Object objeto) {
        Noh nohRemovido = null;
        if (objeto instanceof Categoria) {
            System.out.println("Digite a id da categoria a ser removida: ");
            int idCategoria = in.nextInt();
            nohRemovido = buscaCategoria(idCategoria);
        } else if (objeto instanceof Veiculo) {
            System.out.println("Digite a placa do veículo a ser removido: ");
            String placaVeiculo = in.next();
            nohRemovido = buscaPlaca(placaVeiculo);
        }
        if (nohRemovido != null) {
            // Remove o nó da lista
            if (nohRemovido == inicio) {
                inicio = nohRemovido.getProximo();
            } else {
                Noh nohAnterior = inicio;
                while (nohAnterior.getProximo() != nohRemovido) {
                    nohAnterior = nohAnterior.getProximo();
                }
                nohAnterior.setProximo(nohRemovido.getProximo());
            }
            // Retorna o objeto removido
            return nohRemovido.getObjeto();
        }
        // Retorna null se o objeto não foi encontrado
        return null;
    }

    @Override
    public int tamanho() {
        int tam = 0;

        for (Noh i = inicio; i != null; i = i.getProximo()) {
            tam++;
        }
        return tam;
    }

    @Override
    public String inicioFim() {
        String str = "\n";
        Noh categoria = inicio;

        while (categoria != null) {
            str += "- " + categoria.getObjeto() + "\n";
            categoria = categoria.getProximo();
        }

        return str;
    }

    @Override
    public String fimInicio() {
        String str = "\n";
        Noh categoria = fim;

        while (categoria != null) {
            str += categoria.getObjeto() + "\n";
            categoria = categoria.getAnterior();
        }

        return str;
    }
}
