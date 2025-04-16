package trabalho1;

public class LDE {
    No inicio;
    No fim;

    public LDE() {
        inicio = null;
        fim = null;
    }

    public void inserirInicio(T valor){
        No<T> novoNo = new No<>(valor);
        if(inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
    }
}
