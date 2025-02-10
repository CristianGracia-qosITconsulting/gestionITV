package vista;
import modelo.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Vehiculo v;
        try {
            v = new Vehiculo("Pepe", "Perez", "12345678Z", "1234BBC", "12345678Z");
            System.out.println(v.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
