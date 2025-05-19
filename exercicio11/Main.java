package exercicio11;

public class Main {
    public static void main(String[] args) {
        Filalista fila = new Filalista();

        
        fila.add(new Aluno("João", 101));
        fila.add(new Aluno("Maria", 102));
        fila.add(new Aluno("Carlos", 103));
        
        fila.imprimirFila();

        fila.remove();
        fila.imprimirFila();

        fila.remove();
        fila.imprimirFila();

        System.out.println("Tamanho da fila: " + fila.size());
    }
}