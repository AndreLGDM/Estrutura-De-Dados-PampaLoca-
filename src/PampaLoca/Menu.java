package PampaLoca;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private String escolha;

    public void intro() {
        System.out.println("    Bem Vindo     ");
        System.out.println("PampaLoca & Cia LTDA");
        System.out.println();
    }

    public String getEscolha() {
        return escolha;
    }

    public void setEscolha(String escolha) {
        this.escolha = escolha;
    }

    public void menuPrincipal(Scanner in) throws InterruptedException, IOException {
        System.out.println(
                "1 - Cliente" + "\n" + "2 - Veiculo" + "\n" + "3 - Locação" + "\n" + "4 - Categoria" + "\n"
                        + "0 - Sair");
        System.out.print("Escolha uma das opções: ");
        this.escolha = in.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void menuCliente(Scanner in) throws InterruptedException, IOException {
        System.out.print("1 - Cadastrar Cliente" + "\n" + "2 - Excluir Cliente" + "3 - Editar Dados Cliente" + "\n"
                + "4 - Listar Clientes" + "\n" + "Escolha: ");
        this.escolha = in.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void menuVeiculo(Scanner in) throws InterruptedException, IOException {
        System.out.print("1 - Cadastrar Veiculo" + "\n" + "2 - Excluir Veiculo" + "3 - Editar Dados Veiculo" + "\n"
                + "4 - Listar Veiculos" + "\n" + "Escolha: ");
        this.escolha = in.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void menuCategoria(Scanner in) throws InterruptedException, IOException {
        System.out.print("1 - Incluir Categoria" + "\n" + "2 - Excluir Categoria" + "3 - Editar Categoria" + "\n"
                + "4 - Listar Categorias" + "\n" + "Escolha: ");
        this.escolha = in.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void menuLocacao(Scanner in) throws InterruptedException, IOException {
        System.out.println("1 - Consultar veículos não locados " + "\n" + "2 - Incluir Locação  " + "\n"
                + "3 - Excluir Locação" + "\n" + "4 - Listar Locações" + "\n" + "Escolha: ");
        this.escolha = in.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

}