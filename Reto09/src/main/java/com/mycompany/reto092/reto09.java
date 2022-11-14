
package com.mycompany.reto092;

import static com.mycompany.reto092.Cosas.cadenas;
import static com.mycompany.reto092.Cosas.raices;
import static com.mycompany.reto092.Cosas.scanDouble;
import static com.mycompany.reto092.Cosas.scanString;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;


/**
 *
 * Emmanuel Bustamante Valbuena
 * Alejandro Becerra Acevedo
 */
public class reto09 {
    
   public static void main(String[] args) {
       //Aqui se deben escribir los numeros que deseen ingresar a la lista para despues ser evaluados 
       List<Double> numeros = new ArrayList(); // SE ESPECIFICA QUE SOLO SEAN DOUBLES
        numeros.add(2.3);
        numeros.add(9.0);
        numeros.add(7.4);
        numeros.add(4.0);
        numeros.add(3.2);
        
        
  double opcion = -1;        
        while (opcion != 0) {
            try {
                opcion = scanDouble("""
                                    
                                    !! SEGUNDA PARTE RETO 9!!
                                    1) RAICES
                                    2) PALABRAS
                                    0) SALIR.
                                    
                                    """);

                switch ((int)opcion) {
                    
                         
                    case 1 -> raices(numeros);
                    case 2 -> cadenas(scanString("Ingrese las palabras que deseas analizar."));
                    default -> System.out.println("Ingrese una opción del menú");
                }
              

            } catch (InputMismatchException e) {
                System.out.println("Ingrese un valor válido por favor. ERROR: " + e.toString());
            }
            catch (NoSuchElementException e){
                System.out.println("No hay estudiantes registrados. ERROR: " + e.getMessage());
            }
        }
    }

}
