package gestionCitas;
/**
 * Especificaci�n del TAD GestorCitas<br>
 *
 * @author PII
 */
import tads.*;

public interface IGestorCitas
{
/**
 * POST: resultado es la cadena de caracteres formada por los
 *       atributos del objeto.
 */
  public String toString ();
/**
 * POST: resultado es el censo total de gente del objeto.
 */
  public IQueue<IPersona> getGente ();
/**
 * POST: resultado es el i_�simo vacunodromo del objeto.
 */
  public Vacunodromo getVacunodromo (int i);
/**
 * POST: resultado es el repositorio de ciudadanos del objeto que
 *       han rechazado vacunarse.
 */
  public IStack<Ciudadano> getRenuentes ();
/**
 * POST: resultado es el repositorio de personas menores de 10 a�os.
 */
  public IList<IPersona> getInfantes ();
/**
 * POST: resultado es cierto si el objeto esta vacio y, es falso e.o.c.
 */
  public boolean estaVacio ();
/**
 * PRE:  el objeto no esta vacio.
 * POST: resultado es el primer elemento del objeto (el del principio)
 */
  public IPersona primero();
/**
 * POST: a�ade el elemento "pp" al objeto (al final).
 */
  public void insertar (IPersona pp);
/**
 * POST: elimina el primer elemento del objeto (el del principio).
 */
  public void borrar ();
/**
 * POST: vac�a todos los vacun�dromos de ciudadanos y, a los que
 *       todav�a no tengan las dos dosis, los vuelve a a�adir al
 *       objeto en el �ltimo lugar.
 */
  public void vacunar ();
/**
 * POST: a�ade el primero de la lista general al repositorio
 *       correspondiente, segun el protocolo establecido.
 */
  public void aplicarProtocolo ();
/**
 * POST: a�ade cada ciudadano a su vacunodromo correspondiente
 *       (si ha aceptado la vacunacion), al repositorio de renuentes
 *       (si no la ha aceptado), al repositorio de infantes (si tiene
 *       menos de 10 a�os) y todo, segun el protocolo establecido.
 *       Descarta a las personas que no sean ciudadanos.
 */
  public void gestionar ();
}