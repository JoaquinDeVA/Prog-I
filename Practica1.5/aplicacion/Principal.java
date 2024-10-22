package aplicacion;

import dominio.*;

public class Principal{

    public static void main(String[] args){

        //Provamos que podemos crear e imprimir por pantalla una provincia (Madrid con dos municipios y sus correspondientes localidades)
        Provincia madrid = new Provincia("Madrid");
        Municipio uno = new Municipio("Alcala de Henares");
        Municipio dos = new Municipio("Alcorcón");
        madrid.add(uno);
        madrid.add(dos);
        Localidad unoUno = new Localidad("Norte", 50000);
        Localidad unoDos = new Localidad("centro",80000);
        uno.add(unoUno);
        uno.add(unoDos);
        Localidad dosUno= new Localidad("Sur", 200000);
        Localidad dosDos= new Localidad("Este", 150);
        dos.add(dosUno);
        dos.add(dosDos);
        System.out.print(madrid.toString());

    }
}