
package Entidades;

import java.util.Random;

public abstract class Producto {
   protected Proveedor proveedor;
   protected String codigoProducto;
   protected String nombre;
   protected double precio;
   protected int calorias;
   protected int tiempoPreparacion;
   protected static Random generadorAleatorio;

   static {
       generadorAleatorio = new Random();
   }

    public Producto(Proveedor proveedor, String codigoProducto, String nombre, double precio) {
        this.proveedor = proveedor;
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String codigoProducto, String nombre, double precio,
                    String nombreProveedor, String ciudadProveedor, int antiguedadProveedor) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = new Proveedor(nombreProveedor, ciudadProveedor, antiguedadProveedor);
    }
   
    public int getCalorias() {
        if(this.calorias == 0) {
            this.calorias = generadorAleatorio.nextInt(600) + 200;
        }
        return this.calorias;
    }
    
    public int getTiempoPreparacion() {
        if(this.tiempoPreparacion == 0) {
            this.tiempoPreparacion = generadorAleatorio.nextInt(18) + 2;
        }
        
        return this.tiempoPreparacion;
    }
    
    private static String mostrar(Producto p) {
        return "\nProveedor: " + p.proveedor + "\nCodigo producto: " + p.codigoProducto +
               "\nNombre: " + p.nombre + "\nPrecio: " + p.precio +
               "\nCalorias: " + p.calorias + "\nTiempo preparacion: " + p.tiempoPreparacion;
    }
    
    private static boolean sonIguales(Producto p1, Producto p2) {
        return p1.codigoProducto.equals(p2.codigoProducto) && Proveedor.sonIguales(p1.proveedor, p2.proveedor);
    }
    
    @Override
    public boolean equals(Object o) {
        Producto oP = (Producto)o;
        
        if (o != null && o instanceof Producto && Producto.sonIguales(this, oP)) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return Producto.mostrar(this);
    }
}
