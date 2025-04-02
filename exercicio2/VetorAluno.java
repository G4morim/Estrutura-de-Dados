package exercicio2;

public class VetorAluno {

    private Aluno[] alunos;
    private int totalAlunos;
    
    public VetorAluno(int capacidade) {
        this.alunos = new Aluno[capacidade];
        this.totalAlunos = 0;
    }

    public void adiciona(Aluno aluno) {
        if (totalAlunos < alunos.length) {
            this.alunos[totalAlunos] = aluno;
            totalAlunos++;
        } else {
            System.out.println("Capacidade máxima atingida!");
        }
    }

    public int tamanho() {
        return this.totalAlunos;
    }

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].equals(aluno)) {
                return true;
            }
        }
        return false;
    }

    public void listarAlunos() {
        for (int i = 0; i < totalAlunos; i++) {
            System.out.println(alunos[i]);
        }
    }
}
