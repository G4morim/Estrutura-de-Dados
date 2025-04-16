package trabalho1;

class No<T> {
    T valor;
    No<T> anterior;
    No<T> proximo;

    No(T valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}