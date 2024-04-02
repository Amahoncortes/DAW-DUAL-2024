// Crea la clase Persona que hereda de Mamífero
class Persona extends Mamifero {
    constructor(nombre, edad) {
        super();
        this.nombre = nombre;
        this.edad = edad;
    }

    getNombre() { return this.nombre; }
    setNombre(nombre) { this.nombre = nombre; }

    getEdad() { return this.edad; }
    setPrecio(edad) { this.edad = edad; }

    comer() {
        return "Las personas son seres omnivoros";
    }
}