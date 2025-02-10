package vista;
import excepciones.DniException;
import excepciones.MatriculaException;
import modelo.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Vehiculo v;
        try {
            v = new Vehiculo("Pepe", "Garcia Perez", "12345678Z", "1234BBC");
            System.out.println(v.toString());
        } catch (DniException | MatriculaException e) {
            System.out.println(e.getMessage());
        }
    }
}
