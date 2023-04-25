package PampaLoca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();
        ILista listaClientes = new LDE();
        ILista listaLocacoes = new LDE();
        Arquivo.lerArquivoCSV(listaVeiculos, listaClientes, listaLocacoes, listaCategorias);
        
        listaVeiculos.inicioFim();
        listaClientes.inicioFim();
        listaLocacoes.inicioFim();
        listaCategorias.inicioFim();

        Cliente cliente1 = ClienteFactory.criarCliente(in);
        Arquivo.gravarArquivoCSV(cliente1);
        Veiculo veiculo1 = VeiculoFactory.criarVeiculo(in, listaCategorias);
        Arquivo.gravarArquivoCSV(veiculo1);
        
        listaClientes.insereInicio(cliente1);
        listaVeiculos.insereFim(veiculo1);
        Locacao loc = LocacaoFactory.criarLocacao(in, listaVeiculos, listaClientes);
        Arquivo.gravarArquivoCSV(loc);
        listaLocacoes.insereInicio(loc);
        listaLocacoes.inicioFim();
        listaVeiculos.inicioFim();
        listaClientes.inicioFim();

    }

}