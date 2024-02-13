
package activity4;


//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.text.ParseException;
import java.util.Scanner;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.io.*;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class alquilerAmarre {
    double valorTotalFactura; 
    String nombre;
    String fechaInicial;
    String fechaFinal;
    String posicionAmarre;
    String matriculaBarco;
    double eslora;
    int añoFabricacion;
    
    
    alquilerAmarre(String nombre, String fechaInicial, String fechaFinal, String posicionAmarre, String matriculaBarco, double eslora, int añoFabricacion){
    
        this.nombre=nombre;
        this.fechaInicial=fechaInicial;
        this.fechaFinal=fechaFinal;
        this.posicionAmarre=posicionAmarre;
        this.matriculaBarco=matriculaBarco;
        this.eslora=eslora;
        this.añoFabricacion=añoFabricacion;
    
    }
    
    
    public static void main(String args[]) throws IOException{
        
        
        Scanner sc=new Scanner(System.in);
        BufferedReader fch=new BufferedReader(new InputStreamReader(System.in));
        
        
        System.out.println("Ingrese el Nombre completo del Cliente: ");
        String nombre=sc.next();
        
        System.out.println("Ingrese la fecha de Salida (en formato YYYY-MM-DD): ");
        String fechaInicial=fch.readLine();
        LocalDate fecha_Inicial=LocalDate.parse(fechaInicial);
        
            System.out.println("Ingrese la fecha de Llegada (en formato YYYY-MM-DD): ");
        String fechaFinal=fch.readLine();
        LocalDate fecha_Final=LocalDate.parse(fechaFinal);
        
        System.out.println("Ingrese la posicion del amarre: ");
        String posicionAmarre=sc.next();
        
        System.out.println("Ingrese la matricula del barco: ");
        String matriculaBarco=sc.next();
        
        System.out.println("Ingrese el Eslora en metros: ");
        int esloraBarco=sc.nextInt();
        
        System.out.println("Ingrese el año de fabricación del barco: ");
        int añoFabricacion=sc.nextInt();
        
        
        alquilerAmarre alquiler=new alquilerAmarre(nombre,fechaInicial,fechaFinal,posicionAmarre,matriculaBarco,esloraBarco,añoFabricacion);
        //double total=calcularCosto();
        
       long diferenciaDias = ChronoUnit.DAYS.between(fecha_Inicial, fecha_Final);

        double costoAlquiler =diferenciaDias * 25000;
        double costoImpuestos=(25000*0.18)*diferenciaDias;
        double costoTotal=costoAlquiler+costoImpuestos;
    
        //Imprimir factura
        System.out.println("_____________________________");
    
        System.out.println("Factura a pagar");
        System.out.println("==================");
        System.out.println("Cliente: "+ nombre);
        System.out.println("Fecha de salida: "+ fechaInicial);
        System.out.println("Fecha de llegada: "+ fechaFinal);
        System.out.println("Matricula de Barco: "+matriculaBarco);
        System.out.println("Posicion de Amarre: "+ posicionAmarre);
        System.out.println("Eslora: "+ esloraBarco+"mtrs");
        System.out.println("Año de fabricacion del barco: "+ añoFabricacion);
        System.out.println("==================");
        System.out.println("Valor Factura: $"+costoTotal);
        
        
    
    
        
    
    }//cierre main

//public double calcularCosto(alquilerAmarre alquiler) {
    
    
    
    
    //return costoTotal;
//} //cierrecalcularFactura
    
}//Final class
