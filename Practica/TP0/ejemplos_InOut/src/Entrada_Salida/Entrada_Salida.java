package Entrada_Salida;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Entrada_Salida {

    static final String archivoSalida = "salida.txt";
    static final String archivoEntrada = "src/ej1/entrada.txt";

    public static void sinEspacios() {
        try {
            String salida = " src/ej1/sinEspacios.txt";
            String linea;
            FileReader lector = new FileReader(archivoEntrada);
            FileWriter escritor = new FileWriter(salida);

            BufferedReader bufferLector = new BufferedReader(lector);
            BufferedWriter bufferEscritor = new BufferedWriter(escritor);


            while ((linea = bufferLector.readLine()) != null) {
                linea = linea.replace(" ", "");
                System.out.print(linea);
                bufferEscritor.write(linea);
            }

            bufferLector.close();

            bufferEscritor.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo que queres leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");

        }
    }

    public static void impares() {
        try {

            int cont = 0;
            String salida = " src/ej1/lineasImpares.txt";
            String linea;
            
            FileReader lector = new FileReader(archivoEntrada);
            FileWriter escritor = new FileWriter(salida);

            BufferedReader bufferLector = new BufferedReader(lector);
            BufferedWriter bufferEscritor = new BufferedWriter(escritor);

            while ((linea = bufferLector.readLine()) != null) {
                //solo elegi las lineas cuyo modulo 2 sea distinot de 0, lo que significa que es impar
                if (cont % 2 != 0) {
                    bufferEscritor.write(linea + "\n");
                }
                cont++;

            }


            bufferLector.close();
            bufferEscritor.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo que queres leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");

        }
    }

    public static void numerosRandoms() {
        Random generador = new Random();
        double num;

        try {
            BufferedWriter buff = new BufferedWriter(new FileWriter(archivoSalida));

            for (int i = 0; i < 100; i++) {
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

            for (int i = 0; i < 10; i++) {
                num = generador.nextInt(cantLetras * 2 + 10);
                if (num < cantLetras) {
                    carac = (char) ((int) 'a' + num);
                } else if (num < cantLetras * 2) {
                    carac = (char) ((int) 'A' + num - cantLetras);
                } else {
                    carac = (char) ((int) '0' + num - cantLetras * 2);
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

            while (cant < 100) {
                num = generador.nextInt(1000);

                if (numeros.put(num, num) == null) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Queres ejecutar el ejercicio 1, 2, 3, 4 o 5?");
        int ejercicio = sc.nextInt();

        if (ejercicio == 1) {
            sinEspacios();

        } else if (ejercicio == 2) {
            impares();

        } else if (ejercicio == 3) {
            numerosRandoms();

        } else if (ejercicio == 4) {
            alfanumericos();

        } else if (ejercicio == 5) {
            numerosSinRepetir();

        } else System.out.println("Error");

    }
}
