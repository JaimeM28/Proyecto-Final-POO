
import Usuarios.Administrador;

public class Biblioteca {
    public static void main(String[] args) {
            
        
        System.out.println("\t-------------------------");
        System.out.println("\t|                        |");
        System.out.println("\t|  B I E N V E N I D O   |");
        System.out.println("\t|                        |");
        System.out.println("\t-------------------------");


        Administrador prueba = new Administrador("Jaime", "hola123", "Jaime", "Miranda" ,18);
        prueba.registrarLibro();
    }
}
