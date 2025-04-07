package exercicio4;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Aluno> listaAlunos = new ListaEncadeada<>();

        listaAlunos.inserir(new Aluno("João", 8.5, 20));
        listaAlunos.inserir(new Aluno("Maria", 9.0, 22));
        listaAlunos.inserir(new Aluno("Carlos", 7.5, 19));

        System.out.println("Lista de Alunos:");
        listaAlunos.imprimir();
    }
}
