package ferreteria;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gabriela Sandoval Cruz
 */
public class Venta implements Serializable{
  String clave; 
  double iva; 
  double total; 
  double subtotal; 
  ArrayList<Producto> detalle;
  
  public Venta(){
    detalle = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "Clave: "+clave+" | $: "+total;
  }

  public double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }
  
  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public double getIva() {
    return iva;
  }

  public void setIva(double iva) {
    this.iva = iva;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }
  
  public void addProducto(Producto producto){
    detalle.add(producto);
  }
  
  public void mostrarDetalle(){
    double subtotal = 0;
    System.out.println("");
    System.out.println("--------------- Nota de venta ---------------");
    System.out.println("# Folio: "+clave);
    for (int i = 0; i < detalle.size(); i++) {
      subtotal = detalle.get(i).getExistencia() * detalle.get(i).getPrecioCompra();
      System.out.println("# "+detalle.get(i).getClave()+" "+detalle.get(i).getNombre()+" "+detalle.get(i).getExistencia()+
          " "+subtotal);
    }
    System.out.println("# Subtotal: "+this.subtotal);
    System.out.println("# IVA: "+iva);
    System.out.println("# Total: "+total);
    System.out.println("---------------------------------------------");
    System.out.println("");
  }
}
