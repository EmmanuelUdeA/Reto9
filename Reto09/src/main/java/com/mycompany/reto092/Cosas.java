
package com.mycompany.reto092;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cosas {
    
    
    public static double scanDouble(String mensaje) {   //ESCANER PARA INGRESAR DOUBLE
        System.out.println(mensaje);
        return new Scanner(System.in).nextDouble();
    }

    public static String scanString(String mensaje) {
        System.out.println(mensaje);
        return new Scanner(System.in).nextLine(); //ESCANER PARA INGRESAR STRING
    }
    
    public static void raices(List<Double> doubles) {
        if (!doubles.isEmpty()) {
            List<Double> raices = doubles.stream().map(n -> Math.sqrt(n)).collect(Collectors.toList());
            System.out.println("Las raices son las siguientes: ");
            raices.stream().forEach(System.out::println);
        } else {
            System.out.println("No hay elementos en la lista.");
        }
    }
    public static void cadenas(String palabras){
      List<String> palabrasEncontradas= Arrays.asList(palabras.split(" ")).stream()
       .filter(c -> c.length() > 5).collect(Collectors.toList());
      
        if(!palabrasEncontradas.isEmpty()){
        System.out.println("Las palabras que son mayores a 5 caracteres son: ");
        palabrasEncontradas.forEach(System.out::println);
        }else{
            System.out.println("No se registraron palabras mayores a 5 caracteres.");
        }
    }
    




}
    

