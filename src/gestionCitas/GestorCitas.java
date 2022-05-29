package gestionCitas;

/**
 * Clase gestiónCitas
 * GestorCitas es una cola de IPersona(s) (todas las censadas), más un array de
 * los cinco CVs existentes, más una pila de Ciudadano(s) (los que no aceptan
 * vacunarse) y más una lista de IPersona(s) (las menores de 10 años).
 * @author Guillermo Franco Gimeno
 * @version 2.1
 */


import tads.*;


public class GestorCitas implements IGestorCitas {

    private Vacunodromo[] vacunodromos;
    private IQueue<IPersona> gente;
    private IStack<Ciudadano> renuentes;
    private IList<IPersona> ninnos;
    private IList<IPersona> vacunados;
    private IPersona primeroListaEspera; 
    private int vecesPrimeroListaEspera = 0;

 

    public GestorCitas(Vacunodromo[] vacunodromos, IQueue<IPersona> gente) {
        this.vacunodromos = vacunodromos;
        this.gente = gente;
        this.renuentes = new ArrayStack<>();
        this.ninnos = new ArrayList<>();
        this.vacunados = new ArrayList<>();
    }
        
    @Override
    public IQueue<IPersona> getGente() {
        return gente;
    }

    @Override
    public Vacunodromo getVacunodromo(int i) {
        return vacunodromos[i];
    }

    @Override
    public IStack<Ciudadano> getRenuentes() {
        return renuentes;
    }

    @Override
    public IList<IPersona> getInfantes() {
        return ninnos;
    }

    public IList<IPersona> getVacunados() {
        return vacunados;
    }

    @Override
    public boolean estaVacio() {
        return gente.isEmpty();
    }

    @Override
    public IPersona primero() {
        return gente.peek();
    }

    @Override
    public void insertar(IPersona pp) {
        gente.add(pp);
    }

    @Override
    public void borrar() {
        gente.poll();       
        
    }

    @Override
    public void vacunar() {
        if (vacunodromosLlenos(vacunodromos)){
            //Si todos los vacunódormos están llenos vacuno a los pacientes
            forzarVacunacion();
        }

    }

    @Override
    public void aplicarProtocolo() {

        String vacuna;
        IPersona miPersona = gente.peek();
        int edadMiPersona = miPersona.getFechaNacimiento().edad();
        if (primeroListaEspera == null || (primeroListaEspera.equals(miPersona) && vecesPrimeroListaEspera <1)){
             //No hemos detectado una vuelta completa todavía

            //Empieza a contar la primera vuelta
            vecesPrimeroListaEspera ++;
            
            if (edadMiPersona < 10){
                //Es un niño
                ninnos.add(0, miPersona);
                gente.poll();
            }else{
                if (miPersona instanceof Ciudadano){
                    //miPersona es un ciudadano
                    Ciudadano miCiudadano = (Ciudadano)miPersona;

                    if (!miCiudadano.getAceptacion()){
                        //miCiudadano no quiere vacunarse
                        renuentes.push(miCiudadano);
                        gente.poll();
                    }else{
                        if (miCiudadano.getNumDosis() < 2){
                            //miCiudadano si quiere vacunarse y tiene menos de dos dosis, le adjudico una vacuna en función de su edad
                            if (edadMiPersona < 50) {
                                vacuna = "Sputnick";
                            }else if (edadMiPersona < 60){
                                vacuna = "AstraZeneka";
                            }else if (edadMiPersona < 70){
                                vacuna = "Janssen";
                            }else if (edadMiPersona < 80){
                                vacuna = "Pfizter";
                            }else{
                                vacuna = "Moderna";
                            }
                            //Meto a mi ciudadano en su vacundromo correspondiente
                            meterAVacunodromo(miCiudadano, vacuna);
                            
                        }else{
                            //El ciudadano ya tiene las 2 dosis
                            gente.poll();
                        }
                    }
                    
                }else{
                    //No es un ciudadano
                    gente.poll();
                }
            
            }
        }else{
            //Ha dado una vuelta entera y ha vuelto al estado inicial
            forzarVacunacion();
            primeroListaEspera = gente.peek();
            vecesPrimeroListaEspera = 0;
        }
    }

    @Override
    public void gestionar() {
        do{
            while (!gente.isEmpty()){
                //Mientras quede alguien en la cola general
                aplicarProtocolo();
                vacunar(); 
            }
            //Ya no queda nadie en la cola general, vacunamos a la lista de espera de cada CV
            forzarVacunacion();

        }while(!gente.isEmpty());//Comprobamos que efectivamente la cola general está vacía, si no, repetimos el proceso
     
    }

    /**
     * Imprime es la lista de espera de los vacunódromos
     */
    public void printListaEspera() {
        for (Vacunodromo vacunodromo : vacunodromos) {
            if (!vacunodromo.isEmpty())System.out.println(vacunodromo.toString());
        }
    }

    
    

    /**
     * Método que mete al ciudadano al vacunodromo que le corresponde con esa vacuna
     * @param miCiudadano Ciudadano al que meter al CV
     * @param vacuna Vacuna que se debe poner al ciudadano
     */
    private void meterAVacunodromo(Ciudadano miCiudadano, String vacuna){
        boolean vacunado = false;
        for (int i = 0; i< vacunodromos.length && !vacunado; i++) {
            //Buscamos qué vacunódromo le corresponde miCiudadano en función de vacuna
            if (vacunodromos[i].getVacuna().equals(vacuna)) {
                if (!vacunodromos[i].isFull()){
                    //Metemos al ciudadano en su vacunódromo si hay hueco
                    vacunodromos[i].add(miCiudadano);
                    gente.poll();
                    //Me quedo con la siguiente persona para saber cuándo da una vuelta entera
                    try {
                        primeroListaEspera = gente.peek();
                    } catch (Exception e) {
                        primeroListaEspera = null;
                    }
                    vecesPrimeroListaEspera = 0;
                }else{
                    //No había hueco en su vacunódromo así que le devolvemos a su fila en última posición
                    gente.poll();
                    gente.add(miCiudadano);
                }
                vacunado = true;
            }
        }
    } 
    



     /**
     * Método que comprueba si los vacunodromos están llenos
     * @param vacunodromos Array de vacunodromos que comprobara
     * @return Si los vacundromos están llenos
     */

     private boolean vacunodromosLlenos(Vacunodromo[] vacunodromos){
        boolean vacunodromosLlenos = true;
        for (Vacunodromo vacunodromo : vacunodromos) {
            //Iteramos por todos los vacunódrmos en busca de uno que no esté lleno
            if (!vacunodromo.isFull()){
                vacunodromosLlenos = false;
            }
        }
        return vacunodromosLlenos;
     }

     /**
      * Vacuno con una dosis a todos los ciudadanos que estén en un vacunódromo independientemente de si están llenos o no
      */
     private void forzarVacunacion(){
         for(Vacunodromo vacunodromo : vacunodromos){
             //Itero por todos los vacunodromos
             while (!vacunodromo.isEmpty()){
                //Vacuno a los ciudadanos en el vacunodromo hasta que se vacíe
                vacunodromo.peek().anotarDosis();
                //Anoto en el ciudadno qué vacuna le hemos suministrado
                vacunodromo.peek().setVacuna(vacunodromo.getVacuna());
                if (vacunodromo.peek().getNumDosis() < 2){
                    //Si tiene menos de dos dosis le vuelvo a meter en la lista general
                    gente.add(vacunodromo.peek());
                }else{
                    //El paciente ya tiene las dos dosis, le metemos en la lista de vacunados
                    vacunados.add(0,vacunodromo.peek());
                }
                //Sacamos al ciudadano del vacunódromo
                vacunodromo.poll();
             }
         }

     }
}
