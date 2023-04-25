package PampaLoca;

import java.util.Scanner;

public class VeiculoFactory {
    
    public static Veiculo criarVeiculo(Scanner in, ILista lista) {
        Veiculo v = new Veiculo();
        boolean placaValida = false;
        do {
            System.out.print("Digite a placa do veiculo (formato AAA-1B23 ou AAA-1234): ");
            String placa = in.next().trim();
            if (placa.matches("[A-Z]{3}-\\d[A-Z]\\d{2}") || placa.matches("[A-Z]{3}-\\d{4}")) {
                v.setPlacaVeiculo(placa);
                placaValida = true;
            } else {
                System.out.println("Placa inválida. Por favor, digite novamente.");
            }
        } while (!placaValida);
        System.out.print("Digite o modelo do veículo: ");
        v.setModeloVeiculo(in.next());
        System.out.print("Digite a marca do veículo: ");
        v.setMarcaVeiculo(in.next());
        System.out.print("Digite o ano do veículo: ");
        v.setAnoVeiculo(in.nextInt());
        System.out.print("Digite a potencia do veiculo: ");
        v.setPotenciaVeiculo(in.nextInt());
        System.out.print("Digite quantos lugares tem o veículo: ");
        v.setLugaresVeiculo(in.nextInt());
        Noh categoria;
        boolean categoriaValida = false;
        while (!categoriaValida) {
            System.out.print("Digite o Id da categoria do Carro: ");
            int idCategoria;
            do {
                while (!in.hasNextInt()) {
                    System.out.println("Id de categoria inválido! Digite um número inteiro.");
                    System.out.print("Digite o Id da categoria do Carro: ");
                    in.next();
                }
                idCategoria = in.nextInt();
            } while (idCategoria <= 0);
            categoria = lista.busca(idCategoria); // buscando categoria na lista
            if (categoria != null) {
                Categoria categoriaObjeto = (Categoria) categoria.getObjeto();
                categoriaValida = true;
                v.setCategoria(categoriaObjeto);
            } else {
                System.out.println("Categoria inválida. Por favor, digite novamente.");
                System.out.print("Digite o Id da categoria do Carro: ");
                    in.next();
            }
        }

        return v;
    }
}
