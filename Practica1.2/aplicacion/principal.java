package aplicacion;
import presentacion.*;

public class principal {
    
    public static void main(String[] args){
       
        String [] datosMostrar = new String[1];
        datosMostrar[0] = args[0];
        if(datosMostrar[0].equalsIgnoreCase("mostrar")){
           
            InterfazUsuario.ejecutar(datosMostrar);
        }else{
            InterfazUsuario.ejecutar(args);
        }
    }
}

