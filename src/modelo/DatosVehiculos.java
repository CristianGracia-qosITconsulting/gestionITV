package modelo;

public class DatosVehiculos {
    private Vehiculo vehiculo;
    private long entrada, salida, tiempoEspera;

    public DatosVehiculos() {
        this.entrada = Reloj.ahora();
    }

    //METODOS
    public void atiende(){
        this.salida = Reloj.ahora();
        this.tiempoEspera = this.salida - this.entrada;
    };

    public void DatosVehiculo(Vehiculo v){
    
    
    }

    // GETTERS
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public long getEntrada() {
        return entrada;
    }

    public long getTiempoEspera() {
        return tiempoEspera;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "DatosVehiculos [vehiculo=" + vehiculo + ", entrada=" + entrada + ", salida=" + salida
                + ", tiempoEspera=" + tiempoEspera + "]";
    }


    

}