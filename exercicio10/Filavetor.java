package exercicio10;

public class Filavetor implements IFila {
    private Object[] vetFila;
    private int inicio;
    private int nElemFila;

    // Construtor
    public Filavetor(int capacidade) {
        this.vetFila = new Object[capacidade];
        this.inicio = 0;
        this.nElemFila = 0;
    }

    @Override
    public boolean add(Object info) {
        if (nElemFila == vetFila.length) {
            System.out.println("Fila cheia! Não é possível adicionar.");
            return false;
        }
        int fim = (inicio + nElemFila) % vetFila.length;
        vetFila[fim] = info;
        nElemFila++;
        return true;
    }

    @Override
    public boolean remove() {
        if (isEmpty()) {
            System.out.println("Fila vazia! Não é possível remover.");
            return false;
        }
        inicio = (inicio + 1) % vetFila.length;
        nElemFila--;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return (nElemFila == 0);
    }

    @Override
    public int size() {
        return nElemFila;
    }

    
    public void imprimirFila() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return;
        }
        System.out.println("--- Estado da Fila ---");
        for (int i = 0; i < nElemFila; i++) {
            int pos = (inicio + i) % vetFila.length; 
            System.out.println("Posição " + pos + ": " + vetFila[pos]);
        }
        System.out.println("-----------------------");
    }
}