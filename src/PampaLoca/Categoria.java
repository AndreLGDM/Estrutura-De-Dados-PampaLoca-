package PampaLoca;

public class Categoria {
    private int idCategoria;
    private String nomeCategoria;

    public Categoria(int idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria(){
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String toString() {
        return "Categoria {"+" Id: " + getIdCategoria() + " | Nome: " + getNomeCategoria()+" }";
    }

    public static String toString(Categoria categoria) {
        return null;
    }
}
