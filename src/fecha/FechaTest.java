package fecha;
import java.util.*;
/** 
 * Algunas pruebas de la clase Fecha.
 * 
 * @author Galve  
 */
public class FechaTest 
{
  static IFecha f1 = new Fecha(1, 1, 2000); 
  static IFecha f2 = new Fecha(25, 5, 2000); 
  static IFecha f3 = new Fecha(31, 12, 2000); 
  
  public static void main (String[] args) 
  {   
    System.out.println("f2 = " + f2);
    System.out.println("pruebaDate = " + new Date());
    System.out.println("f1.edad() = " + f1.edad());
    System.out.println("f2.edad() = " + f2.edad());
    System.out.println("f3.edad() = " + f3.edad());
  }
}
