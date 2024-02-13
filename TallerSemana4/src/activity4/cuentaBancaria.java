
package activity4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class cuentaBancaria {
    String nombres;
    String apellidos;
    int edad;
    String tipoCuenta;
    double saldo;
    int documento;
    int numCuenta;
    public cuentaBancaria(String nombres, String apellidos, int edad, String tipoCuenta, double saldo, int documento,int numCuenta) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.documento=documento;
        this.numCuenta=numCuenta;
    }

    

    // Método para depositar dinero en la cuenta
    public void depositar(double monto) {
        saldo += monto;
    }

    // Método para retirar dinero de la cuenta
    public boolean retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    // Método para obtener el saldo de la cuenta
    public double obtenerSaldo() {
        return saldo;
    }
}

// Clase para manejar las operaciones de la aplicación
class aplicacionCuentaBancaria {
    private List<cuentaBancaria> cuentas;

    public aplicacionCuentaBancaria() {
        this.cuentas = new ArrayList<>();
    }

    // Método para registrar una nueva cuenta bancaria
    public void registrarCuenta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Registro de nueva cuenta bancaria:");
        System.out.println("__________________________________________________________________________");
        System.out.println("Porfavor realizar el ingreso de los datos para poder registrar la cuenta ");
        System.out.println("==========================================================================");
        System.out.print("Nombres: ");
        String nombres = sc.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        System.out.println("Numero de documento");
        int documento=sc.nextInt();
        sc.nextLine(); // Consumir nueva línea pendiente
        System.out.print("Tipo de cuenta (ahorro/corriente): ");
        String tipoCuenta = sc.nextLine();
        System.out.print("Ingrese saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        //Numero de cuenta
        int numCuenta =documento+edad;
        
        cuentaBancaria cuenta = new cuentaBancaria(nombres, apellidos, edad, tipoCuenta, saldoInicial,documento,numCuenta);
        cuentas.add(cuenta);
        System.out.println("¡Cuenta registrada con éxito!");
        System.out.println("¡Su numero de Cuenta es: !"+numCuenta);
    }

    // Método para realizar una transacción en una cuenta bancaria existente
    public void realizarTransaccion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de cuenta: ");
        int numCuenta = scanner.nextInt();

        cuentaBancaria cuenta = obtenerCuentaPorNumero(numCuenta);
        if (cuenta == null) {
            System.out.println("No se encontró la cuenta con el número ingresado.");
            return;
        }

        System.out.println("Tipo de cuenta: " + cuenta.tipoCuenta);
        System.out.println("Saldo actual: " + cuenta.obtenerSaldo());
        System.out.print("Ingrese el monto de la transacción: ");
        double montoTransaccion = scanner.nextDouble();

        if (montoTransaccion > 0) {
            cuenta.depositar(montoTransaccion);
            System.out.println("Transacción exitosa. Nuevo saldo: " + cuenta.obtenerSaldo());
        } else {
            System.out.println("Monto de transacción no válido.");
        }
    }

    // Método para obtener una cuenta bancaria por su número
    private cuentaBancaria obtenerCuentaPorNumero(int numeroCuenta) {
       return cuentas.get(numeroCuenta);
    }

    // Método principal
    public static void main(String[] args) {
        aplicacionCuentaBancaria aplicacion = new aplicacionCuentaBancaria();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar nueva cuenta bancaria");
            System.out.println("2. Realizar transacción");
            System.out.println("3. Salir");
            System.out.print("Ingrese el número de la opción que desee: ");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> aplicacion.registrarCuenta();
                case 2 -> aplicacion.realizarTransaccion();
                case 3 -> {
                    System.out.println("Gracias por utilizar nuestra aplicación.");
                    return;
                }
                default -> System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
    }
} //cierre clase
