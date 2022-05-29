package pruebas;

/**
 * Clase con métodos útil para las pruebas
 * Contiene métodos que que generan objetos o variables aleatorios
 * @author Guillermo Franco Gimeno
 * @version 1.0
 */

import java.util.Random;
import fecha.*;
public class Auxi {

    /**
     * Genera un entero aleatorio entre min y max ambos inclusive
     * @param n min
     * @param m max
     * @return entero aleatorio 
     */
    public static int random(int n, int m) {
        Random r = new Random();
        return r.nextInt(m - n + 1) + n;
    }

    /**
     * Genera un booleano aleatorio
     * @return true o false aleatorio
     */
    public static boolean randomBoolean() {
        Random r = new Random();
        return r.nextBoolean();
    }

    /**
     * Genera una fecha aleatoria
     * @return objeto Fecha aleatorio
     */
    public static Fecha randomFecha() {
        int dia;
        int mes;
        int anno;
        do {
        dia = random(1, 31);
        mes = random(1, 12);
        anno = random(1920, 2020);
        }while (false); //Falta comprobar que la fecha es correcta
        //}while (!Fecha.esCorrecta(dia, mes, anno));
        return new Fecha(dia, mes, anno);
    }
    
}
