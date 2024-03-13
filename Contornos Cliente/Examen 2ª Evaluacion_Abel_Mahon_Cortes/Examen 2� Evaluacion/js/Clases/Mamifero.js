//EJERCICIO 1.1

//Crea la clase abstracta Mamifero con nombre, edad, y método comer

/**La clase Mamifero tiene los siguientes campos:
 *  •Nombre (clave)
 *  •Edad */

class Mamifero {
    constructor(nombre, edad) {
        this.nombre = nombre;
        this.edad = edad;
        if (this.constructor === Mamifero) {
            throw new Error("La clase mamifero es abstracta");
        }
    }

    //getters y setters
    getNombre() { return this.nombre; }
    setNombre(nombre) { this.nombre = nombre; }

    getEdad() { return this.edad; }
    setPrecio(edad) { this.edad = edad; }

    //método comer, abstracto
    comer() {
        throw new Error("Metodo abstracto. Implementar en subclase");
    }
}





