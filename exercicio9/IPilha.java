package exercicio9;

public interface IPilha {
    public boolean push(Aluno aluno);
    public Aluno pop();
    public Aluno top();
    public boolean isEmpty();
    public int size();
}