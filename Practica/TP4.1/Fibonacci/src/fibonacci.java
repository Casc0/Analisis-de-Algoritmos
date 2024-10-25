import java.util.Arrays;
import java.util.Random;

public class fibonacci {

    public static final int cantidad = 10, numero = 30;
    public static void main(String[] args) {
        imprimirPromedios();
    }

    public static long iterativo(int n) {
        long resultado;
        if(n <= 1) {
            resultado = n;
        }else{
            long nAnterior = 0, nAnteriorAnterior, nActual = 1;
            for (int i = 1; i < n; i++) {
                nAnteriorAnterior = nAnterior;
                nAnterior = nActual;
                nActual = nAnteriorAnterior + nAnterior;
            }
            resultado = nActual;
        }
        return resultado;
    }

    public static long recursivo(int n){
        long resultado = 0;
        if (n == 1) {
            resultado = 1;
        }else if (n > 1){
            resultado = recursivo(n-1) + recursivo(n-2);
        }

        return resultado;
    }

    public static long unaPruebaIterativa(){
        long tiempoInicio, tiempoTotal, tiempoFin;

        tiempoInicio = System.nanoTime();
        long x = iterativo(numero);
        tiempoFin = System.nanoTime();

        tiempoTotal = tiempoFin - tiempoInicio;

        return tiempoTotal;
    }

    public static long unaPruebaRecursiva() {
        long tiempoInicio, tiempoTotal, tiempoFin;

        tiempoInicio = System.nanoTime();
        long x = recursivo(numero);
        tiempoFin = System.nanoTime();

        tiempoTotal = tiempoFin - tiempoInicio;

        return tiempoTotal;
    }

    public static long promedioIterativas(long[] arr){
        long acum = 0, promedio;

        for (int i = 0; i < cantidad; i++){
            long unaPrueba = unaPruebaIterativa();
            acum += unaPrueba;
            arr[i] = unaPrueba;
        }
        promedio = acum/cantidad;
        return promedio;
    }

    public static long promedioRecursivas(long[] arr){
        long acum = 0, promedio;

        for (int i = 0; i < cantidad; i++){
            long unaPrueba = unaPruebaRecursiva();
            acum += unaPrueba;
            arr[i] = unaPrueba;
        }
        promedio = acum/cantidad;
        return promedio;
    }

    public static void imprimirPromedios(){
        long[] arr1 = new long[cantidad];
        long[] arr2 = new long[cantidad];
        long promIt = promedioIterativas(arr1);
        long promRec = promedioRecursivas(arr2);

        System.out.println("Iterativo:");
        //imprimirArreglo(arr1);
        System.out.println("Tiempo maximo: " + Arrays.stream(arr1).max());
        System.out.println("Tiempo maximo: " + Arrays.stream(arr1).min());
        System.out.println("Tiempo promedio de " + cantidad + " pruebas iterativas: " + promIt*1e-6 + " ms ó " + promIt + " ns");

        System.out.println("Recursivo:");
        //imprimirArreglo(arr2);
        System.out.println("Tiempo maximo: " + Arrays.stream(arr2).max());
        System.out.println("Tiempo maximo: " + Arrays.stream(arr2).min());
        System.out.println("Tiempo promedio de " + cantidad + " pruebas recursivas: " + promRec*1e-6 + " ms ó " + promRec + " ns");
    }

    public static void imprimirArreglo(long[] arr){
        for (int i = 0; i < cantidad; i++){
            System.out.println(arr[i]);
        }
    }
}
