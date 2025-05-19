package exercicio6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite o valor de n: ");
        int n = entrada.nextInt();
        
        System.out.println("Digite a sequência de números:");
        imprimirInverso(n, entrada);
        
        entrada.close();
    }

    
    public static void imprimirInverso(int n, Scanner entrada) {
        if (n > 0) {
            int numero = entrada.nextInt(); 
            imprimirInverso(n - 1, entrada); 
            System.out.println(numero); 
        }
    }
}