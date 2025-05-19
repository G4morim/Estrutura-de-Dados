package exercicio11;

public class Noh {
    private Aluno aluno;
    private Noh prox;

    public Noh(Aluno aluno) {
        this.aluno = aluno;
        this.prox = null;
    }

    public Aluno getAluno() { return aluno; }
    public Noh getProx() { return prox; }
    public void setProx(Noh prox) { this.prox = prox; }
}