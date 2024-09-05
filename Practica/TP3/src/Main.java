import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(pruebaEmpiricaComunes());
    }


    public static List<Integer> encontrarComunes(int[] arr1, int[] arr2, int[] numComp) {
        List<Integer> listaComunes = new ArrayList<>();
        int puntero1 = 0, puntero2 = 0, largo1, largo2;
        largo1 = arr1.length;
        largo2 = arr2.length;

        // Mientras ninguno de los punteros haya alcanzado el final de los arreglos
        while (puntero1 < largo1 && puntero2 < largo2) {
            numComp[0]++;
            if (arr1[puntero1] == arr2[puntero2]) {
                // Si los elementos son iguales, añadir a la lista de comunes
                listaComunes.add(arr1[puntero1]);
                puntero1++;
                puntero2++;
            } else if (arr1[puntero1] < arr2[puntero2]) {
                // Si el elemento de arr1 es menor, avanzar el puntero de arr1
                puntero1++;
            } else {
                // Si el elemento de arr2 es menor, avanzar el puntero de arr2
                puntero2++;
            }
        }

        return listaComunes;
    }

    public static double pruebaEmpiricaComunes(){
        Scanner sc = new Scanner(System.in);
        double promedio = 0;
        int[] comprobaciones = {0};
        System.out.println("Cuantas iteraciones tendra la prueba?");
        int pruebas = sc.nextInt();


        for(int i = 0; i < pruebas; i++){
            //uso esta variable para almacenar la cantidad de comprobaciones antes de buscar comunes
            int comprActual = comprobaciones[0];
            System.out.println("Comparación n°" + (i+1) + " con comunes: " + encontrarComunes(generarArregloOrdenado(), generarArregloOrdenado(), comprobaciones) + "y " + (comprobaciones[0]-comprActual) + " comprobaciones realizadas");
        }
        promedio = (double) comprobaciones[0] /pruebas;

        return promedio;
    }

    public static int[] generarArregloOrdenado() {
        Random generador = new Random();

        //generador para el tamaño del arreglo
        int largo = generador.nextInt(50)+1;
        int[] arr = new int[largo];

        //generador de cada elemento del arreglo
        for(int i = 0; i < largo; i++){
            arr[i] = generador.nextInt(50)+1;
        }

        return arr;
    }
}