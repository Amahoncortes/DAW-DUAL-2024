/*Crea la clase lineaTicket con los siguientes campos: articulo, cantidad, precio, total, y el
método mostrarDatos. Puedes utilizar este método, el cual te permite crear la estructura
de tabla sin necesidad de crear los nodos. (Nota: En ese caso debes utilizar la propiedad
innerHTML del objeto a modificar)
*/

class lineaTicket{
    constructor(articulo, cantidad, precio, total){
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    //Usar .innerHTML
    mostrarDatos() {
        return `<tr class='comprados'><td> ${this.articulo} </td><td> ${this.precio} €/Kg</td><td>$
        {this.cantidad} kg</td><td class='precioTabla'> ${this.total}</tr> `; }
}

