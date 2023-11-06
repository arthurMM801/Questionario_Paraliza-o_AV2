package Q1_Bhaskara;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);
        System.out.println("Escreva os valores de a, b e c da equação:");
        double a = dados.nextDouble();
        double b = dados.nextDouble();
        double c = dados.nextDouble();

        BhasKara formula = new BhasKara(a, b, c);
        formula.calcula();
    }
}