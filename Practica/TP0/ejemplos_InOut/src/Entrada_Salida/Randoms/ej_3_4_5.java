package Entrada_Salida.Randoms;
import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class ej_3_4_5 {
    static final String archivoSalida = "salida.txt";

    public static void numerosRandoms() {
        Random generador = new Random();
        double num;

        try {
            BufferedWriter buff = new BufferedWriter(new FileWriter(archivoSalida));

            for (int i = 0; i < 100 ; i++){
                //genera un random  entre 0 y 200, y al restarle 100, termina quedando en el rango deseado
                num = generador.nextDouble(200) - 100;
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

    public static void alfanumericos() {
        Random generador = new Random();
        int cantLetras = 'z' - 'a' + 1, num;
        char carac;

        try {
            BufferedWriter buff = new BufferedWriter(new FileWriter(archivoSalida));

            for (int i = 0; i < 10 ; i++){
                num = generador.nextInt(cantLetras*2+10);
                if(num < cantLetras) {
                    carac = (char)((int)'a' + num);
                } else if(num < cantLetras*2) {
                    carac = (char)((int)'A' + num - cantLetras);
                } else {
                    carac = (char)((int)'0' + num - cantLetras*2);
                }

                buff.write(Character.toString(carac) + " - ");
                System.out.print(String.valueOf(carac) + " - ");
                //Character.toString(carac) y String.valueOf(carac)
                //transforman un caracter a string, pongo las dos opciones porque quiero
            }

            buff.close();
        } catch (FileNotFoundException ex) {
            System.err.println("No existe el archivo que se quiere leer");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo");
        }
    }

    public static void numerosSinRepetir() {
        Random generador = new Random();
        HashMap numeros = new HashMap();
        int num, cant = 0;

        try {
            BufferedWriter buff = new BufferedWriter(new FileWriter(archivoSalida));

            while(cant < 100) {
                num = generador.nextInt(1000);

                if(numeros.put(num, num) == null) {
                    //si nos devuelve null, es que el numero no estaba en el hashmap
                    buff.write(num + "\n");
                    System.out.println(num);
                    cant++;
                }
            }

            buff.close();
        } catch (FileNotFoundException ex) {
            System.err.println("No existe el archivo que se quiere leer");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo");
        }
    }

    public static void main(String[] args){
        int ejercicio;
        Scanner sc = new Scanner(System.in);

        System.out.println("Queres ejecutar el ejercicio 3, 4 o 5?");
        ejercicio = sc.nextInt();

        if(ejercicio == 1) {
            numerosRandoms();
        } else if (ejercicio == 2) {
            alfanumericos();
        }else if (ejercicio == 3) {
            numerosSinRepetir();
        }else System.out.println("Error");


    }


}
