package revisao_p1.exercicio2;

public class LDE {
    No inicio;
    No fim;

    public LDE() {
        inicio = null;
        fim = null;
    }

    public void add(int valor){
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }
}
