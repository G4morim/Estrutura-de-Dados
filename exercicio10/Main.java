package exercicio10;

public class Main {
    public static void main(String[] args) {
        Filavetor fila = new Filavetor(5);

        fila.add("Cliente 1");
        fila.add("Cliente 2");
        fila.add("Cliente 3");
        fila.imprimirFila();
    
        fila.remove();
        fila.imprimirFila();

        fila.add("Cliente 4");
        fila.add("Cliente 5");
        fila.add("Cliente 6");
        fila.imprimirFila();

        fila.remove();
        fila.remove();
        fila.remove();
        fila.remove(); 
        fila.imprimirFila();
    }
}