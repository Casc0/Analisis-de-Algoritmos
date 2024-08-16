package Algoritmia;
import java.util.Random;

public class Listas {
    public static void main(String[] args) {
        Random random = new Random();
        int[] listaA = new int[100];
        int[] listaB = new int[60];
        int[] listaC = new int[listaA.length + listaB.length];
        boolean cambio = true;

        for (int i = 0; i < listaA.length; i++) {
            listaA[i] = random.nextInt(1000);
        }
        for (int i = 0; i < listaB.length; i++) {
            listaB[i] = random.nextInt(100);
        }

        //ordenamos listaA (insertion sort)
        for (int i = 1; i < listaA.length; i++) {
            int elem = listaA[i];
            int j = i - 1;
            while(j >= 0 && listaA[j] > elem) {
                listaA[j+1] = listaA[j];
                j--;
            }
            listaA[j+1] = elem;
        }

        //ordenamos listaB (bubble sort mejorado)
        int i = listaB.length-1;
        while(i > 0 && cambio) {
            cambio = false;
            for (int j = 0; j < i; j++) {
                if(listaB[j] > listaB[j+1]) {
                    int aux = listaB[j];
                    listaB[j] = listaB[j+1];
                    listaB[j+1] = aux;
                    cambio = true;
                }
            }
            i--;
        }

        //unificamos ambas listas ordenadas en listaC
        int posA = 0, posB = 0, posC = 0;
        while(posA < listaA.length && posB < listaB.length) {
            if(listaA[posA] < listaB[posB]) {
                listaC[posC] = listaA[posA];
                posA++;
            } else {
                listaC[posC] = listaB[posB];
                posB++;
            }
            posC++;
        }
        while(posA < listaA.length) {
            //solo entro si termine listaB
            listaC[posC] = listaA[posA];
            posA++;
            posC++;
        }
        while(posB < listaB.length) {
            //solo entro si termine listaA
            listaC[posC] = listaB[posB];
            posB++;
            posC++;
        }

        for (int j = 0; j < listaC.length; j++) {
            System.out.print(listaC[j] + " - ");
        }
    }
}
