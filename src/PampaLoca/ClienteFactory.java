package PampaLoca;

import java.util.Scanner;

public class ClienteFactory {
    
    public static Cliente criarCliente(Scanner in) {
        Cliente c = new Cliente();
        System.out.print("Digite o nome da Pessoa: ");
        c.setNome(in.next());
        do {
            System.out.print("Digite o CPF do Cliente: ");
            String cpf = in.next();
            c.setCPF(cpf);
            if (!cpf.matches("[0-9]+")) {
                System.out.println("CPF inválido!");
            }
        } while (!c.getCPF().matches("[0-9]+"));
        do {
            System.out.print("Digite o CNH do Cliente: ");
            String cnh = in.next();
            c.setCNH(cnh);
            if (!cnh.matches("[0-9]+")) {
                System.out.println("CNH inválida!");
            }
        } while (!c.getCNH().matches("[0-9]+"));
        do {
            System.out.print("Digite o telefone do Cliente: ");
            String telefone = in.next();
            c.setTelefone(telefone);
            if (!telefone.matches("[0-9]+")) {
                System.out.println("telefone inválida!");
            }
        } while (!c.getTelefone().matches("[0-9]+"));
        return c;
    }
}
