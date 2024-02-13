
package activity4;

import java.util.Scanner;

public class matricula {
    static Scanner sc =new Scanner (System.in);
    
    String nombres;
    String apellido;
    String documento;
    String direccion;
    String telefono;
    boolean enLinea; 
    int semestre;
    
    int opcion;
    
    matricula(String nombres,String apellido,String documento,String direccion,String telefono,boolean enLinea,int semestre){
        
        this.nombres=nombres;
        this.apellido=apellido;
        this.documento=documento;
        this.direccion=direccion;
        this.telefono=telefono;
        this.enLinea=enLinea;
        this.semestre=semestre;
    
    }//cierre de cosntructor
    //matricula(int opcion){
       // this.opcion=opcion;
    //}//cierre de cosntructor
    
    public static void main(String args[]){
        
        
        //Opcion de para que escoja carrera
        System.out.println("Bienvenidos");
        System.out.println("");
        System.out.println("Sellecione una Carrera");
        System.out.println("");
        System.out.println("1. Ingeniera de sistemas");
        System.out.println("2. Ingeniera de quimica");
        System.out.println("3. Arquelogía");
        
        int opcion= sc.nextInt();
        
        //matricula opcionEstudiante =new matricula(opcion);
        
        sc.nextLine(); 
        
        //Ingresar datos estudiante
        System.out.println("Nombres: "); 
        String nombre= sc.next();
        
        System.out.println("Apellidos: ");
        String apellidos=sc.next();
        
        System.out.println("ID: ");
        String documento=sc.next();
        
        System.out.println("Dirección: ");
        String direccion=sc.next();
        
        System.out.println("Telefono: ");
        String telefono=sc.next();
        
        System.out.println("Estudia en linea(false/true):  ");
        boolean onLine=sc.nextBoolean();
        
        System.out.println("Semestre al que ingresa: ");
        int semestre=sc.nextInt();
        
        
    
        matricula estudiante = new matricula(nombre,apellidos,documento,direccion,telefono,onLine,semestre);  
        
        double valorMatricula=calcularCostoMatricula(estudiante);
        
        // Imprimir recibo de inscripción
        System.out.println("Recibo de Inscripción:");
        System.out.println("____________________________");
        System.out.println("Estudiante: " + estudiante.nombres + " " + estudiante.apellido);
        System.out.println("Carrera: " + carrera(opcion));
        System.out.println("Monto a pagar: $" + valorMatricula);
        System.out.println("======================================");
        
        
        
    }//cierre de metodo main
    
    public static double calcularCostoMatricula(matricula estudiante){
        double matriculaCostoTotal;
        double matriculaCosto=1500;
        double costoCreditos=0; 
        
        
        
        
        if(estudiante.semestre>4){
            matriculaCosto=1500+(1500*0.05);
        }//cierre if
        
        if(estudiante.enLinea=true){
           System.out.println("Cantidad de materia perdidas: ");
           int materiasPerdidas = sc.nextInt();
           if(estudiante.semestre<4){
               costoCreditos=materiasPerdidas*20;
           }else if(estudiante.semestre>3&&estudiante.semestre<7){
               costoCreditos=materiasPerdidas*25;
           }else{
               costoCreditos=materiasPerdidas*30;
           }//cierre if
        
        }//cierre if
        matriculaCostoTotal=matriculaCosto+costoCreditos;
        
        return matriculaCostoTotal;
    }// cierre de costoMatricula
    
    public static String carrera(int opcion){
    
        return switch (opcion) {
            case 1 -> "Ingeniería de Sistemas";
            case 2 -> "Ingeniera de quimica";
            case 3 -> "Arquelogía";
            default -> "Opcion no valida";
        };
    }//cierre de carrera
        
        
    

}//cierre de clase
