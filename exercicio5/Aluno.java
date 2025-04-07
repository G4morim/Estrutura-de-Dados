package exercicio5;

class Aluno {
    String nome;
    double nota;
    int idade;

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
