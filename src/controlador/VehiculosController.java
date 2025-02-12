package controlador;

import java.util.LinkedList;
import java.util.Queue;
import modelo.*;

public class VehiculosController {

    private Queue<DatosVehiculos> colaEspera = new LinkedList<>();
    private Queue<DatosVehiculos> colaAtendidos = new LinkedList<>();

    public VehiculosController() {
    }

    public void nuevoVehiculo(Vehiculo vehiculo) {
        DatosVehiculos datosVehiculos = new DatosVehiculos(vehiculo);
        colaEspera.add(datosVehiculos);
        System.out.println(vehiculo.getMatricula() + " ha sido añadido a la cola de espera");
    }

    public void atenderVehiculo() {
        
        if(colaEspera.isEmpty()){
            System.out.println("No hay vehiculos en espera");
            return;
        }

        DatosVehiculos v = colaEspera.poll();
        v.atiende();
        colaAtendidos.add(v);
        System.out.println(v.getVehiculo().getMatricula() + " ha sido atendido");
    }
}
