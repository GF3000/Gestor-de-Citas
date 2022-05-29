package app;

/**
 * Clase GestorCitasApp
 * Aplicación de consola que te permite gestionar el proceso de vacunación paso a paso
 * @author Guillermo Franco Gimeno
 * @version 1.0
 */

import tads.ArrayQueue;
import java.io.BufferedReader;
import java.io.IOException;
import fecha.*;
import gestionCitas.*;

public class GestorCitasApp {

    static BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    GestorCitas miGestor;

    /**
     * Método que añade una persona a la lista de personas 
     mediante una interfaz de consola
     * @throws IOException Si el usuario introduce una cadena no válida
     */
    private void annadirPaciente() throws IOException {

        System.out.println("Introduce el nombre del paciente");
        String nombre = br.readLine();
        System.out.println("Introduce el día de nacimiento");
        int dia = Integer.parseInt(br.readLine());
        System.out.println("Introduce el mes de nacimiento");
        int mes = Integer.parseInt(br.readLine());
        System.out.println("Introduce el año de nacimiento");
        int anno = Integer.parseInt(br.readLine());
        System.out.println("Introduce el pais del paciente");
        String pais = br.readLine();
        System.out.println("Introduce el DNI del paciente");
        int dni = Integer.parseInt(br.readLine());
        System.out.println("Introduce el numero de Seguridad Social del paciente");
        int numeroSS = Integer.parseInt(br.readLine());
        System.out.println("Introduce si el paciente quiere vacunarse o no (booleano)");
        boolean vacunable = Boolean.parseBoolean(br.readLine());
        System.out.println("Introduce el numero de dosis del paciente");
        int numDosis = Integer.parseInt(br.readLine());

        Fecha fecNac = new Fecha(dia, mes, anno);
        Ciudadano ciudadano = new Ciudadano(nombre, fecNac, dni, pais, numeroSS, vacunable, numDosis, "");

        miGestor.insertar(ciudadano);
        System.out.println("Paciente añadido");
    }

    /**
     * Método que aplica el protocola a la primera persona de la lista
     */
    private void aplicarProtocolo(){
        miGestor.aplicarProtocolo();
    }

    /**
     * Método que muestra por consola a los vacunados
     */
    private void mostrarVacunados(){
        System.out.println("Mostrando listado de vacunados");
        System.out.println(miGestor.getVacunados());
    }

    /**
     * Método que muestra por consola al listado de gente fuera de los hospitales
     */
    private void mostrarGente(){
        System.out.println("Mostrando listado de gente fuera de los hospitales");
        System.out.println(miGestor.getGente());
    }

    /**
     * Método que muestra por consola el listado de niños
     */
    private void mostrarInfantes(){
        System.out.println("Mostrando listado de infantes");
        System.out.println(miGestor.getInfantes());
    }
    /**
     * Método que muestra por consola el listado de personas que no se han quierido vacunar
     */
    private void mostrarRenuentes(){  
        System.out.println("Mostrando listado de renuentes"); 
        System.out.println(miGestor.getRenuentes());
    }

    /**
     * Método que muestra por consola la lista de espera de cada hospital
     */
    private void mostrarListaEspera(){
        System.out.println("Mostrando lista de espera de los hospitales");
        miGestor.printListaEspera();
    }

    /**
     * Método que fuerza la vacunación de las personas en los hospitales
     */
    private void vacunar(){
        System.out.println("Vacunando pacientes");
        miGestor.forzarVacunacion();
    }
    

    public static void main(String[] args) throws IOException {
        Vacunodromo[] vacunodromos;
        vacunodromos = new Vacunodromo[5];
        vacunodromos[0] = new Vacunodromo("12 de Octubre", "Sputnick");
        vacunodromos[1] = new Vacunodromo("Wanda", "AstraZeneka");
        vacunodromos[2] = new Vacunodromo("Wizink", "Janssen");
        vacunodromos[3] = new Vacunodromo("Zendal", "Pfizter");
        vacunodromos[4] = new Vacunodromo("La Paz", "Moderna");

        GestorCitasApp app = new GestorCitasApp();
        
        app.miGestor = new GestorCitas(vacunodromos, new ArrayQueue<>());
        

        boolean fin = false;
        String line;
        String instrucciones = "Listado de opciones\n";
        instrucciones += "1. Añadir paciente\n";
        instrucciones += "2. Mostrar gente en cola\n";
        instrucciones += "3. Aplicar protocolo\n";
        instrucciones += "4. Mostrar listado de vacunados\n";
        instrucciones += "5. Mostrar listado de infantes\n";
        instrucciones += "6. Mostrar listado de renuentes\n";
        instrucciones += "7. Mostrar lista de espera\n";
        instrucciones += "8. Vacunar hospitales\n";
        instrucciones += "9. Salir\n";
        instrucciones += "Introduce el numero de la opcion que deseas ejecutar: ";

        do{
            System.out.println(instrucciones);
            line = br.readLine();
            switch(line){
                case "1":
                    app.annadirPaciente();
                   break;
                case "2":
                    app.mostrarGente();
                    break;
                case "3":
                    app.aplicarProtocolo();
                    break;
                case "4":
                    app.mostrarVacunados();
                    break;
                case "5":  
                    app.mostrarInfantes();
                    break;
                case "6":
                    app.mostrarRenuentes();
                    break;
                case "7":
                    app.mostrarListaEspera();
                    break;
                case "8":
                    app.vacunar();
                    break;
                case "9":
                    fin = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        
        
        }while(!fin);
        
    }
}
