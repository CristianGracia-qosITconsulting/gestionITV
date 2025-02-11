package modelo;

import excepciones.*;

public class Vehiculo {
    private String nombre, apellidos, dni, matricula, identificador;
    
    public Vehiculo(String nombre, String apellidos, String dni, String matricula)
    throws DniException, MatriculaException, CampoVacioException {
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setDni(dni);
        this.setMatricula(matricula);
        this.setIdentificador();
    }
    
    //  GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) throws CampoVacioException {
        if (nombre.length() < 2) {
            throw new CampoVacioException("El campo \"nombre\" no puede estar vacío");
        }

        for (int i = 0; i < nombre.length(); i++) {
            char caracter = nombre.charAt(i);
            if (!Character.isLetter(caracter)) 
            throw new CampoVacioException("El campo \"nombre\" no puede contener números ni espacios");
        }
        this.nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1).toLowerCase();
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) throws CampoVacioException{
        if (apellidos.length() < 3) {
            throw new CampoVacioException("El campo nombre no puede estar vacío");
        }

        for (int i = 0; i < apellidos.length(); i++) {
            char caracter = apellidos.charAt(i);
            if (!Character.isLetter(caracter) && caracter != ' ') 
            throw new CampoVacioException("El campo \"Apellidos\" no puede contener números");
        }

        String[] nombreYapellidos;
        nombreYapellidos = apellidos.split(" ");
        if (nombreYapellidos.length != 2) {
            throw new CampoVacioException("El campo \"Apellidos\" debe contener 2 palabras");
        }

        String primerApellido = nombreYapellidos[0].toUpperCase().charAt(0) + 
        nombreYapellidos[0].substring(1).toLowerCase();
        
        String segundoApellido = nombreYapellidos[1].toUpperCase().charAt(0) + 
        nombreYapellidos[1].substring(1).toLowerCase();

        this.apellidos = primerApellido + " " + segundoApellido;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) throws DniException{
        if (dni.length() != 9) throw new DniException();
    
        int numDni;
        String tratadoLetra;
        char letra;
        
        try {
            tratadoLetra = dni.substring(dni.length()-1).toUpperCase();
            letra = tratadoLetra.charAt(0);
            numDni = Integer.parseInt(dni.substring(0, dni.length()-1));
        } catch (Exception e) {
            throw new DniException();
        }
        
        String letras = "TRWAGMYFPDXBNJZSOVHLCKE";     
        int posLetra = numDni%23;
        if (letras.charAt(posLetra) != letra) throw new DniException();
        
        this.dni = dni;
    
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) throws MatriculaException {
        if(matricula.length() != 7) throw new MatriculaException();
        
        String letrasDisponibles = "BCDFGHJKLMNPQRSTVWXYZ";
        String numeros = matricula.substring(0,4);
        String letras = matricula.substring(4,7).toUpperCase();

        for (int i = 0; i < letras.length(); i++) {
            char caracter = letras.charAt(i);
            
            if (letrasDisponibles.indexOf(caracter) == -1) 
            throw new MatriculaException();

        }

        try {
            int num = Integer.parseInt(numeros);
        } catch (Exception e) {
            throw new MatriculaException();
        }
        
        this.matricula = matricula;
    }
    
    public String getIdentificador() {
        return identificador;
    }
    
    public void setIdentificador() {
        String ide;
        String parteNombre = nombre.substring(0, 1);
        
        String[] apellidos = this.apellidos.split(" ");
        String parteApellidos = apellidos[0].substring(0, 1) + apellidos[1].substring(0, 1);
        
        ide = parteNombre + parteApellidos + this.dni.substring(5,this.dni.length()-1);
        this.identificador = ide;
    }
    
    // TOSTRING
    @Override
    public String toString() {
        return "Vehiculo [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", matricula=" + matricula
                + ", identificador=" + identificador + "]";
    }
    }
    
