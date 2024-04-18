package ExceptionHandling.Examen2daAvaliacion;

import ExceptionHandling.Examen2daAvaliacion.Producto.Producto;

import java.util.HashMap;

public class Comercial {
    private String nombre, apellidos;
    private int edad;
    private String zona;
    HashMap<Integer, Producto> stock = new HashMap<>();

    public Comercial() {
        this.nombre = "Pepe";
        this.apellidos = "Perez";
        this.edad = 20;
        this.zona = "Zona 1";
    }

    public Comercial(String nombre, String apellidos, int edad, String zona, HashMap<Integer, Producto> stock) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.zona = zona;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public HashMap<Integer, Producto> getStock() {
        return stock;
    }

    public void setStock(HashMap<Integer, Producto> stock) {
        this.stock = stock;
    }


}
