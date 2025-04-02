package exercicio3;

public class Aluno {
    private String nome;
    private int idade;
    private double nota;

    public Aluno(int idade, String nome, double nota) {
        this.idade = idade;
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public double getNota() {
        return nota;
    }
    
    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aluno aluno = (Aluno) obj;
        return idade == aluno.idade && nome.equals(aluno.nome) && Double.compare(aluno.nota, nota) == 0;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome='" + nome + '\'' + ", idade=" + idade + ", nota=" + nota + '}';
    }
}