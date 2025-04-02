/**
 * alocação dinâmica de memória é um processo no qual um programa solicita espaço de 
 * memória em tempo de execução, ao contrário da alocação estática, onde o espaço é 
 * definido previamente no código. Esse conceito permite que um programa utilize apenas
 *  a quantidade de memória necessária no momento, tornando o uso da RAM mais eficiente.
 */

package exercicio3;

public class VetorAluno implements Ivetor {
    // Vetor de alunos com capacidade inicial de 5 elementos
    private Aluno[] alunos = new Aluno[5];
    private int totalAlunos = 0; // Contador de alunos no vetor

    @Override
    public void adiciona(Aluno aluno) {
        this.garanteEspaco(); // Garante que há espaço suficiente antes de adicionar
        this.alunos[this.totalAlunos] = aluno;
        this.totalAlunos++;
    }

    @Override
    public int tamanho() {
        return this.totalAlunos; // Retorna o número atual de alunos armazenados
    }

    @Override
    public boolean contem(Aluno aluno) {
        // Verifica se o aluno está presente no vetor
        for (int i = 0; i < this.totalAlunos; i++) {
            if (this.alunos[i].equals(aluno)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cheio() {
        // Verifica se o vetor está cheio
        return this.totalAlunos == this.alunos.length;
    }

    @Override
    public boolean remover(Aluno aluno) {
        int indice = -1;
        // Busca pelo índice do aluno a ser removido
        for (int i = 0; i < totalAlunos; i++) {
            if (this.alunos[i].equals(aluno)) {
                indice = i;
                break;
            }
        }
        // Se o aluno foi encontrado, remove e reorganiza o vetor
        if (indice != -1) {
            for (int i = indice; i < (totalAlunos - 1); i++) {
                this.alunos[i] = this.alunos[i + 1];
            }
            totalAlunos--; // Reduz o total de alunos
            return true;
        }
        return false;
    }

    private void garanteEspaco() {
        // Duplica a capacidade do vetor caso esteja cheio
        if (this.cheio()) {
            Aluno[] novoAlunos = new Aluno[this.alunos.length * 2];
            for (int i = 0; i < this.alunos.length; i++) {
                novoAlunos[i] = this.alunos[i];
            }
            this.alunos = novoAlunos;
        }
    }

    public Aluno[] getAlunos() {
        // Retorna apenas os alunos armazenados, sem espaços vazios
        Aluno[] alunosOcupados = new Aluno[totalAlunos];
        for (int i = 0; i < totalAlunos; i++) {
            alunosOcupados[i] = this.alunos[i];
        }
        return alunosOcupados;
    }

    public int capacidadeAtual() {
        // Retorna a capacidade total atual do vetor
        return this.alunos.length;
    }
}
