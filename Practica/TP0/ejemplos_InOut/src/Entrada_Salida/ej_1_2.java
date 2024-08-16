package Entrada_Salida;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ej_1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Ingresa la ruta del archivo de entrada
        String entrada = "src/ej1/entrada.txt";
        String salida;
        String linea = null;

        System.out.println("Ejercicio 1 o 2?");
        int ej = sc.nextInt();

        if(ej==1) {
            //Ingresa la ruta del archivo de entrada del ejercicio 1
            salida = "src/ej1/sinEspacios.txt";
        }else{
            //Ingresa la ruta del archivo de entrada del ejericio 2
            salida = "src/ej1/lineasImpares.txt";

        }
        try {
            FileReader lector = new FileReader(entrada);
            FileWriter escritor = new FileWriter(salida);

            BufferedReader bufferLector = new BufferedReader(lector);
            BufferedWriter bufferEscritor = new BufferedWriter(escritor);

            //elije que hacer segun lo seleccionado previamente
            if(ej==1){
                while((linea = bufferLector.readLine()) != null){
                    bufferEscritor.write(sacarEspacios(linea+ "\n"));
                }
            }
            else{
                int nroLinea = 0;
                while((linea = bufferLector.readLine()) != null){
                    //solo elegi las lineas cuyo modulo 2 sea distinot de 0, lo que significa que es impar
                    if(nroLinea % 2 != 0) bufferEscritor.write(linea + "\n");
                    nroLinea++;

                }
            }

            bufferLector.close();;
            bufferEscritor.close();
        }
        catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo que queres leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }

    }
    public static String sacarEspacios(String linea){
        int longitud = linea.length();
        String nuevaLinea = "";
        for(int i = 0; i < longitud; i++ ){
            //si el caracter es un espacio, lo saltea
            if(linea.charAt(i) != ' ') {
                nuevaLinea += linea.charAt(i) ;
            }
        }
        return nuevaLinea;
    }
}
