class Articulo{
    constructor(nombre, precio){
        if(!nombre){
            throw new Error('Argumentos inválidos: el nombre del articulo no puede estar vacío');
        }
        this.nombre=nombre;
        this.precio=precio;
    }
}