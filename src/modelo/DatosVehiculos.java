package modelo;

public class DatosVehiculos {
    private Vehiculo vehiculo;
    private long entrada, salida, tiempoEspera;
    private static long tiempoTotal;

    public DatosVehiculos(Vehiculo vehiculo) {

        this.setVehiculo(vehiculo);
        this.entrada = Reloj.ahora();
    }

    //METODOS
    public void atiende(){
        this.salida = Reloj.ahora();
        this.tiempoEspera = getTiempoEspera();
        tiempoTotal+=this.tiempoEspera;
        System.out.println("Tiempo de espera: " + this.tiempoEspera + "s");
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

    public static long getTiempoTotal() {
        return tiempoTotal;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "DatosVehiculos [vehiculo=" + vehiculo + ", entrada=" + entrada + ", salida=" + salida
                + ", tiempoEspera=" + tiempoEspera + "]";
    }


    

}