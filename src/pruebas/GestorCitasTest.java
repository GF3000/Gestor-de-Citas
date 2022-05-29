package pruebas;

/**
 * Tester del gestor de citas
 * Gestiona las citas sobra una pobalción de n personas
 * @author Guillermo Franco Gimeno
 * @version 1.3
 */

import fecha.*;
import tads.IQueue;
import tads.LinkedQueue;
import gestionCitas.*;

public class GestorCitasTest {
    public static IQueue <IPersona> gente;
    public static Vacunodromo[] vacunodromos;


    public static void main(String[] args) {

        
        vacunodromos = new Vacunodromo[5];
        vacunodromos[0] = new Vacunodromo("12 de Octubre", "Sputnick");
        vacunodromos[1] = new Vacunodromo("Wanda", "AstraZeneka");
        vacunodromos[2] = new Vacunodromo("Wizink", "Janssen");
        vacunodromos[3] = new Vacunodromo("Zendal", "Pfizter");
        vacunodromos[4] = new Vacunodromo("La Paz", "Moderna");

        gente = new LinkedQueue<IPersona>();
        
        //Selecciona el tamaño de la muestra de ciudadanos
        for (IPersona per : CiudadanoTest.generadorCiudadanos(PersonaTest.generadorPersonas(100))) {
            gente.add(per);
        } 
        
        // Ciudadano c1 = new Ciudadano("Pepe", new Fecha(1, 1, 1980), 6763, "España",1234, true, 0, "tipoVacuna");    
        // Ciudadano c2 = new Ciudadano("Juan", new Fecha(1, 1, 1990), 6763, "España",1234, true, 0, "tipoVacuna");    
        // Ciudadano c3 = new Ciudadano("Jaime", new Fecha(1, 1, 2000), 6763, "España",1234, true, 0, "tipoVacuna");    
        // Ciudadano c4 = new Ciudadano("Javi", new Fecha(1, 1, 1980), 6763, "España",1234, true, 0, "tipoVacuna");    
        // Ciudadano c5 = new Ciudadano("Santi", new Fecha(1, 1, 1940), 6763, "España",1234, true, 0, "tipoVacuna");    
        // Ciudadano c6 = new Ciudadano("Paco", new Fecha(1, 1, 1990), 6763, "España",1234, true, 0, "tipoVacuna");    
        // Ciudadano c7 = new Ciudadano("Miguel", new Fecha(1, 1, 1930), 6763, "España",1234, true, 0, "tipoVacuna");    
        // Ciudadano c8 = new Ciudadano("Fer", new Fecha(1, 1, 1930), 6763, "España",1234, true, 0, "tipoVacuna");    

        // gente.add(c1);
        // gente.add(c2);
        // gente.add(c3);
        // gente.add(c4);
        // gente.add(c5);
        // gente.add(c6);
        // gente.add(c7);
        // gente.add(c8);

            
        
        IGestorCitas miGestorCitas= new GestorCitas(vacunodromos, gente);
        miGestorCitas.gestionar();
        System.out.println("\nVacunados: " + ((GestorCitas)miGestorCitas).getVacunados());
        System.out.println("\nNiños: " + miGestorCitas.getInfantes());
        System.out.println("\nReunentes: " + miGestorCitas.getRenuentes());

        
    }
    

    
    
}
