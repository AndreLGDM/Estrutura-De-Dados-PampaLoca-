package PampaLoca;

import java.util.Scanner;

public class LocacaoFactory {
    
    public static Locacao criarLocacao(Scanner in, ILista Veiculos, ILista Clientes){

        Veiculo veiculoObjeto = null;
        Cliente clienteObjeto = null;

        Noh Veiculo;
        boolean VeiculoValido = false;
        while (!VeiculoValido) {
            boolean placaValida = false;
            String Placa;
            do {
                System.out.print("Digite a placa do veiculo (formato AAA-1B23): ");
                Placa = in.next().trim();
                if (Placa.matches("[A-Z]{3}-\\d[A-Z]\\d{2}") || Placa.matches("[A-Z]{3}-\\d{4}")) {
                    placaValida = true;
                } else {
                    System.out.println("Placa inválida. Por favor, digite novamente.");
                }
            } while (!placaValida);
            Veiculo = Veiculos.busca(Placa); // buscando categoria na lista
            if (Veiculo != null) {
                veiculoObjeto = (Veiculo) Veiculo.getObjeto();
                VeiculoValido = true;
            } else {
                System.out.println("Veiculo inexistente. Por favor, digite novamente.");
                System.out.print("Digite a placa do Veiculo: (formato AAA-1B23): ");
                    in.next();
            }
        }
        Noh Cliente;
        boolean clienteValido = false;
        while (!clienteValido) {
            String cpf;
            do {
                System.out.print("Digite o CPF do Cliente: ");
                 cpf = in.next();
                if (!cpf.matches("[0-9]+")) {
                    System.out.println("CPF inválido!");
                }
            } while (!cpf.matches("[0-9]+"));
            Cliente = Clientes.busca(cpf); // buscando categoria na lista
            if (Cliente != null) {
                clienteObjeto = (Cliente) Cliente.getObjeto();
                clienteValido = true;
            } else {
                System.out.println("Cliente inexistente. Por favor, digite novamente.");
                System.out.print("Digite o cpf do Cliente: ");
                    in.next();
            }
        }
        Locacao locacaoCriada = new Locacao(clienteObjeto, veiculoObjeto);
        return locacaoCriada;
    }
}
