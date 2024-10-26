import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NewCitizen{
    /**
     * 
     * Ejercicio #1
        Haga una clase NewCitizen, que lea (1) Primer Nombre, (2) Segundo Nombre, (3) Apellido de Padre, (4) Apellido de Madre y (5) Fecha de nacimiento en el formato: dd-mm-aaaa (Ejemplo: 18-02-1990). Despues debe generar un String representando el id del ciudadano el cual tiene formato -. Y despues debe desplegar la informacion de esta forma:

        Nombre: primerapellido_leido segudoapellido_leido, primernombre_leido segundonombre_leido
        Nacimiento: fecha_de_nacimiento_leida
        Iniciales: iniciales_del_ciudadano
        ID: iniciales-anio_de_nacimiento

        De tal forma que si por ejemplo, el usuario ingresara los siguientes datos: Jorge, Estuardo, Molina, Perez, y 18-02-1990. Asumiendo que ingreso todo correctamente, usted deberia desplegar:
        Nombre: Molina Perez, Jorge Estuardo
        Nacimiento: 18-02-1990
        Iniciales: JEMP
        ID: JEMP-1990
     */

    private String nombre;
    private String segundoNombre;
    private String apellidoPadre;
    private String apellidoMadre;
    private String fechaNacimiento;
    private static Scanner escaner = new Scanner(System.in);
    public static void main(String [] args){
        
        System.out.println("Primer nombre: ");
        String primerNombre = escaner.nextLine();
        System.out.println("Segundo nombre: ");
        String segundoNombre = escaner.nextLine();
        System.out.println("Primer apellido: ");
        String primerApellido = escaner.nextLine();
        System.out.println("Segundo apellido: ");
        String segundoApellido = escaner.nextLine();
        String fechaNacimiento="";
        while (true){
            System.out.println("Fecha de nacimiento: ");
            fechaNacimiento = escaner.nextLine();
            Pattern pat = Pattern.compile("[0-9]{2}-[0-9]{2}-[0-9]{4}");
            Matcher mat = pat.matcher(fechaNacimiento);
            if(mat.matches()){
                break;
            }
        }
        
        System.out.println(" ");
        System.out.println("**********");
        System.out.println("Nombre: "+primerApellido + " "+segundoApellido + ", "+primerNombre+ " "+segundoNombre);
        System.out.println("Nacimiento: "+fechaNacimiento);
        String iniciales = primerNombre.substring(0,1).toUpperCase()+segundoNombre.substring(0,1).toUpperCase()+primerApellido.substring(0,1).toUpperCase()+segundoApellido.substring(0,1).toUpperCase();
        System.out.println("Iniciales: "+iniciales);
        String year = fechaNacimiento.substring(6,fechaNacimiento.length());
        System.out.println("ID:"+iniciales+"-"+year);
    }
}