package vista;

import controlador.VehiculosController;
import excepciones.*;
import modelo.*;

public class Main{
    public static void main(String[] args){
        VehiculosController vc = new VehiculosController();
        int numVehiculos = vc.getColaEspera().size();
        for (int i = 0; i < numVehiculos; i++) {
                vc.atenderVehiculo();
            }
        System.out.printf("Tiempo de espera medio: %ds",DatosVehiculos.getTiempoTotal()/numVehiculos);
            
    }
}
