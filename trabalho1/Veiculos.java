package trabalho1;

public class Veiculos {
    private String placa;
    private String modelo;
    private int ano;
    private int potencia;
    private int lugares;
    private String marca;
    private String categoria;

    public Veiculos(int ano, String categoria, int lugares, String marca, String modelo, String placa, int potencia) {
        this.ano = ano;
        this.categoria = categoria;
        this.lugares = lugares;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.potencia = potencia;
    }
    
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    public int getLugares() {
        return lugares;
    }
    public void setLugares(int lugares) {
        this.lugares = lugares;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
}
