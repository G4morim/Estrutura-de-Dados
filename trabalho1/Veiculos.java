package trabalho1;

public class Veiculos implements Icrud {

    private String placa;
    private String modelo;
    private int ano;
    private int potencia;
    private int lugares;
    private String marca;
    private Categoria categoria;

    public Veiculos(int ano, Categoria categoria, int lugares, String marca, String modelo, String placa, int potencia) {
        this.ano = ano;
        this.categoria = categoria;
        this.lugares = lugares;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.potencia = potencia;
    }

    @Override
    public void incluir(Object obj) {
        // Implementation for including an object
    }

    @Override
    public Object buscar(Object obj) {
        // Implementation for searching an object
        return null;
    }

    @Override
    public void editar(Object obj) {
        // Implementation for editing an object
    }

    @Override
    public void excluir(Object obj) {
        // Implementation for deleting an object
    }

    @Override
    public void listar(boolean flag) {
        // Implementation for listing objects
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
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Veiculos{" + "placa='" + placa + '\'' + ", modelo='" + modelo + '\'' + ", ano=" + ano + ", potencia=" + potencia + ", lugares=" + lugares + ", marca='" + marca + '\'' + ", categoria='" + categoria + '\'' + '}';
    }
    
}
