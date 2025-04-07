package exercicio4;

class ListaEncadeada<T> {
    private No<T> inicio;

    public ListaEncadeada() {
        this.inicio = null;
    }

    public void inserir(T info) {
        No<T> novoNo = new No<>(info);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    public void imprimir() {
        No<T> atual = inicio;
        while (atual != null) {
            System.out.println(atual.info);
            atual = atual.proximo;
        }
    }
}
