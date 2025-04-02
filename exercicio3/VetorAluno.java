package exercicio3;

public class VetorAluno implements Ivetor {
    // Declara um array de alunos com capacidade inicial de 5 posições
    private Aluno[] alunos = new Aluno[5];

    // Variável que armazena a quantidade real de alunos cadastrados no vetor
    private int totalAlunos = 0;

    // Método para adicionar um novo aluno ao vetor
    @Override
    public void adiciona(Aluno aluno) {
        this.garanteEspaco(); // Garante que há espaço antes de adicionar um novo aluno
        this.alunos[this.totalAlunos] = aluno; // Insere o aluno na próxima posição disponível
        this.totalAlunos++; // Incrementa o contador de alunos armazenados
    }

    // Método que retorna a quantidade atual de alunos no vetor
    @Override
    public int tamanho() {
        return this.totalAlunos;
    }

    // Método que verifica se um determinado aluno está presente no vetor
    @Override
    public boolean contem(Aluno aluno) {
        for (int i = 0; i < this.totalAlunos; i++) {
            if (this.alunos[i].equals(aluno)) {
                return true; // Retorna true se encontrar o aluno
            }
        }
        return false; // Retorna false se o aluno não estiver na lista
    }

    // Método que verifica se o vetor está completamente cheio
    @Override
    public boolean cheio() {
        return this.totalAlunos == this.alunos.length; // Compara o total de alunos com a capacidade do vetor
    }

    // Método para remover um aluno do vetor
    @Override
    public boolean remover(Aluno aluno) {
        int indice = -1; // Índice onde o aluno está armazenado

        // Procura o aluno no vetor
        for (int i = 0; i < totalAlunos; i++) {
            if (this.alunos[i].equals(aluno)) {
                indice = i; // Guarda a posição do aluno encontrado
                break;
            }
        }

        if (indice != -1) { // Se o aluno foi encontrado
            // Desloca os elementos para preencher a posição removida
            for (int i = indice; i < (totalAlunos - 1); i++) {
                this.alunos[i] = this.alunos[i + 1];
            }
            totalAlunos--; // Diminui o contador de alunos cadastrados
            return true; // Retorna true para indicar sucesso na remoção
        }
        return false; // Retorna false se o aluno não foi encontrado
    }

    // Método que expande dinamicamente o tamanho do vetor quando necessário
    private void garanteEspaco() {
        if (this.cheio()) { // Se o vetor estiver cheio
            // Cria um novo vetor com o dobro da capacidade atual
            Aluno[] novoAlunos = new Aluno[this.alunos.length * 2];

            // Copia os elementos do vetor antigo para o novo
            for (int i = 0; i < this.alunos.length; i++) {
                novoAlunos[i] = this.alunos[i];
            }

            // Substitui o vetor antigo pelo novo vetor expandido
            this.alunos = novoAlunos;
        }
    }

    // Método que retorna um array com apenas os alunos armazenados (sem espaços vazios)
    public Aluno[] getAlunos() {
        Aluno[] alunosOcupados = new Aluno[totalAlunos]; // Cria um novo vetor apenas com o tamanho necessário
        for (int i = 0; i < totalAlunos; i++) {
            alunosOcupados[i] = this.alunos[i]; // Copia os alunos para o novo vetor
        }
        return alunosOcupados;
    }

    // Método que retorna a capacidade atual do vetor
    public int capacidadeAtual() {
        return this.alunos.length; // Retorna o tamanho total do vetor (incluindo espaços vazios)
    }
}
