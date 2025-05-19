package exercicio7;

public class Main {
    public static void main(String[] args) {
        
        Vetor vetor = new Vetor(1000);
        vetor.popular();
        int[] dados = vetor.getElementos();
        int valorBuscado = 1000;

        
        long inicioIter = System.nanoTime();
        int resultadoIter = PesquisaBinaria.buscaBinariaIterativa(dados, valorBuscado);
        long fimIter = System.nanoTime();

        
        long inicioRec = System.nanoTime();
        int resultadoRec = PesquisaBinaria.buscaBinariaRecursiva(dados, valorBuscado, 0, dados.length - 1);
        long fimRec = System.nanoTime();

        
        System.out.println("Resultado (Iterativa): Índice " + resultadoIter + " | Tempo: " + (fimIter - inicioIter) + " ns");

        System.out.println("Resultado (Recursiva): Índice " + resultadoRec + " | Tempo: " + (fimRec - inicioRec) + " ns");
    }
}

