class Alumno {
    constructor(nombre, direccion, dni) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
    }




    //Getters y setters
    getNombre() { return this.nombre; }
    setNombre(nombre) { this.nombre = nombre; }

    getDireccion() { return this.direccion; }
    setDireccion(direccion) { this.direccion = direccion; }

    getDNI() { return this.dni; }
    setDNI(dni) { this.dni = dni; }

}

