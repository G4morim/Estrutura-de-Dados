package trabalho1;

public class Categoria {
    String nome;
    long id;

    public Categoria(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Categoria{" + "nome='" + nome + '\'' + ", id=" + id + '}';
    }
}
