package gestionCitas;

/**
 * Clase vacunodromo
 * Vacunódromo es una cola acotada de Ciudadanos que además dispone de nombre y tipo de vacuna
 * @author Guillermo Franco Gimeno
 * @version 1.0
 */

import tads.*;

public class Vacunodromo extends BoundedQueue<Ciudadano> {
    private String centroV;
    private String vacuna;

    public Vacunodromo(String centroV, String vacuna) {
        super(3);
        this.centroV = centroV;
        this.vacuna = vacuna;
    }   

    @Override
    public String toString() {
        return "Vacunódromo " + centroV + ": Vacuna " + vacuna + ",  En lista = " + super.toString();
    }
     public String getCentroV() {
        return centroV;
     }
     public String getVacuna() {
        return vacuna;
     }

     @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vacunodromo) {
            Vacunodromo v = (Vacunodromo) obj;
            return this.centroV.equals(v.getCentroV()) && this.vacuna.equals(v.getVacuna());
        } else {
            return false;
        }
    }

    
}
