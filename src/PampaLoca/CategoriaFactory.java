package PampaLoca;

public class CategoriaFactory {
    
    public static Categoria criarCategoria(int ID, String Nome){
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(ID);
        categoria.setNomeCategoria(Nome);
        return categoria;
    }
}
