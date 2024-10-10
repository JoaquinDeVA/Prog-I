package aplicacion;

import dominio.Localidad;

public class Principal{

    public static void main(String[] args){
    
        Localidad guadalajara = new Localidad("Guadalajara", 200000);
        System.out.print(guadalajara.toString());

    }
}