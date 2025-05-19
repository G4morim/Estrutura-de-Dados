package exercicio9;

public class PilhaLista implements IPilha {
    private Node topo;
    private int tamanho;

    private static class Node {
        Aluno aluno;
        Node proximo;

        Node(Aluno aluno) {
            this.aluno = aluno;
            this.proximo = null;
        }
    }

    @Override
    public boolean push(Aluno aluno) {
        Node novoNode = new Node(aluno);
        novoNode.proximo = topo; 
        topo = novoNode; 
        tamanho++;
        return true;
    }

    @Override
    public Aluno pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        Aluno alunoRemovido = topo.aluno;
        topo = topo.proximo; 
        tamanho--;
        return alunoRemovido;
    }

    @Override
    public Aluno top() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        return topo.aluno;
    }

    @Override
    public boolean isEmpty() {
        return topo == null;
    }

    @Override
    public int size() {
        return tamanho;
    }

    public void imprimirPilha() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return;
        }
        Node atual = topo;
        System.out.println("--- Estado da Pilha ---");
        while (atual != null) {
            System.out.println(atual.aluno);
            atual = atual.proximo;
        }
        System.out.println("------------------------");
    }
}