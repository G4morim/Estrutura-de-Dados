package exercicio2;

public class VetorAluno {

    // Array para armazenar os objetos do tipo Aluno
    private Aluno[] alunos;
    
    // Contador que mantém o número atual de alunos no vetor
    private int totalAlunos;
    
    // Construtor que inicializa o vetor com a capacidade informada
    public VetorAluno(int capacidade) {
        this.alunos = new Aluno[capacidade]; // Cria um array com o tamanho especificado
        this.totalAlunos = 0; // Inicializa o contador de alunos como zero
    }

    // Método para adicionar um aluno ao vetor
    public void adiciona(Aluno aluno) {
        // Verifica se ainda há espaço disponível no vetor
        if (totalAlunos < alunos.length) {
            this.alunos[totalAlunos] = aluno; // Adiciona o aluno na próxima posição disponível
            totalAlunos++; // Incrementa o total de alunos armazenados
        } else {
            System.out.println("Capacidade máxima atingida!"); // Exibe mensagem caso o vetor esteja cheio
        }
    }

    // Método que retorna o número total de alunos armazenados
    public int tamanho() {
        return this.totalAlunos;
    }

    // Método que verifica se um determinado aluno já está no vetor
    public boolean contem(Aluno aluno) {
        // Percorre todas as posições ocupadas no vetor
        for (int i = 0; i < totalAlunos; i++) {
            // Compara se o aluno passado como argumento já existe no vetor
            if (alunos[i].equals(aluno)) {
                return true; // Retorna true se encontrar o aluno
            }
        }
        return false; // Retorna false caso o aluno não seja encontrado
    }

    // Método que lista todos os alunos armazenados no vetor
    public void listarAlunos() {
        // Percorre todas as posições ocupadas no vetor
        for (int i = 0; i < totalAlunos; i++) {
            System.out.println(alunos[i]); // Exibe as informações de cada aluno
        }
    }
}
