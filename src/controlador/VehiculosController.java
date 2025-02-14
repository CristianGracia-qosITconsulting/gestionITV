package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import modelo.*;

public class VehiculosController {

    private Queue<DatosVehiculos> colaEspera = new LinkedList<>();
    private Queue<DatosVehiculos> colaAtendidos = new LinkedList<>();

    public VehiculosController() {
        File f = new File("Fichero.txt");

        try(FileReader fr = new FileReader(f); BufferedReader bf = new BufferedReader(fr)){
            String linea ="";
            while ((linea = bf.readLine()) != null) {
                String[] partes = linea.split(",");
                nuevoVehiculo(new Vehiculo(partes[0], partes[1], partes[2], partes[3]));
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Error en la lectura del fichero");
            System.out.println(e.getMessage());
        }
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

    public Queue<DatosVehiculos> getColaEspera() {
        return colaEspera;
    }
}
