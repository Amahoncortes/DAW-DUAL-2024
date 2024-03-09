/**La clase Articulo tiene los siguientes campos:
 *  •Nombre (clave)
 *  •Precio */

class Articulo {
    constructor(nombre, precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //getters y setters
    getNombre() { return this.nombre; }
    setNombre(nombre) { this.nombre = nombre; }

    getPrecio() { return this.precio; }
    setPrecio(precio) { this.precio = precio; }
}