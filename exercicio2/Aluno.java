
package exercicio2;
public class Aluno{
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
    
}