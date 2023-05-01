package PampaLoca;

public class ClienteFactory {
    
    public static Cliente criarCliente(String Nome, String CPF, String CNH, String Telefone) {
        Cliente c = new Cliente();
        c.setNome(Nome);
        do {
            c.setCPF(CPF);
            if (!CPF.matches("[0-9]+")) {
            }
        } while (!c.getCPF().matches("[0-9]+"));
        do {
            c.setCNH(CNH);
            if (!CNH.matches("[0-9]+")) {
            }
        } while (!c.getCNH().matches("[0-9]+"));
        do {
            c.setTelefone(Telefone);
            if (!Telefone.matches("[0-9]+")) {
            }
        } while (!c.getTelefone().matches("[0-9]+"));
        return c;
    }
}
