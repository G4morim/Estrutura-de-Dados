package revisao_p1.exercicio2;

public class No {
    int valor;
    no proximo;
    no anterior;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}
