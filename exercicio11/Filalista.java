package exercicio11;

public class Filalista implements IFila {
    private Noh inicio;
    private Noh fim;
    private int tamanho;

    public Filalista() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public boolean add(Aluno aluno) {
        Noh novoNoh = new Noh(aluno);
        if (isEmpty()) {
            inicio = novoNoh;
            fim = novoNoh;
        } else {
            fim.setProx(novoNoh);
            fim = novoNoh;
        }
        tamanho++;
        return true;
    }

    @Override
    public boolean remove() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return false;
        }
        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.getProx();
        }
        tamanho--;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return (inicio == null);
    }

    @Override
    public int size() {
        return tamanho;
    }

    public void imprimirFila() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return;
        }
        Noh atual = inicio;
        System.out.println("--- Estado da Fila ---");
        while (atual != null) {
            System.out.println(atual.getAluno());
            atual = atual.getProx();
        }
        System.out.println("-----------------------");
    }
}
