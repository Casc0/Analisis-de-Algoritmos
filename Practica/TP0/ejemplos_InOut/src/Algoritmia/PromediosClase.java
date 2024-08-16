package Algoritmia;
import java.util.Random;

public class PromediosClase {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] notas = new int[4][5];
        double[] mediaAlumnos = new double[4];
        double[] mediaMateria = new double[5];
        double mediaTotal = 0;

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[0].length; j++) {
                notas[i][j] = random.nextInt(11);
            }
        }

        System.out.println("Media de notas de los alumnos");
        for (int i = 0; i < notas.length; i++) {
            mediaAlumnos[i] = 0;
            for (int j = 0; j < notas[0].length; j++) {
                mediaAlumnos[i] += notas[i][j];
            }
            mediaAlumnos[i] /= notas[0].length;
            System.out.println(mediaAlumnos[i]);
        }

        System.out.println("Media de notas de las materias");
        for (int j = 0; j < notas[0].length; j++) {
            mediaMateria[j] = 0;
            for (int i = 0; i < notas.length; i++) {
                mediaMateria[j] += notas[i][j];
            }
            mediaMateria[j] /= notas.length;
            System.out.println(mediaMateria[j]);
        }

        System.out.println("Media total");
        for (int i = 0; i < mediaAlumnos.length; i++) {
            mediaTotal += mediaAlumnos[i];
        }
        mediaTotal /= mediaAlumnos.length;
        System.out.println(mediaTotal);
        //podemos clacular la media realizando lo mismo, pero con las materias

        System.out.println("Ordenamos medias de alumnos");
        //bubble sort
        for (int i = mediaAlumnos.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(mediaAlumnos[j] > mediaAlumnos[j+1]) {
                    double aux = mediaAlumnos[j];
                    mediaAlumnos[j] = mediaAlumnos[j+1];
                    mediaAlumnos[j+1] = aux;
                }
            }
        }
        int min;
        //selection sort
        for (int i = 0; i < mediaAlumnos.length-1; i++) {
            min = i;
            for (int j = i+1; j < mediaAlumnos.length; j++) {
                if(mediaAlumnos[j] < mediaAlumnos[min]) {
                    min = j;
                }
                double aux = mediaAlumnos[i];
                mediaAlumnos[i] = mediaAlumnos[min];
                mediaAlumnos[min] = aux;
            }
        }
        for (int i = 0; i < mediaAlumnos.length; i++) {
            System.out.println(mediaAlumnos[i]);
        }
    }
}
