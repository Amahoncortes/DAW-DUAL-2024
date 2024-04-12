package POO.Parte2.AlquilerVehiculos;
import POO.Parte2.AlquilerVehiculos.Vehiculo.Vehiculo;

//*El alquiler de un vehículo: almacenando una referencia al cliente que lo alquila,
// *y los datos del vehículo alquilado. Además, se registrarán el día, mes, año y el número de días que estará el vehículo en alquiler.
public class VehiculoAlquilado {

    //Referencia al cliente que alquila
    private Cliente cliente;

    //Referencia a vehiculo alquilado
    private Vehiculo vehiculo;

    // Además, se registrarán el día, mes, año y el número de días que estará el vehículo en alquiler.
    private int diaAlquiler;
    private int mesAlquiler;
    private int anhoAlquiler;
    private int totalDiasAlquiler;

    public VehiculoAlquilado(Cliente cliente, Vehiculo vehiculo, int diaAlquiler, int mesAlquiler, int anhoAlquiler, int totalDiasAlquiler) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.diaAlquiler = diaAlquiler;
        this.mesAlquiler = mesAlquiler;
        this.anhoAlquiler = anhoAlquiler;
        this.totalDiasAlquiler = totalDiasAlquiler;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getDiaAlquiler() {
        return diaAlquiler;
    }

    public void setDiaAlquiler(int diaAlquiler) {
        this.diaAlquiler = diaAlquiler;
    }

    public int getMesAlquiler() {
        return mesAlquiler;
    }

    public void setMesAlquiler(int mesAlquiler) {
        this.mesAlquiler = mesAlquiler;
    }

    public int getAnhoAlquiler() {
        return anhoAlquiler;
    }

    public void setAnhoAlquiler(int anhoAlquiler) {
        this.anhoAlquiler = anhoAlquiler;
    }

    public int getTotalDiasAlquiler() {
        return totalDiasAlquiler;
    }

    public void setTotalDiasAlquiler(int totalDiasAlquiler) {
        this.totalDiasAlquiler = totalDiasAlquiler;
    }
}
