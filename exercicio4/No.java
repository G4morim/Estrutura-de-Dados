package exercicio4;

class No<T> {
    T info;
    No<T> proximo;

    public No(T info) {
        this.info = info;
        this.proximo = null;
    }
}

