public class Veiculo extends Categoria {
    private String placaVeiculo;
    private String modeloVeiculo;
    private String marcaVeiculo;
    private int anoVeiculo;
    private int potenciaVeiculo;
    private int lugaresVeiculo;

    public Veiculo(String placaVeiculo, String modeloVeiculo, String marcaVeiculo, int anoVeiculo, int potenciaVeiculo, int lugaresVeiculo, int idCategoria) {
        super(idCategoria, marcaVeiculo);
        this.placaVeiculo = placaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.potenciaVeiculo = potenciaVeiculo;
        this.lugaresVeiculo = lugaresVeiculo;
    }

    public String getPlacaVeiculo() { return placaVeiculo; }
    public String getModeloVeiculo() { return modeloVeiculo; }
    public String getMarcaVeiculo() { return marcaVeiculo; }
    public int getAnoVeiculo() { return anoVeiculo; }
    public int getPotenciaVeiculo() { return potenciaVeiculo; }
    public int getLugaresVeiculo() { return lugaresVeiculo; }

    public void setPlacaVeiculo(String placaVeiculo) { this.placaVeiculo = placaVeiculo; }
    public void setModeloVeiculo(String modeloVeiculo) { this.modeloVeiculo = modeloVeiculo; }
    public void setMarcaVeiculo(String marcaVeiculo) { this.marcaVeiculo = marcaVeiculo; }
    public void setAnoVeiculo(int anoVeiculo) { this.anoVeiculo = anoVeiculo; }
    public void setPotenciaVeiculo(int potenciaVeiculo) { this.potenciaVeiculo = potenciaVeiculo; }
    public void setLugaresVeiculo(int lugaresVeiculo) { this.lugaresVeiculo = lugaresVeiculo; }

    public String toString() {
        return "Placa: "+getPlacaVeiculo()+" | Modelo: "+getModeloVeiculo()+" | Marca: "+getMarcaVeiculo()+" | Ano: "+getAnoVeiculo()+" | Potência: "+getPotenciaVeiculo()+" | Lugares: "+getLugaresVeiculo()+" | Categoria: "+getIdCategoria();
    }
}
