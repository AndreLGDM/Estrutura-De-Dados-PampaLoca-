public class App {
    public static void main(String[] args) throws Exception {

        Categoria testeCategoria = new Categoria(1111, "Categoria");
        System.out.println(testeCategoria.toString());

        Veiculo testeVeiculo = new Veiculo("ABC-1234", "Uno", "Fiat", 2010, 200, 4, testeCategoria.getIdCategoria());
        System.out.println(testeVeiculo.toString());

        System.out.println("Hello, World!");
    }
}
