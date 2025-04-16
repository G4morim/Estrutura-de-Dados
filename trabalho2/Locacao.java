package trabalho2;

class Locacao {
    private String CNH;
    private String placa;
    private Date dataRetirada;
    private Date dataDevolucao;
    private double valor;

    public Locacao(String CNH, String placa, Date dataRetirada, Date dataDevolucao, double valor) {
        this.CNH = CNH;
        this.placa = placa;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.valor = valor;
    }

    public String getCNH() {
        return CNH;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Locacao locacao = (Locacao) obj;
        return placa.equals(locacao.placa);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Locacao{" +
                "CNH='" + CNH + '\'' +
                ", placa='" + placa + '\'' +
                ", dataRetirada=" + sdf.format(dataRetirada) +
                ", dataDevolucao=" + sdf.format(dataDevolucao) +
                ", valor=" + valor +
                '}';
    }
}
