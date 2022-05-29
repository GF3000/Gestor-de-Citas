package fecha;
import java.util.*;

public class Fecha implements IFecha
{
  private int dia;
  private int mes;
  private int anno;
  
  public Fecha (int dia, int mes, int anno) {
    this.dia = dia;
    this.mes = mes;
    this.anno = anno;
  }
  public int dia () {
    return dia;
  }
  public int mes () {
    return mes;
  }
  public int anno () {
    return anno;
  }
  public String toString () {
    return dia + "/" + mes +"/" + anno;
  }
  private static int mes (String name) 
  {
    String[] months = 
      {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
       "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} ;
    boolean encontrado = false;
    int i = 0;
    while (i <= months.length && !encontrado)
    { 
      if (months[i].equals(name))
        encontrado = true;
      else
        i = i + 1;
    }
    return i+1;
  }
  /**
   * hoy () : Fecha
   * POST: Devuelve la Fecha de hoy.
   */ 
  private static Fecha hoy () {
    Date ahora = new Date();
    String [] partes = ahora.toString().split(" ");
    int diaHoy = Integer.parseInt(partes[2]);
    String nombreMesHoy = partes[1];
    int mesHoy = mes(nombreMesHoy);
    int annoHoy = Integer.parseInt(partes[5]);
    return new Fecha(diaHoy, mesHoy, annoHoy);
  }
  private boolean esMenorOIgual (int dia1, int mes1, int dia2, int mes2) 
  {
    return
      (mes1 < mes2)  ||
      (mes1 == mes2 && dia1 <= dia2);
  }
  public int edad () 
  {
    if (esMenorOIgual(dia(), mes(), hoy().dia(), hoy().mes()))
      return hoy().anno() - anno();
    else
      return hoy().anno() - anno() - 1;
  }

}
