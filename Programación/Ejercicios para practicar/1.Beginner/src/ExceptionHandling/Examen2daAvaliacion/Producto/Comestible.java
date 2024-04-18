package ExceptionHandling.Examen2daAvaliacion.Producto;

import ExceptionHandling.Examen2daAvaliacion.Producto.Producto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Comestible extends Producto {
    private LocalDate fechaCaducidad;

    public Comestible() {
        this.fechaCaducidad = LocalDate.now();
    }

    public Comestible(String nombre, double precio, LocalDate fechaCaducidad) {
        super(nombre, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = dtf.format(fechaCaducidad);
        return STR."\{super.toString()}\nFecha de caducidad: \{fechaFormateada}";
    }
}
