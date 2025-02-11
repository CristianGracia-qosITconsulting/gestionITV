package vista;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import excepciones.CampoVacioException;
import excepciones.DniException;
import excepciones.MatriculaException;
import modelo.*;

public class Main{
    public static void main(String[] args){
        Vehiculo v;
        try {
            v = new Vehiculo("pEpe", "garcia PERez", "12345678Z", "1234BBC");
            System.out.println(v.toString());
        } catch (DniException | MatriculaException | CampoVacioException e) {
            System.out.println(e.getMessage());
        }
    }
}
