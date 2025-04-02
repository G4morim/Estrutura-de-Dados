package exercicio3;

public class Main {
    public static void main(String[] args) {
        
        Aluno aluno1 = new Aluno(20, "João", 7.5);
        Aluno aluno2 = new Aluno(21, "Maria", 8.0);
        Aluno aluno3 = new Aluno(22, "José", 6.0);
        Aluno aluno4 = new Aluno(23, "Ana", 9.0);
        Aluno aluno5 = new Aluno(24, "Carlos", 8.5);
        Aluno aluno6 = new Aluno(25, "Beatriz", 7.0);
        
        VetorAluno vetor = new VetorAluno();
        
        System.out.println("Capacidade inicial do vetor: " + vetor.capacidadeAtual());
        
        vetor.adiciona(aluno1);
        vetor.adiciona(aluno2);
        vetor.adiciona(aluno3);
        vetor.adiciona(aluno4);
        vetor.adiciona(aluno5);
        
        System.out.println("Tamanho atual do vetor (deve ser 5): " + vetor.tamanho());
        System.out.println("Capacidade atual do vetor: " + vetor.capacidadeAtual());
        
        vetor.adiciona(aluno6);
        System.out.println("\nTamanho após adicionar um aluno extra (deve ser 6): " + vetor.tamanho());
        System.out.println("Capacidade atual do vetor (deve ser 10): " + vetor.capacidadeAtual());

        System.out.println("\nLista de todos os alunos restantes:");
        for (Aluno aluno : vetor.getAlunos()) {
            System.out.println(aluno);
        }
    }
}