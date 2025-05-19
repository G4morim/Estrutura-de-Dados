package revisao_p1.exercicio1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura do tamanho dos vetores
        System.out.print("Digite o tamanho dos vetores: ");
        int n = scanner.nextInt();

        int[] vetorA = new int[n];
        int[] vetorB = new int[n];

        // Leitura do vetor A
        System.out.println("Digite os elementos do vetor A:");
        for (int i = 0; i < n; i++) {
            vetorA[i] = scanner.nextInt();
        }

        // Leitura do vetor B
        System.out.println("Digite os elementos do vetor B:");
        for (int i = 0; i < n; i++) {
            vetorB[i] = scanner.nextInt();
        }

        // Vetor marcador para evitar reutilizar elementos de B
        boolean[] usadoB = new boolean[n];

        // Vetor de interseção com tamanho máximo n (sem desperdício final)
        int[] intersecaoTemp = new int[n];
        int contador = 0;

        // Comparar elementos de A com B
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vetorA[i] == vetorB[j] && !usadoB[j]) {
                    intersecaoTemp[contador++] = vetorA[i];
                    usadoB[j] = true;
                    break; // Impede múltiplas contagens do mesmo elemento
                }
            }
        }

        // Imprimir a interseção
        System.out.println("Elementos em comum:");
        for (int i = 0; i < contador; i++) {
            System.out.print(intersecaoTemp[i] + " ");
        }

    }
}
