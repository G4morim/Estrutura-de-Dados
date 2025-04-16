package trabalho1;

public class Clientes {
    private String nome;
    private String cpf;
    private String telefone;

    public Clientes(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nome='" + nome + '\'' + ", cpf='" + cpf + '\'' + ", telefone='" + telefone + '\'' + '}'; 
            }
}
