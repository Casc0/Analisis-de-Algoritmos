package Algoritmia;
import java.util.Scanner;

public class primos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limite, cont, cantPrimos = 0;
        boolean esPrimo;

        System.out.println("Ingrese el limite de los numeros primos");
        limite = sc.nextInt();

        for (int i = 2; i <= limite; i++) {
            //los primos son impares excepto por el 2
            esPrimo = ((i % 2) != 0) || i == 2;
            cont = 3;

            while(esPrimo && cont <= Math.sqrt(i)) {
                esPrimo = (i % cont) != 0;
                cont++;
            }

            if(esPrimo) {
                cantPrimos++;
            }
        }

        System.out.println("Entre 1 y " + limite + " hay " + cantPrimos + " numero primos");
    }
}
