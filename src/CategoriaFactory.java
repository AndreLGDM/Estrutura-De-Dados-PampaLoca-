
import java.util.Scanner;

public class CategoriaFactory {
    
    public static Categoria criarCategoria(Scanner in){
        Categoria categoria = new Categoria();
        System.out.print("Digite a id categoria: ");
        categoria.setIdCategoria(in.nextInt());
        System.out.print("Digite o nome da categoria: ");
        categoria.setNomeCategoria(in.next());
        return categoria;
    }
}
