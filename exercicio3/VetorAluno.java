package exercicio3;

public class VetorAluno implements Ivetor {

    private double[] notas = new double[5];
    private int totalNotas = 0;

    @Override
    public void adiciona(double nota) {
        this.garanteEspaco();
        this.notas[this.totalNotas] = nota;
        this.totalNotas++;
    }

    @Override
    public int tamanho() {
        return this.notas.length;
    }

    @Override
    public boolean contem(double nota) {
        for (int i = 0; i < this.totalNotas; i++) {
            if (nota == this.notas[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cheio() {
        return this.totalNotas == this.notas.length;
    }

    @Override
    public boolean remover(double nota) {
        int indice = -1;
        for (int i = 0; i < totalNotas; i++) {
            if (this.notas[i] == nota) {
                indice = i;
                break;
            }
        }

        if (indice != -1) {
            for (int i = indice; i < (totalNotas - 1); i++) {
                this.notas[i] = this.notas[i + 1];
            }
            totalNotas--;
            return true;
        }
        return false;
    }

    private void garanteEspaco() {
        if (this.cheio()) {
            double[] novoVetor = new double[this.notas.length * 2];
            for (int i = 0; i < this.notas.length; i++) {
                novoVetor[i] = this.notas[i];
            }
            this.notas = novoVetor;
        }
    }

}
