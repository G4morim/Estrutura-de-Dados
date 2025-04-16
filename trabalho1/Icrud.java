package trabalho1;

interface  Icrud<T> {
    void incluir(T valor);
    void excluir(T valor);
    void editar(T valor);
    void listar(boolean ordemCrescente);
    T buscar(T chave);
}
