/**Utilizando la clase Vehículo,
 *vamos a crear una aplicación en JavaScript
  para gestionar un aparcamiento de coches.
  Funcionamiento:
◦ Pedir los datos de cada vehículo con un formulario
◦ Al pulsar un botón Guardar se almacena los vehículos en un ArrayList de vehículos
◦ Añadir un botón Mostrar que visualice todos los coches aparcados en el aparcamiento. Para
ello debes crear un método imprimirVehiculo que muestre los datos utilizando los métodos de
creación de nodos de la estructura DOM.
*/

//Clase Vehiculo

class Vehiculo {
    constructor(modelo, marca, precio, km) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.km = km;
    }

    //Para los getters y setters, hacer declaraciones inline (de una linea)
    getModelo() { return this.modelo; }
    setModelo(modelo) { this.modelo = modelo; }

    //marca
    getMarca() { return this.marca; }
    setMarca(marca) { this.marca = marca; }

    //Precio
    getPrecio() { return this.precio; }
    setPrecio(precio) { this.precio = precio; }

    //km
    getKm() { return this.km; }
    setKm(km) { this.km = km; }

    //Metodos  
    mostrarDatos() {
        return "Vehiculo dado de alta: \n" +
            "Modelo: " + this.modelo + "\n" +
            "Marca: " + this.marca + "\n" +
            "Precio: " + this.precio + "\n" +
            "Km: " + this.km;
    }
}