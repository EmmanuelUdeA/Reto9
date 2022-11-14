package reto091;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {

    final private Charset charset = Charset.forName("UTF-8");
    final private Path file = Paths.get("C:\\Users\\Administrador\\Desktop\\Alejandro\\ETH-USD.csv");
    final private Path destino = Paths.get("C:\\Users\\Administrador\\Desktop\\Alejandro\\Resultado.csv");

    public double volumenAlto;
    public double volumenBajo;

    public String fechaAlto;
    public String fechaBajo;

    public double desviacionEstandar;
    public double mediaPfrecioCierre;

    public void Leer() {
// inicializacion de variables
        String line = null;
        String[] palabras;
        String concepto;
        String fecha;
        double auxVolumenAlto = 0;
        double auxVolumenBajo = 99999999999999.99;
        ArrayList<Double> precioCierre = new ArrayList<>();

        boolean bandera = false;

        try ( BufferedWriter writer = Files.newBufferedWriter(destino, charset)) {
            writer.write("FECHA\t\tAPERTURA\n\n");
            try ( BufferedReader reader = Files.newBufferedReader(file, charset)) {

                while ((line = reader.readLine()) != null) {

                    if (bandera) {

                        //System.out.println(line);
                        // Se extraen todas las palabras de cada linea
                        palabras = line.split(",");

                        if (Double.parseDouble(palabras[1]) < 1200) {
                            concepto = "MUY BAJO";
                        } else if (Double.parseDouble(palabras[1]) >= 1200 && Double.parseDouble(palabras[1]) < 2100) {
                            concepto = "BAJO";
                        } else if (Double.parseDouble(palabras[1]) >= 2100 && Double.parseDouble(palabras[1]) < 3100) {
                            concepto = "MEDIO";
                        } else if (Double.parseDouble(palabras[1]) >= 3100 && Double.parseDouble(palabras[1]) < 4600) {
                            concepto = "ALTO";
                        } else {
                            concepto = "MUY ALTO";
                        }
                        concepto = concepto + "\n";
                        fecha = palabras[0] + "\t";

                        precioCierre.add(Double.parseDouble(palabras[2]));

                        if (Double.parseDouble(palabras[6]) > auxVolumenAlto) {
                            auxVolumenAlto = Double.parseDouble(palabras[6]);
                            this.setVolumenAlto(auxVolumenAlto);
                            this.setFechaAlto(palabras[0]);
                        }

                        if (Double.parseDouble(palabras[6]) < auxVolumenBajo) {
                            auxVolumenBajo = Double.parseDouble(palabras[6]);
                            this.setVolumenBajo(auxVolumenBajo);
                            this.setFechaBajo(palabras[0]);
                        }
// Se escribe dentro del archivo lo que se necesita

                        writer.write(fecha, 0, fecha.length());
                        writer.write(concepto, 0, concepto.length());
                    }

                    bandera = true;

                }
            } catch (IOException e) {
                System.out.println("Hubo un error al acceder el archivo: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Hubo un error al acceder el archivo: " + e.getMessage());
        }
        
        // calculo de la desviacion estandar y la media

        this.setDesviacionEstandar(this.calcularSD(precioCierre, this.calcularMedia(precioCierre)));
        this.setMediaPfrecioCierre(this.calcularMedia(precioCierre));

    }

    private double calcularSD(ArrayList<Double> precioCierre, double media) {
        double acumulador = 0;
        double s;
        for (int i = 0; i < precioCierre.size(); i++) {
            acumulador = acumulador + Math.pow((precioCierre.get(i) - media), 2);
        }
        s = Math.sqrt(acumulador / (precioCierre.size() - 1));
        return s;
    }

    private double calcularMedia(ArrayList<Double> precioCierre) {
        double sumador = 0;
        for (int i = 0; i < precioCierre.size(); i++) {
            sumador = sumador + precioCierre.get(i);
        }
        return sumador / precioCierre.size();
    }

    public double getVolumenAlto() {
        return volumenAlto;
    }

    public void setVolumenAlto(double volumenAlto) {
        this.volumenAlto = volumenAlto;
    }

    public double getVolumenBajo() {
        return volumenBajo;
    }

    public void setVolumenBajo(double volumenBajo) {
        this.volumenBajo = volumenBajo;
    }

    public String getFechaAlto() {
        return fechaAlto;
    }

    public void setFechaAlto(String fechaAlto) {
        this.fechaAlto = fechaAlto;
    }

    public String getFechaBajo() {
        return fechaBajo;
    }

    public void setFechaBajo(String fechaBajo) {
        this.fechaBajo = fechaBajo;
    }

    public double getDesviacionEstandar() {
        return desviacionEstandar;
    }

    public void setDesviacionEstandar(double desviacionEstandar) {
        this.desviacionEstandar = desviacionEstandar;
    }

    public double getMediaPfrecioCierre() {
        return mediaPfrecioCierre;
    }

    public void setMediaPfrecioCierre(double mediaPfrecioCierre) {
        this.mediaPfrecioCierre = mediaPfrecioCierre;
    }

}

////////////////////////////////////////////////////////////////////////////////////////

