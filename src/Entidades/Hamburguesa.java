
package Entidades;

public class Hamburguesa extends Producto implements IVendible{
    private TipoHamburguesa tipoHamburguesa;
    private TamanioHamburguesa tamanioHamburguesa;

    public Hamburguesa(String codigoProducto, String nombre, double precio, Proveedor proveedor,
                       TipoHamburguesa tipoHamburguesa, TamanioHamburguesa tamanioHamburguesa) {
        super(proveedor, codigoProducto, nombre, precio);
        this.tipoHamburguesa = tipoHamburguesa;
        this.tamanioHamburguesa = tamanioHamburguesa;
    }
    
    @Override
    public double getPrecioTotal() {
        double total = this.precio;
        
        switch (this.tamanioHamburguesa) {
            case CHICA:
                total *= 1.05;
                break;
            case MEDIANA:
                total *= 1.1;
                break;
            case GRANDE:
                total *= 1.2;
                break;
        }
        
        return total;
    }
    
    @Override
    public String toString() {
        return "\nTipo hamburguesa: " + this.tipoHamburguesa +
               "\nTamanio hamburguesa: " + this.tamanioHamburguesa + 
               "\nPrecio total: $" + this.getPrecioTotal();
    }
    
    @Override
    public boolean equals(Object o) {
        Hamburguesa oH = (Hamburguesa)o;
        
        if (super.equals(o) && this.tipoHamburguesa == oH.tipoHamburguesa
                && this.tamanioHamburguesa == oH.tamanioHamburguesa) {
            return true;
        }
        
        return false;
    }
}
