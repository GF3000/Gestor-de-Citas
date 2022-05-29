package gestionCitas;

/**
 * Clase Ciudadano
 * Ciudadano es una IPersona que además se define por un número de afiliación al Sistema de Salud
 * , por la confirmación de que ha aceptado vacunarse y por el número de dosis recibidas
 * @author Guillermo Franco Gimeno
 * @version 1.1
 */
import fecha.IFecha;

public class Ciudadano extends Persona{

    private int nSS;
    private boolean aceptacion;
    private int numDosis;
    private String tipoVacuna;

    public Ciudadano(String nombre, IFecha fechaNac, int dni, String pais, int numeroSS, boolean vacunable, int numDosis, String tipoVacuna) {
        super(nombre, fechaNac, dni, pais);
        this.nSS = numeroSS;
        this.aceptacion = vacunable;
        this.numDosis = numDosis;
        this.tipoVacuna = tipoVacuna;
    }

    public Ciudadano (Persona personas, int numeroSS, boolean vacunable, int numDosis, String tipoVacuna) {
        super(personas.getNombre(), personas.getFechaNacimiento(), personas.getDNI(), personas.getPais());
        this.nSS = numeroSS;
        this.aceptacion = vacunable;
        this.numDosis = numDosis;
        this.tipoVacuna = tipoVacuna;
    }
    

    public int getNSS() {
        return nSS;
    }
    public boolean getAceptacion() {
        return aceptacion;
    }
    public int getNumDosis() {
        return numDosis;
    }

    public void setNumDosis(int numDosis) {
        this.numDosis = numDosis;
    }

    public String getVacuna() {
        return tipoVacuna;
    }

    public void setVacuna(String tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }

    public String toString(){
        return super.toString() + " " + nSS + " " + aceptacion + " " + numDosis + " " + tipoVacuna;
    }
    
    @Override
    public boolean equals(Object pp){
        if(pp instanceof Ciudadano){
            Ciudadano p = (Ciudadano) pp;
            return super.equals(pp) && this.nSS == p.getNSS() && this.aceptacion == p.getAceptacion() && this.numDosis == p.getNumDosis() && this.tipoVacuna.equals(p.getVacuna());
        } else return false;
    }

    public void anotarDosis(){
        this.numDosis++;
    }

    

}
    
