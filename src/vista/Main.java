package vista;

import java.lang.reflect.Array;
import java.util.ArrayList;

import controlador.VehiculosController;
import excepciones.CampoVacioException;
import excepciones.DniException;
import excepciones.MatriculaException;
import modelo.*;

public class Main{
    public static void main(String[] args){
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        Vehiculo v, v2, v3, v4;
        try {
            v = new Vehiculo("pEpe", "garcia PERez", "12345678Z", "1234BBC");
            v2 = new Vehiculo("Juan", "Moreno Gomez", "12345678Z", "4683DDV");
            v3 = new Vehiculo("Maria", "Rodriguez Salas", "12345678Z", "7435JSB");
            v4 = new Vehiculo("Antonio", "Lopez Gutierrez", "12345678Z", "9122FCK");
            System.out.println(v.toString());
            vehiculos.add(v);
            vehiculos.add(v2);
            vehiculos.add(v3);
            vehiculos.add(v4);

            VehiculosController vc = new VehiculosController();
            
            for (Vehiculo vehiculo : vehiculos) {
                vc.nuevoVehiculo(vehiculo);
            }
            for (int i = 0; i < vehiculos.size(); i++) {
                vc.atenderVehiculo();
            }


            

        } catch (DniException | MatriculaException | CampoVacioException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
