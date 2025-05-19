package exercicio7;

public class Vetor {
    private int[] elementos;

    public Vetor(int tamanho) {
        elementos = new int[tamanho];
    }

    public void popular() {
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = i + 1;
        }
    }

    public int[] getElementos() {
        return elementos;
    }
}

