package exercicio3;

public class VetorAluno implements Ivetor {
    private Aluno[] alunos = new Aluno[5];
    private int totalAlunos = 0;

    @Override
    public void adiciona(Aluno aluno) {
        this.garanteEspaco();
        this.alunos[this.totalAlunos] = aluno;
        this.totalAlunos++;
    }

    @Override
    public int tamanho() {
        return this.totalAlunos;
    }

    @Override
    public boolean contem(Aluno aluno) {
        for (int i = 0; i < this.totalAlunos; i++) {
            if (this.alunos[i].equals(aluno)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cheio() {
        return this.totalAlunos == this.alunos.length;
    }

    @Override
    public boolean remover(Aluno aluno) {
        int indice = -1;
        for (int i = 0; i < totalAlunos; i++) {
            if (this.alunos[i].equals(aluno)) {
                indice = i;
                break;
            }
        }

        if (indice != -1) {
            for (int i = indice; i < (totalAlunos - 1); i++) {
                this.alunos[i] = this.alunos[i + 1];
            }
            totalAlunos--;
            return true;
        }
        return false;
    }

    private void garanteEspaco() {
        if (this.cheio()) {
            Aluno[] novoAlunos = new Aluno[this.alunos.length * 2];
            for (int i = 0; i < this.alunos.length; i++) {
                novoAlunos[i] = this.alunos[i];
            }
            this.alunos = novoAlunos;
        }
    }

    public Aluno[] getAlunos() {
        Aluno[] alunosOcupados = new Aluno[totalAlunos];
        for (int i = 0; i < totalAlunos; i++) {
            alunosOcupados[i] = this.alunos[i];
        }
        return alunosOcupados;
    }

    public int capacidadeAtual() {
        return this.alunos.length;
    }
}
