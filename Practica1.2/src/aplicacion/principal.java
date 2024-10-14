package aplicacion;
import presentacion.*;

public class principal {
    
    public static void main(String[] args){
       
        String[] instr;
        InterfazUsuario iu = new InterfazUsuario();
        iu.ejecutar(args);
        do{
           
            instr=iu.leerInstruccion();
            
        }while (iu.ejecutar(instr));
    }
}

