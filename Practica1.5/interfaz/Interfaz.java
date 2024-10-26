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
            }else if(x==5){ //Leer
            
            leer();
            }else{

                System.out.println("La opcion seleccionada no existe");
            }





        }
    }
    private void AnnadirProvincia(){

        System.out.println("Introduza el nombre de la provincia:");
        p.add(new Provincia(sc.next()));
    }
    private void AnnadirMunicipio(){

        int prov;
        if(p.size() == 0){

            System.out.println("No hay provincias a las que annadir municipios");
            return;
        }
        System.out.println("PROVINCIAS:");
        for(int i=0;i<p.size();i++){

            System.out.println(i + " - " + p.getProvincia(i).getNombre());
        }
        System.out.println("Introduzca primero el indice de la provincia a la que annadir y despues el nombre del municipio");
        prov = sc.nextInt();
        if(prov < p.size() && prov >= 0){
        p.getProvincia(prov).add( new Municipio(sc.next()));
        }
        else{

            System.out.println("valor fuera de rango");
        }
    }
    private void AnnadirLocalidad(){

        int prov,mun;
        if(p.size() == 0){

            System.out.println("No hay provincias a las que annadir localidades");
            return;
        }
        System.out.println("PROVINCIAS:");
        for(int i=0;i<p.size();i++){

            System.out.println(i+" - "+p.getProvincia(i).getNombre());
        }
        System.out.println("Introduzca el indice de la provincia a la que annadir");
        prov= sc.nextInt();
        if(prov <p.size() && prov >= 0){
           
            if(p.getProvincia(prov).size() == 0){

                System.out.println("No hay municipios a las que annadir localidades");
                return;
            }
            System.out.println("MUNICIPIOS:");
            for(int i=0;i<p.getProvincia(prov).size();i++){

                System.out.println(i+" - "+p.getProvincia(prov).getMunicipio(i).getNombre());
            }
            System.out.println("Introduzca el indice del municipio al que annadir");
            mun = sc.nextInt();
            if(mun < p.getProvincia(prov).size() && mun >= 0){
            System.out.println("Introduzca el nombre y numero de habitantes de la localidad");
            p.getProvincia(prov).getMunicipio(mun).add(new Localidad(sc.next(),sc.nextInt()));
            }
            else{
                System.out.println("valor fuera de rango");
            }
        } 
        else{
            System.out.println("valor fuera de rango");
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
    public  void leer(){
            
        String nombreP, nombreM, nombreL;
        do {
            System.out.print("Introduce el nombre de la provincia (<enter> para finalizar: ");
            nombreP=sc.nextLine();
            if(!nombreP.equals("")){
                
                Provincia provincia=new Provincia(nombreP);
                do {
                    
                    System.out.print("Introduce el nombre del municipio (<enter> para finalizar: ");
                    nombreM=sc.nextLine();
                    if(!nombreM.equals("")){
                        
                        Municipio municipio=new Municipio(nombreM);
                        do {
                        
                            System.out.print("Introduce el nombre de la localidad (<enter> para finalizar: ");
                            nombreL=sc.nextLine();
                            if(!nombreL.equals("")){
                                
                                System.out.print("Introduce la población de la localidad: ");
                                int poblacion=sc.nextInt();
                                sc.nextLine();
                                Localidad localidad=new Localidad(nombreL,poblacion);
                                municipio.add(localidad);
                            }
                        } while (!nombreL.equals(""));
                    provincia.add(municipio);
                    }
                } while (!nombreM.equals(""));
            p.add(provincia);
            }
        }
    while (!nombreP.equals(""));

    }
    private void imprimir(){

        System.out.println("Opciones:\n 0.Cerrar\n 1.Listar provincias\n 2.Annadir Provincia\n 3.Annadir Municipio\n 4.Annadir Localidad \n 5.Leer");
    }
}
