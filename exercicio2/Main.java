package exercicio2;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(20, "João", 7.5);
        Aluno aluno2 = new Aluno(21, "Maria", 8.0);

        
        VetorAluno vetor = new VetorAluno(5);

        vetor.adiciona(aluno1);
        vetor.adiciona(aluno2);

        System.out.println("Quantidade de alunos no vetor: " + vetor.tamanho());
        
        System.out.println("\nLista de todos os alunos:");
        vetor.listarAlunos();
    }
}
