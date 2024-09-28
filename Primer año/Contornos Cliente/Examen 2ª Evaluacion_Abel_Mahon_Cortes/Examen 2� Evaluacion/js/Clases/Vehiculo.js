// EJERCICIO 1.3: PUNTUACION 1,25 PUNTOS:
    
//Crear la clase vehiculo con los atributos marca, modelo, numOcupantes, precio.

class Vehiculo{
    constructor(marca, modelo, numOcupantes, precio, nombreOcupantes) {
        this.marca = marca;
        this.modelo = modelo;
        this.numOcupantes = numOcupantes;
        this.precio = precio;
        this.nombreOcupantes = nombreOcupantes;
    }

    agregarOcupantes(numOcupantes, nombreOcupantes) {
       for (let i = 0; i < numOcupantes.length; i++) {
           numOcupantes[i] = nombreOcupantes;
           return nombreOcupantes;
       }
    }


    
    imprimeVehiculo() {
       document.write( "El coche ", this.getMarca(), " ", this.getModelo(), 
            "con un precio de ", this.getPrecio() , " euros ",
            " tiene como ocupantes a ",
             this.getOcupantes());
    }

    //getters y setters
    getMarca() { return this.marca;}
    getModelo() { return this.modelo;}
    getNumOcupantes() { return this.numOcupantes;}
    getPrecio() { return this.precio;}
    getOcupantes() { return this.nombreOcupantes;}


}
    
//Además tiene una propiedad de tipo Array
//que es ocupantes donde se almacena el nombre de cada ocupante. Para ello debes utilizar el método agregarOcupantes
   
// Método agregar ocupantes, que recorre el array para asignar el nombre
     
//Metodo imprime ocupantes, muestra los datos de los ocupantes


//Metodo imprime el vehiculo