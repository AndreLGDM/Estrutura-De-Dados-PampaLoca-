import Categoria.Categoria;
import Categoria.LDECategorias;
import Veiculo.LDEVeiculos;
import Veiculo.Veiculo;

public class App {
    public static void main(String[] args) throws Exception {
        
        LDECategorias listaCategorias = new LDECategorias();

        Categoria cat1 = new Categoria(1111, "Carro");
        Categoria cat2 = new Categoria(1010, "Moto");
        Categoria cat3 = new Categoria(1000, "Bicicleta");

        listaCategorias.insereFim(cat1);
        listaCategorias.insereInicio(cat2);
        listaCategorias.insereInicio(cat3);
        listaCategorias.remove(1000);
        System.out.println(listaCategorias.inicioFim());

        LDEVeiculos listaVeiculos = new LDEVeiculos();

        Veiculo vei1 = new Veiculo("ABC1234", "Uno", "Fiat", 2010, 200, 4, cat1);
        Veiculo vei2 = new Veiculo("AAA1111", "Bis", "Honda", 2020, 10, 2, cat2);
        Veiculo vei3 = new Veiculo("BAC4321", "Gol", "Fiat", 2000, 500, 6, cat1);

        listaVeiculos.insereFim(vei1);
        listaVeiculos.insereInicio(vei2);
        listaVeiculos.insereInicio(vei3);
        listaVeiculos.remove("BAC4321");
        System.out.println(listaVeiculos.inicioFim());

        System.out.println("Hello, World!");
    }
}
