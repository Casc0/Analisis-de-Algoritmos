import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class algoritmos_logn {

    //poner la ruta del archivo donde estaran los numeros del arreglo
    static final String  archivo = "/home/casc0/Mis-Cosas/Fai/Estudiante/Carreras/Tercer Año/Analisis-de-Algoritmos/Practica/TP2/TP2/src/Randoms";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //System.out.println("Ingresar tamaño del arreglo");
        //int n = sc.nextInt();
        int n = 10000;

        int[] arr = new int[n];



        //ejecutar la siguiente linea para generar n randoms en el archivo. Una vez generado comentarla, para no repetir el proceso
        //numerosRandoms();
        cargarArreglo(arr);
        mergeSort(arr, n);


        System.out.println( "Tardo " + busqueda(arr) +" nanosegundo en recorrer el arreglo con " + n + " elementos.");
    }

    //calcula el tiempo que tarda en buscar un elemento.
    public static long busqueda(int[] arr) {
        Scanner sc = new Scanner(System.in);
        boolean encontrado;
        long tiempoInicio, tiempoFin, tiempoTotal;

        System.out.println("ingresar elemento a buscar:");
        int x = sc.nextInt();



        tiempoInicio = System.nanoTime();
        encontrado = busquedaBinaria(arr, x);
        tiempoFin = System.nanoTime();

        tiempoTotal = tiempoFin - tiempoInicio;

        if (encontrado) {
            System.out.println("Encontro el elemento");
        }

        return tiempoTotal;
    }

    //algoritmo de busqueda binaria de un entero en un arreglo
    public static boolean busquedaBinaria(int[] arr, int x) {

        int i = 0, fin = arr.length - 1;
        boolean encontro = false;

        while(i <= fin && !encontro) {
            int medio = (fin + i) / 2;
            if (arr[medio] == x) {
                encontro = true;
            }else{
                if(x < arr[medio]){
                    fin = medio - 1;

                }else {
                    i = medio + 1;
                }
            }
        }
        return encontro;
    }

    //carga numeros randoms al arreglo
    public static void cargarArreglo(int[] arr) {
        int largo = arr.length;

        try{
            BufferedReader buffer = new BufferedReader(new FileReader(archivo));

            for(int i = 0; i < largo; i++){
                arr[i] = Integer.parseInt(buffer.readLine());
            }


            buffer.close();

        } catch (FileNotFoundException ex) {
            System.err.println("No existe el archivo que se quiere leer");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo");
        }
    }

    //para ordenar el arreglo. Fuente: https://www.baeldung.com/java-merge-sort
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    //para generar un archivo con enteros entre el 0 y el 100000.
    public static void numerosRandoms() {
        Random generador = new Random();
        int num;

        try {
            BufferedWriter buff = new BufferedWriter(new FileWriter(archivo));

            for (int i = 0; i < 12000; i++) {
                //genera un random  entre 0 y 200, y al restarle 100, termina quedando en el rango deseado
                num = generador.nextInt(0, 100000);
                buff.write(num + "\n");
                System.out.println(num);
            }

            buff.close();
        } catch (FileNotFoundException ex) {
            System.err.println("No existe el archivo que se quiere leer");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo");
        }
    }


}
