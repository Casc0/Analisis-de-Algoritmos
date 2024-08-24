import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class algoritmos_logn {

    static final String  archivo = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresar tamaño del arreglo");
        int n = sc.nextInt();
        int[] arr = new int[n];


        //ejecutar la siguiente linea para generar n randoms en el archivo. Una vez generado comentarla, para no repetir el proceso
        numerosRandoms();
        cargarArreglo(arr);

        System.out.println("ingresar elemento a buscar:");
        int el = sc.nextInt();
        busqueda(el, arr);
    }

    public static boolean busqueda(int el , int[] arr) {
        return true;

    }

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

    public static void numerosRandoms() {
        Random generador = new Random();
        double num;

        try {
            BufferedWriter buff = new BufferedWriter(new FileWriter(archivo));

            for (int i = 0; i < 12000; i++) {
                //genera un random  entre 0 y 200, y al restarle 100, termina quedando en el rango deseado
                num = generador.nextInt();
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
