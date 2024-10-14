package aplicacion;
import presentacion.*;

public class Principal {
    
    public static void main(String[] args){
       
        String[] instr;
        InterfazUsuario iu = new InterfazUsuario();
        do{
            instr=iu.leerInstruccion();
            
        }while (iu.ejecutar(instr));
    }
}

