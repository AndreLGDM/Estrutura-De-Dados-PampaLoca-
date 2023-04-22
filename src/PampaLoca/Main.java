package PampaLoca;

public class Main {
    public static void main(String[] args) {

        Categoria cat1 = new Categoria(1111, "Carro");
        Categoria cat2 = new Categoria(1010, "Moto");
        Veiculo vei1 = new Veiculo("ABC1234", "Uno", "Fiat", 2010, 200, 4, cat1);
        Veiculo vei2 = new Veiculo("AAA1111", "Bis", "Honda", 2020, 10, 2, cat2);
        Veiculo vei3 = new Veiculo("BAC4321", "Gol", "Fiat", 2000, 500, 6, cat1);

        ILista listaVeiculos = new LDE();
        ILista listaCategorias = new LDE();

        listaVeiculos.insereFim(vei1);
        listaVeiculos.insereInicio(vei2);
        listaVeiculos.insereInicio(vei3);
        listaCategorias.insereFim(cat1);
        listaCategorias.insereInicio(cat2);;
        listaVeiculos.inicioFim();
        listaVeiculos.remove(vei1);
        listaVeiculos.fimInicio();;
        listaCategorias.inicioFim();
        listaCategorias.remove(cat1);
        listaCategorias.fimInicio();
        listaCategorias.inicioFim();
        
        

        
    }
}
