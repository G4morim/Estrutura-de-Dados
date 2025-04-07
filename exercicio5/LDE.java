package exercicio5;

class LDE {
    No inicio;
    No fim;

    public LDE() {
        inicio = null;
        fim = null;
    }

    public void inserirInicio(Aluno aluno) {
        No novo = new No(aluno);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
    }

    public void inserirFim(Aluno aluno) {
        No novo = new No(aluno);
        if (fim == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void removerPorNome(String nome) {
        No atual = inicio;

        while (atual != null) {
            if (atual.aluno.nome.equalsIgnoreCase(nome)) {
                if (atual == inicio && atual == fim) {
                    inicio = fim = null;
                } else if (atual == inicio) {
                    inicio = inicio.proximo;
                    inicio.anterior = null;
                } else if (atual == fim) {
                    fim = fim.anterior;
                    fim.proximo = null;
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
                System.out.println("Aluno " + nome + " removido.");
                return;
            }
            atual = atual.proximo;
        }

        System.out.println("Aluno " + nome + " não encontrado.");
    }

    public void exibir() {
        No atual = inicio;
        System.out.println("Lista de Alunos:");
        while (atual != null) {
            System.out.println(atual.aluno);
            atual = atual.proximo;
        }
    }
}

