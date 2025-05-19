package exercicio9;

public class Main {
    public static void main(String[] args) {
        PilhaLista pilha = new PilhaLista();

        
        pilha.push(new Aluno("João", 101));
        pilha.push(new Aluno("Maria", 102));
        pilha.push(new Aluno("Carlos", 103));

        pilha.imprimirPilha();
        
        System.out.println("Removido: " + pilha.pop());
        pilha.imprimirPilha();
        
        System.out.println("Topo atual: " + pilha.top());
        
        System.out.println("Tamanho da pilha: " + pilha.size());
    }
}
