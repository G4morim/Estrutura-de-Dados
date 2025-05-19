package exercicio7;

public class PesquisaBinaria {

    public static int buscaBinariaIterativa(int[] vetor, int valor) {
        int inicio = 0;
        int fim = vetor.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == valor) return meio;
            else if (vetor[meio] > valor) fim = meio - 1;
            else inicio = meio + 1;
        }
        return -1;
    }

    public static int buscaBinariaRecursiva(int[] vetor, int valor, int inicio, int fim) {
        if (inicio > fim) return -1;
        int meio = (inicio + fim) / 2;
        if (vetor[meio] == valor) return meio;
        else if (vetor[meio] > valor) return buscaBinariaRecursiva(vetor, valor, inicio, meio - 1);
        else return buscaBinariaRecursiva(vetor, valor, meio + 1, fim);
    }

    public static void main(String[] args) {
        Vetor vetor = new Vetor(1000);
        vetor.popular();
        int[] dados = vetor.getElementos();
        int valorBuscado = 1000;

        long inicioIter = System.nanoTime();
        int resultadoIter = buscaBinariaIterativa(dados, valorBuscado);
        long fimIter = System.nanoTime();

        long inicioRec = System.nanoTime();
        int resultadoRec = buscaBinariaRecursiva(dados, valorBuscado, 0, dados.length - 1);
        long fimRec = System.nanoTime();

        System.out.println("Iterativa: Índice " + resultadoIter + " | Tempo: " + (fimIter - inicioIter) + " ns");
        System.out.println("Recursiva: Índice " + resultadoRec + " | Tempo: " + (fimRec - inicioRec) + " ns");
    }
}
