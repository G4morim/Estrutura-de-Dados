package exercicio8;

public class Main {
    public static void main(String[] args) {
        int[] tamanhos = {1000, 10000, 100000}; 

        for (int tamanho : tamanhos) {
            Vetor vetor = new Vetor(tamanho);
            vetor.preencherAleatorio();

            
            long inicio = System.nanoTime();
            vetor.bubbleSort(); // Executa a ordenação
            long fim = System.nanoTime();

            long duracaoMs = (fim - inicio) / 1_000_000;

            System.out.println("Tamanho: " + tamanho + " - Tempo: " + duracaoMs + " ms");
        }
    }
}