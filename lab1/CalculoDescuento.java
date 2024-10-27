import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CalculoDescuento{
    private static Scanner escaner = new Scanner(System.in);

    private static Matcher mat;
    private static Pattern pat;

    /**
     * Ejercicio #2
Escriba un programa llamado CalculoDescuento el cual calcule el descuento sobre una cantidad de dinero en Quetzales, dependiendo de un porcentaje dado. Su programa debe leer del usuario la cantidad de Quetzales, la cual debe de leerse como entero, y el porcentaje de descuento, el cual debe leerse como un numero con punto decimal. Despues de leido, despliegue en pantalla el descuento aplicando el porcentaje a la cantidad de quetzales, y 
el resultado de aplicar el descuento a la cantidad. Ejemplo:

Ingrese monto en quetzales: 185
Ingrese tasa de interes: 10.5
DESCUENTO: 19.42
TOTAL CON DESCUENTO APLICADO: 165.58

El resultado debe ser estar expresado solo con dos cifras significativas despues del punto. Para esto, debe hacer una operacion manual: multiplicar por 10 elevado a la cantidad de cifras significativas, despues truncar (eso lo puede hacer con el metodo Math.floor) y dividir por el mismo numero que multiplico.

     * 
     */



    /**
     * Pedir un numero, sino es de tipo float con un maximo de 2 decimales
     * volver a pedir, si cumple la expresion regular que debe ser un numero
     * float devolver el valor
     */
    public static float valor(String mensaje){
        float resultado=0;
        try{
            while(true){
                System.out.println(mensaje);
                String valor = escaner.nextLine();
                pat = Pattern.compile("[0-9]+[.]{1}[0-9]{1,2}");
                mat = pat.matcher(valor);
                if(mat.matches()){
                    resultado=Float.parseFloat(valor);
                    break;
                }
            }

        }catch(NumberFormatException n){
            System.out.println("Se produjo el siguiente error de tipo NumberFormatException: "+n);
        }

        return resultado;
        
    }

    public static void main(String[] args){
        
        String monto="";
        int montoQuetzales=0;
        while(true){
            System.out.println("Ingrese monto en quetzales: ");
            monto = escaner.nextLine();
            pat = Pattern.compile("[0-9]+");
            mat = pat.matcher(monto);
            if (mat.matches()){
                montoQuetzales=Integer.parseInt(monto);
                break;
            }
        }

        float dato=valor("Ingresa tasa de interes: ");
       
        float division = (dato / 100);
        float descuentoCalculado = (division * montoQuetzales);

        System.out.println("Descuento efectuado: "+(descuentoCalculado));
        System.out.println("Total con descuento aplicado: "+(montoQuetzales-descuentoCalculado));

    }
}