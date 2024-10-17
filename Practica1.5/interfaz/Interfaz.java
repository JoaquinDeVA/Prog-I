package interfaz;

import java.io.ObjectInputStream;
import java.io.FileInputStream;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

import java.util.ArrayList;
import dominio.Provincia;

public class Interfaz {
 
    private ArrayList<Provincia> provincias;

    public Interfaz(){

        LeerDatos();
    }
    public void InterfazUsuario(){


        
    }

    private void GuardarDatos(){

        try{
            
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("PROVINCIAS.dat"));
            oo.writeObject(provincias);
            oo.close();
        } catch(Exception e){System.out.print("Error al guardar los datos");}

    }
    private void LeerDatos(){

        try{
            
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("PROVINCIAS.dat"));
            provincias = (ArrayList<Provincia>) oi.readObject();
            oi.close();
        } catch(Exception e){provincias = new ArrayList<>();}
    }
}
