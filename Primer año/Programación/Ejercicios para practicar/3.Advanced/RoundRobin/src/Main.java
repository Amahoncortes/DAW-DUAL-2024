class Proceso {
    private String nombre;
    private int tiempoRestante;
    public Proceso siguiente; // Atributo para la lista enlazada

    public Proceso(String nombre, int tiempoRestante) {
        this.nombre = nombre;
        this.tiempoRestante = tiempoRestante;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void ejecutar(int quantum) {
        if (tiempoRestante > quantum) {
            tiempoRestante -= quantum;
            System.out.println("Ejecutando " + nombre + " por " + quantum + " unidades de tiempo.");
        } else {
            System.out.println("Ejecutando " + nombre + " por " + tiempoRestante + " unidades de tiempo.");
            tiempoRestante = 0;
        }
    }

    public boolean haTerminado() {
        return tiempoRestante == 0;
    }
}

class RoundRobinScheduler {
    private Proceso inicio;
    private Proceso fin;

    public void agregarProceso(Proceso proceso) {
        if (inicio == null) {
            inicio = proceso;
            fin = proceso;
            fin.siguiente = inicio; // Hacemos que el último nodo apunte al primero para hacer la lista circular
        } else {
            fin.siguiente = proceso;
            fin = proceso;
            fin.siguiente = inicio; // Hacemos que el último nodo apunte al primero para hacer la lista circular
        }
    }

    public void ejecutar(int quantum) {
        if (inicio == null) {
            System.out.println("No hay procesos en la cola.");
            return;
        }

        Proceso actual = inicio;
        do {
            actual.ejecutar(quantum);
            if (actual.haTerminado()) {
                System.out.println("Proceso " + actual.getNombre() + " terminado.");
                eliminarProceso(actual);
            }
            actual = actual.siguiente;
        } while (actual != inicio);
    }

    private void eliminarProceso(Proceso proceso) {
        Proceso actual = inicio;
        Proceso anterior = null;

        do {
            if (actual == proceso) {
                if (anterior != null) {
                    anterior.siguiente = actual.siguiente;
                    if (actual == inicio) {
                        inicio = actual.siguiente;
                    }
                    if (actual == fin) {
                        fin = anterior;
                    }
                } else {
                    inicio = inicio.siguiente;
                    fin.siguiente = inicio;
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != inicio);
    }
}

public class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.agregarProceso(new Proceso("Proceso A", 8));
        scheduler.agregarProceso(new Proceso("Proceso B", 10));
        scheduler.agregarProceso(new Proceso("Proceso C", 6));
        scheduler.agregarProceso(new Proceso("Proceso D", 4));

        scheduler.ejecutar(5); // Ejecutar los procesos con un quantum de 5 unidades de tiempo
    }
}
