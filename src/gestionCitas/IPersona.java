package gestionCitas;
/**
 * Especificaci�n del TAD Persona<br>
 *
 * @author PII
 */
import fecha.*;

public interface IPersona
{
/**
 * POST: resultado es la cadena de caracteres formada por los
 *       atributos del objeto.
 */
  public String toString ();
/**
 * POST: resultado es cierto si "pp" es identico al objeto y es
 *       falso e.o.c.
 */
  public boolean equals (Object pp);
/**
 * POST: resultado es el nombre del objeto.
 */
  public String getNombre ();
/**
 * POST: resultado es la fecha de nacimiento del objeto.
 */
  public IFecha getFechaNacimiento ();
  /**
 * POST: resultado es el pais del objeto.
 */
  public String getPais ();
  /**
 * POST: resultado es el numero de identificacion del objeto.
 */
  public int getDNI ();

}