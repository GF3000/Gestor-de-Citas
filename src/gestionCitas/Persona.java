package gestionCitas;

/**
 * Clase Persona
 * Representa a cualquier humano definido por su nombre, fecha de nacimiento, su país de origen y su número de identificación
 * @author Guillermo Franco Gimeno
 * @version 1.0
 */


import fecha.IFecha;

public class Persona implements IPersona {
    private String nombre;
    private IFecha fechaNac;
    private int dni;
    private String pais;

    public Persona(String nombre, IFecha fechaNac, int dni, String pais) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.dni = dni;
        this.pais = pais;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public IFecha getFechaNacimiento() {
        return fechaNac;
    }

    @Override
    public String getPais() {
        return pais;
    }

    @Override
    public int getDNI() {
        return dni;
    }

    @Override
    public String toString(){
        return nombre + " " + fechaNac + " " + dni + " " + pais;
    }
    @Override
    public boolean equals(Object pp){
        if(pp instanceof Persona){
            Persona p = (Persona) pp;
            return this.nombre.equals(p.getNombre()) && this.fechaNac.equals(p.getFechaNacimiento()) && this.dni == p.getDNI() && this.pais.equals(p.getPais());
        } else return false;
    }
    
}
