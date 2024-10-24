package interfaz;

import dominio.*;
import java.util.Scanner;

public class Interfaz {
 
    private Scanner sc = new Scanner(System.in);
    private Pais p;

    public Interfaz(){
        
        p= new Pais("Espana");
        p=Pais.leer();
    }
    public void InterfazUsuario(){

        int x;
       
        while (true){
            
            imprimir();
            x=Opcion();
           
            if(x == 0){ //Cerrar programa

                System.out.println("Guardando programa");
                p.grabar();
                break;
            }else if(x==1){ //listar Pais

                String c;
                System.out.println(c=p.toString());
                if (c.isEmpty()){
                    
                    System.out.println("Esta vacio");
                }
            }else if(x==2){ //Añadir provincia

                AnnadirProvincia();
            }else if(x==3){ //Añadir municipio

                AnnadirMunicipio();
            }else if(x==4){ //Añadir localidad

                AnnadirLocalidad();
            }else{

                System.out.println("La opcion seleccionada no existe");
            }





        }
    }
    private void AnnadirProvincia(){
        try{
            System.out.println("Introduza el nombre de la provincia:");
            p.add(new Provincia(sc.next()));
    
        } catch (Exception e){
            
            System.out.println(e);
            System.out.println("El tipo de dato introducido no existe");
        }
    }
    private void AnnadirMunicipio(){

        if(p.size() == 0){

            System.out.println("No hay provincias a las que annadir municipios");
            return;
        }
        try{
            for(int i=0;i<p.size();i++){

                System.out.println(p.getProvincia(i).getNombre());
            }
            System.out.println("Introduzca el indice de la provincia a la que annadir y el nombre del municipio");
            p.getProvincia(sc.nextInt()).add( new Municipio(sc.next()));
        } catch (Exception e){System.out.println(e);}
    }
    private void AnnadirLocalidad(){

        if(p.size() == 0){

            System.out.println("No hay provincias a las que annadir localidades");
            return;
        }
        int prov,mun;
        for(int i=0;i<p.size();i++){

            System.out.println(p.getProvincia(i).getNombre());
        }
        System.out.println("Introduzca el indice de la provincia a la que annadir");
        prov= sc.nextInt();
        if(prov <p.size()){
           
            if(p.getProvincia(prov).size() == 0){

                System.out.println("No hay municipios a las que annadir localidades");
                return;
            }
            for(int i=0;i<p.getProvincia(prov).size();i++){

                System.out.println(p.getProvincia(prov).getMunicipio(i));
            }
            System.out.println("Introduzca el indice del municipio a la que annadir");
            mun = sc.nextInt();
            System.out.println("Introduzca el nombre y numero de habitantes de la localidad");
            p.getProvincia(prov).getMunicipio(mun).add(new Localidad(sc.next(),sc.nextInt()));
        }
    }
    private int Opcion(){

        int x=0;
        try{
        
        System.out.println("Introduzca la opcion a elegir:");
        
        x= sc.nextInt();
            sc.nextLine();
            return x;
       } 
       catch(Exception e){
       
        System.out.println("El tipo de dato introducido es incorrecto");
        return 1;
       }
    }
    private void imprimir(){

        System.out.println("Opciones:\n 0.Cerrar\n 1.Listar provincias\n 2.Annadir Provincia\n 3.Annadir Municipio\n 4.Annadir Localidad");
    }
    
    /* AddProvincia
     * AddLocalidad
     * AddLocalidad
     * 
     */
    
}
