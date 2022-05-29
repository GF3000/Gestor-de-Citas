package pruebas;

/**
 * Prueba el funcionamiento de la clase Persona
 * @author Guillermo Franco Gimeno
 * @version 1.0
 */

import gestionCitas.*;
import fecha.Fecha;

public class PersonaTest {

      
    public static Persona[] arrPersona = generadorPersonas(10);



    public static void main(String[] args) {

        //Print arrPersona
        for (int i = 0; i < arrPersona.length; i++) {
            System.out.println(arrPersona[i].toString());
        }
        
    }
    
    /**
     * Genera un array de personas con nombre, fecha de nacimiento, nif y pais
     * @param n de Personas que se quieren generar
     * @return array de personas
     */
    public static Persona[] generadorPersonas(int n) {
        Persona[] arrPersonas = new Persona[n];
        for (int i = 0; i < n; i++) {
            Fecha fecha = Auxi.randomFecha();
            arrPersonas[i] = new Persona("Persona" + i, fecha,Auxi.random(100000,999999 ), "España");
        }

        return arrPersonas;
    }
    
    
}
