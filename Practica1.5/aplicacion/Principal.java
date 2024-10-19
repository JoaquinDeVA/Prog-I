package aplicacion;

import dominio.*;

public class Principal{

    public static void main(String[] args){

        //Provamos que podemos crear e imprimir por pantalla una provincia (Madrid con dos municipios y sus correspondientes localidades)
        Provincia madrid = new Provincia("Madrid");
        Municipio uno = new Municipio("Alcala de Henares");
        Municipio dos = new Municipio("Alcorcón");
        madrid.annadirMunicipio(uno);
        madrid.annadirMunicipio(dos);
        Localidad unoUno = new Localidad("Norte", 50000);
        Localidad unoDos = new Localidad("centro",80000);
        uno.annadirLocalidad(unoUno);
        uno.annadirLocalidad(unoDos);
        Localidad dosUno= new Localidad("Sur", 200000);
        Localidad dosDos= new Localidad("Este", 150);
        dos.annadirLocalidad(dosUno);
        dos.annadirLocalidad(dosDos);
        System.out.print(madrid.toString());

    }
}