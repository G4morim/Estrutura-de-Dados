package exercicio1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x, y;
        System.out.println("Digite as coordenadas do ponto 1: ");
        x = input.nextDouble();
        y = input.nextDouble();
        PontoCartesiano ponto1 = new PontoCartesiano(x, y);
        System.out.println("Digite as coordenadas do ponto 2: ");
        x = input.nextDouble();
        y = input.nextDouble();
        PontoCartesiano ponto2 = new PontoCartesiano(x, y);
        System.out.println("Ponto 1: {" + ponto1.getX() + ", " + ponto1.getY() + "} ");
        System.out.println("Ponto 2: {" + ponto2.getX() + ", " + ponto2.getY() + "} ");
        System.out.println("Distância entre os pontos: "
                + ponto1.calcularDistanciaEuclideana(ponto2));
        input.close();
    }
}
