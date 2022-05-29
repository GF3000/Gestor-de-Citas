package pruebas;
/**
 * Prueba el funcionamiento de la clase Ciudadano
 * @author Guillermo Franco Gimeno
 * @version 1.0
 */
import gestionCitas.*;

public class CiudadanoTest {

    public static Ciudadano[] arrCiudadanos = generadorCiudadanos(PersonaTest.arrPersona);
    
    //Make new Ciudadano with different name and birthdate
    public static void main(String[] args) {

        for (int i = 0; i < arrCiudadanos.length; i++) {
            System.out.println(arrCiudadanos[i].toString());
        }
        

    }

    /**
     * Genera un array de Ciudadanos con los datos de los objetos Persona añadiendo 
     * una nSS aleatorio y un consentimiento aleatorio.
     * @param arrPersonas array de objetos Persona
     * @return array de objetos Ciudadano
     */
    public static Ciudadano[] generadorCiudadanos(Persona[] arrPersonas){
        Ciudadano[] arrCiudadanos = new Ciudadano[arrPersonas.length];
        for(int i = 0; i < arrPersonas.length; i++){
            arrCiudadanos[i] = new Ciudadano(arrPersonas[i], Auxi.random(100000,999999), Auxi.randomBoolean(), 0, "");
        }

        return arrCiudadanos;


    }
    
}
