package ferreteria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriela Sandoval Cruz
 */
public class Archivo {

  File archivo;
  FileOutputStream fileOut;
  ObjectOutputStream salida;
  ObjectInputStream entrada;
  FileInputStream fileIn;
  
  /**
   * Al construir el objeto se le pasa el nombre del archivo que sera usado para la persisencia 
   * @param nombre recibe el nombre del archivo en el que se va a escribir o leer
   */
  public Archivo(String nombre) {
    archivo = new File(nombre);
  }
  /**
   * Se inicializan los elementos necesarios para realizar una escritura en archivo de texto, se recibe
   * la lista que se serializar como parametro
   * @param lista arraylist que se desea serializar
   */
  public void salida(ArrayList lista) {
    try {
      fileOut = new FileOutputStream(archivo);
      salida = new ObjectOutputStream(fileOut);
      salida.writeObject(lista);
      salida.close();
    } catch (FileNotFoundException e) {
      System.out.println("No encontrado");
    } catch (IOException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  /**
   * Se inicializan los elementos neesarios para realizar una lectura en un archivo de texto.
   * @return lista casteada a arraylist, sacada del archivo que serializamos
   */
  public ArrayList entrada() {
    ArrayList<Producto> lista = null;

    try {
      fileIn = new FileInputStream(archivo);
      entrada = new ObjectInputStream(fileIn);
      lista = (ArrayList<Producto>) entrada.readObject();
      entrada.close();
    } catch (FileNotFoundException ex) {
      System.out.println("Archivo no encontrado");
    } catch (IOException ex) {
      System.out.println("Creando el archivo");
    } catch (ClassNotFoundException z) {
      System.out.println("Error de clase");
    }

    return lista;
  }
  
  public ArrayList entradaVentas() {
    ArrayList<Venta> lista = null;

    try {
      fileIn = new FileInputStream(archivo);
      entrada = new ObjectInputStream(fileIn);
      lista = (ArrayList<Venta>) entrada.readObject();
      entrada.close();
    } catch (FileNotFoundException ex) {
      System.out.println("Archivo no encontrado");
    } catch (IOException ex) {
      System.out.println("Creando el archivo");
    } catch (ClassNotFoundException z) {
      System.out.println("Error de clase");
    }

    return lista;
  }
  
  public ArrayList entradaDetalles() {
    ArrayList<DetalleVenta> lista = null;

    try {
      fileIn = new FileInputStream(archivo);
      entrada = new ObjectInputStream(fileIn);
      lista = (ArrayList<DetalleVenta>) entrada.readObject();
      entrada.close();
    } catch (FileNotFoundException ex) {
      System.out.println("Archivo no encontrado");
    } catch (IOException e) {
      System.out.println("Creando el archivo");
    } catch (ClassNotFoundException z) {
      System.out.println("Error de clase");
    }
    return lista;
  }
  
  /**
   * Método que devuelve la bandera de existencia de algun produto dentro de la lista
   * @return 
   */
  public boolean existencia(){
    try{
      fileIn = new FileInputStream(archivo);
      return true;
    } catch (FileNotFoundException ex) {
      return false; 
    }
  }
}
