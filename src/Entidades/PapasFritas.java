
package Entidades;

public class PapasFritas extends Producto implements IVendible {
    private TipoPapas tipoPapas;

    public PapasFritas(String codigoProducto, String nombre, double precio, Proveedor proveedor, TipoPapas tipoPapas) {
        super(proveedor, codigoProducto, nombre, precio);
        this.tipoPapas = tipoPapas;
    }
    
    @Override
    public double getPrecioTotal() {
        double total = this.precio;
        
        switch (this.tipoPapas) {
            case CLASICAS:
                total *= 1.1;
                break;
            case CON_CHEDDAR:
                total *= 1.15;
                break;
            case CON_BACON:
                total *= 1.2;
                break;
        }
        
        return total;
    }
    
    @Override
    public String toString() {
        return "\nTipo hamburguesa: " + this.tipoPapas +
               "\nPrecio total: $" + this.getPrecioTotal();
    }
    
    @Override
    public boolean equals(Object o) {
        PapasFritas oP = (PapasFritas)o;
        
        if (super.equals(o) && this.tipoPapas == oP.tipoPapas) {
            return true;
        }
        
        return false;
    }
}
