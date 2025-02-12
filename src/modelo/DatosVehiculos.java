package modelo;

public class DatosVehiculos {
    private Vehiculo vehiculo;
    private long entrada, salida, tiempoEspera;

    public DatosVehiculos(Vehiculo vehiculo) {

        this.setVehiculo(vehiculo);
        this.entrada = Reloj.ahora();
    }

    //METODOS
    public void atiende(){
        this.salida = Reloj.ahora();
        this.tiempoEspera = this.salida - this.entrada;
        System.out.println("Tiempo de espera: " + this.tiempoEspera + " ms");
    }

    // GETTERS
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public long getEntrada() {
        return entrada;
    }

    public long getTiempoEspera() {
        return (salida - entrada) / 1000;
    }


    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "DatosVehiculos [vehiculo=" + vehiculo + ", entrada=" + entrada + ", salida=" + salida
                + ", tiempoEspera=" + tiempoEspera + "]";
    }


    

}