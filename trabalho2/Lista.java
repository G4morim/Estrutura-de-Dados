package trabalho2;

class Lista<T> {
    private Node<T> inicio;
    private Node<T> fim;
    private int tamanho;

    private static class Node<T> {
        T dado;
        Node<T> proximo;
        Node<T> anterior;

        Node(T dado) {
            this.dado = dado;
            this.proximo = null;
            this.anterior = null;
        }
    }

    public Lista() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public void adicionar(T elemento) {
        Node<T> novoNode = new Node<>(elemento);
        if (inicio == null) {
            inicio = novoNode;
            fim = novoNode;
        } else {
            fim.proximo = novoNode;
            novoNode.anterior = fim;
            fim = novoNode;
        }
        tamanho++;
    }

    public void remover(T elemento) {
        Node<T> atual = inicio;
        while (atual != null) {
            if (atual.dado.equals(elemento)) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    inicio = atual.proximo;
                }

                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    fim = atual.anterior;
                }

                tamanho--;
                return;
            }
            atual = atual.proximo;
        }
    }

    public T buscar(T chave) {
        Node<T> atual = inicio;
        while (atual != null) {
            if (atual.dado.equals(chave)) {
                return atual.dado;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void listar(boolean ordemCrescente) {
        if (ordemCrescente) {
            Node<T> atual = inicio;
            while (atual != null) {
                System.out.println(atual.dado);
                atual = atual.proximo;
            }
        } else {
            Node<T> atual = fim;
            while (atual != null) {
                System.out.println(atual.dado);
                atual = atual.anterior;
            }
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean contem(T elemento) {
        Node<T> atual = inicio;
        while (atual != null) {
            if (atual.dado.equals(elemento)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public T obter(int indice) {
        if (indice < 0 || indice >= tamanho) {  
            return null;
        }

        Node<T> atual = inicio;
        for (int i = 0; i < indice; i++) {
            atual = atual.proximo;
        }
        return atual.dado;
    }
}
