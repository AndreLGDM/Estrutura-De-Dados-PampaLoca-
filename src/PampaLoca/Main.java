package PampaLoca;

public class Main {
    public static void main(String[] args) {

        Categoria cat1 = new Categoria(1111, "Carro");
        Categoria cat2 = new Categoria(1010, "Moto");
        Veiculo vei1 = new Veiculo("ABC1234", "Uno", "Fiat", 2010, 200, 4, cat1);
        Veiculo vei2 = new Veiculo("AAA1111", "Bis", "Honda", 2020, 10, 2, cat2);
        Veiculo vei3 = new Veiculo("BAC4321", "Gol", "Fiat", 2000, 500, 6, cat1);

        ILista l = new LDE();

        l.insereFim(vei1);
        l.insereInicio(vei2);
        l.insereInicio(vei3);
        l.insereFim(cat1);
        l.remove(vei1);
        System.out.println(l.inicioFim());
        
        

        
    }
}
