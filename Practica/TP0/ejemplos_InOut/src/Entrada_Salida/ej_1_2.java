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
        String entrada = "src/ej1/entrada.txt";
        String salida = "";
        String linea = null;

        System.out.println("Ejercicio 1 o 2?");
        int ej = 1;

        if(ej==1) {
            salida = "src/ej1/sinEspacios.txt";
        }else{
            salida = "src/ej1/lineasImpares.txt";

        }
        try {
            FileReader lector = new FileReader(entrada);
            FileWriter escritor = new FileWriter(salida);

            BufferedReader bufferLector = new BufferedReader(lector);
            BufferedWriter bufferEscritor = new BufferedWriter(escritor);

            //elegir que hacer
            if(ej==1){
                while((linea = bufferLector.readLine()) != null){
                    bufferEscritor.write(sacarEspacios(linea));
                }
            }
            else{
                int nroLinea = 0;
                while((linea = bufferLector.readLine()) != null){
                    if(nroLinea % 2 != 0) bufferEscritor.write(linea);
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
            if(linea.charAt(i) != ' ') {
                nuevaLinea += linea.charAt(i);
            }
        }
        return nuevaLinea;
    }
}
