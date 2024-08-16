package Algoritmia;
import java.util.Random;
import java.util.Scanner;

public class adivinanza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random generador = new Random();
        boolean adivino;
        int num, intento, cant = 1;

        num = generador.nextInt(100) + 1;

        System.out.println("Adivina el número! (entre 1 y 100)");
        intento = sc.nextInt();
        adivino = num == intento;

        while(!adivino) {
            if(intento < num) {
                System.out.println("No :(, el numero es mayor");
            } else {
                System.out.println("No :(, el numero es menor");
            }

            intento = sc.nextInt();
            adivino = num == intento;
            cant++;
        }

        System.out.println("Adivinaste! " + "Cantidad de intentos: " + cant);
    }
}
