import java.util.Random;

public class fibonacci {

    public static final int cantidad = 80, numero = 30;
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

    public static long promedioIterativas(){
        long acum = 0, promedio;

        for (int i = 0; i < cantidad; i++){
            acum += unaPruebaIterativa();
        }
        promedio = acum/cantidad;
        return promedio;
    }

    public static long promedioRecursivas(){
        long acum = 0, promedio;

        for (int i = 0; i < cantidad; i++){
            acum += unaPruebaRecursiva();
        }
        promedio = acum/cantidad;
        return promedio;
    }

    public static void imprimirPromedios(){
        long promIt = promedioIterativas();
        long promRec = promedioRecursivas();
        System.out.println("Tiempo promedio de 80 pruebas iterativas: " + promIt*1e-6 + " ms ó " + promIt + " ns");
        System.out.println("Tiempo promedio de 80 pruebas recursivas: " + promRec*1e-6 + " ms ó " + promRec + " ns");
    }
}
