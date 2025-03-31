package exercicio2;
public class Main {
    public static void main(String[] args) {
       Aluno aluno1 = new Aluno(20, "João", 7.5);
       Aluno aluno2 = new Aluno(21, "Maria", 8.0);

        VetorAluno vetor = new VetorAluno();

        vetor.adiciona(aluno1.getNota());
        vetor.adiciona(aluno2.getNota());

        vetor.tamanho();
        System.out.println(vetor.contem(aluno1.getNota()));

    }
}