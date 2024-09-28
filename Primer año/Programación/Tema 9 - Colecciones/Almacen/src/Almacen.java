import java.util.ArrayList;
import java.util.List;

public class Almacen { //Representa el almacén que contendrá los productos

    /*Como en el primer método queremos calcular el precio total de las bebidas
     -Añadimos un atributo "bebidas" que es una Lista (List)
     para almacenar una colección de bebidas en el almacén.
     -Constructor: creamos constructor para inicializar la lista de bebidas al momento
     de crear una instancia de la clase Almacén
     */

    private List<Bebida> bebidas;
    private List<Producto> productos;

    public Almacen() {
        this.bebidas = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    /*
     * Agregar bebidas al almacén
     * */
    
    public void agregarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    /*
    agregar productos al almacén
    */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
     


    /*Ahora calculamos el precio total de las bebidas.
     * Iteración sobre la lista de bebidas:
     * Utilizamos un bucle for-each para iterar sobre todas las bebidas
     * de la lista 'bebidas'.
     * Sumar precios: Para cada bebida, sumamos el resultado del método
     * CalcularPrecio a una variable precioTotal:
     * */

    public double calcularPrecioTotalBebidas() {
        double precioTotal = 0.0;
        for (Bebida bebida : bebidas) {
            precioTotal += bebida.calcularPrecio();
        }
        return precioTotal;
    }


    public double calcularPrecioTotalProductos() {
        double precioTotal = 0.0;
        for (Producto producto : productos) {
            precioTotal += producto.getPrecio();
        }
        return precioTotal;
    }

    /*
     * uso del almacén en el main
     * Creamos una instancia de almacén en el main
     * agregamos instancias de bebida, agua mineral, o refresco, según sea necesario.
     * calculamos precio total: llamamos al método calcularPrecioTotalBebidas
     * para obtener el precio total de todas las bebidas del almacén
     * */

    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        
        //Creamos una instancia de agua mineral y la agregamos al almacén
        AguaMineral aguaMineral1 = new AguaMineral();
        aguaMineral1.setTipoEnvase("Cristal");
        almacen.agregarBebida(aguaMineral1);

        //Creamos una instancia de refresco y la agregamos al almacén
        Refresco refresco1 = new Refresco();
        refresco1.setTipoEnvase("lata"); 
        almacen.agregarProducto(refresco1);
    }
}
