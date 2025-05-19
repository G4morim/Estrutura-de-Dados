package exercicio8;

import java.util.Random;

public class Vetor {
    private int[] elementos;

    public Vetor(int capacidade) {
        this.elementos = new int[capacidade];
    }

    
    public void preencherAleatorio() {
        Random rand = new Random();
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = rand.nextInt();
        }
    }

    public void bubbleSort() {
        int n = elementos.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (elementos[j] > elementos[j + 1]) {
                    int temp = elementos[j];
                    elementos[j] = elementos[j + 1];
                    elementos[j + 1] = temp;
                }
            }
        }
    }
} 
