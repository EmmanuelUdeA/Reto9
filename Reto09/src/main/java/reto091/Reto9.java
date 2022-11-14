
package reto091;
//     Emmanuel Bustamante Valbuena
//     Alejandro Becerra Acevedo

public class Reto9 {

    public static void main(String[] args) {
            Archivo datos = new Archivo();
            datos.Leer();
            System.out.println("");
            System.out.println("Desviacion estandar de los precios de cierre es: " + datos.getDesviacionEstandar());
            System.out.println("La media de los precios de cierre es: " + datos.getMediaPfrecioCierre());
            System.out.println("");
            
            System.out.println("El volumen transado más alto de Ethereum durante el año es: " + datos.getVolumenAlto());
            System.out.println("En la fecha: " + datos.getFechaAlto());
            
            System.out.println("El volumen transado más bajo de Ethereum durante el año es: " + datos.getVolumenBajo());
            System.out.println("En la fecha: " + datos.getFechaBajo());
    }
    
}
