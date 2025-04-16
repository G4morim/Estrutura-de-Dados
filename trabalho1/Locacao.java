package trabalho1;

public class Locacao {
    private Clientes cliente;
    private Veiculos veiculo;
    private String dataInicio;
    private String dataFim;
    private double valorDiaria;

    public Locacao(Clientes cliente, String dataFim, String dataInicio, double valorDiaria, Veiculos veiculo) {
        this.cliente = cliente;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.valorDiaria = valorDiaria;
        this.veiculo = veiculo;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
