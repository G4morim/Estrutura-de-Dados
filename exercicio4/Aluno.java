package exercicio4;

public class Aluno {
    private String nome;
    private double nota;
    private int idade;

    public Aluno(String nome, double nota, int idade) {
        this.nome = nome;
        this.nota = nota;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Aluno{" + "Nome='" + nome + '\'' + ", Nota=" + nota + ", Idade=" + idade + '}';
    }
} 

