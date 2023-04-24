package PampaLoca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();

        Categoria cat1 = new Categoria(1111, "Carro");
        Categoria cat2 = new Categoria(1010, "Moto");
        listaCategorias.insereInicio(cat1);
        listaCategorias.insereFim(cat2);
        Cliente cliente1 = ClienteFactory.criarCliente(in);
        Veiculo veiculo1 = VeiculoFactory.criarVeiculo(in, listaCategorias);
        
        listaClientes.insereInicio(cliente1);
        listaVeiculos.insereFim(veiculo1);
        Locacao loc = LocacaoFactory.criarLocacao(in, listaVeiculos, listaClientes);
        listaLocacoes.insereInicio(loc);
        listaLocacoes.inicioFim();
        listaVeiculos.inicioFim();
        listaClientes.inicioFim();

    }

}