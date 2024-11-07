import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        
        int valor = 0;
        Scanner input = new Scanner(System.in);
        
        valor=input.nextInt();
        
        if(valor>10){
            System.out.println("Es mayor que 10");
        } else {
            System.out.println("Es menor o igual que 10");
        }
        
        System.out.println("Introduzca un numero del 1 al 7");
        valor=input.nextInt();
        
        switch (valor) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;      
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sabado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
        }
    }
}