package com.example;

import java.util.Scanner;

public class banco {

    public static void main(String[] args) {
        String[] nombres = {"---","Sara Tobon", "Maria Isabel", "Juan Esteban"};
        double[] saldos = { 200, 100 , 200 , 300};

        Scanner scanner = new Scanner(System.in);


        int cuentaSeleccionada = seleccionarCuenta(nombres);
        System.out.println("seleccionaste la cuenta: " + nombres[cuentaSeleccionada]);
        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            System.out.println("");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1: 
                    depositar(nombres, saldos, scanner, opcion);
                    break;
                case 2: 
                    retirar(nombres, saldos, scanner, opcion);
                    break;
                case 3: 
                consultarSaldo(nombres, saldos, opcion);
                    break;
                case 4:
                    System.out.println("Gracias por usar el Banco.");
                    System.exit(0);
                default:
                    System.out.println("Opción invlida. Intente de nuevo.");
                    System.out.println("");
            }
        }
    }

    // Menu principal.
    public static void mostrarMenu() {
        System.out.println("     Menu    ");
        System.out.println("1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Consultar Saldo");
        System.out.println("4. Salir");
        System.out.println("");
        
    }

    
    // Se escoge uno de los nombres que va ralcionado a una cuenta
    public static int seleccionarCuenta(String[] nombres) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una cuenta:");
        for (int i = 1; i < nombres.length; i++) {
            System.out.println(i + ". " + nombres[i]);
        }
        System.out.print("Ingrese el numero relacionaco con el nombre de la cuenta: ");
        System.out.println("");
        int indice = scanner.nextInt();
        while (indice < 0 || indice >= nombres.length) {
            System.out.println("Intente de nuevo.");
            System.out.print("Ingrese el numero relacionaco con el nombre de la cuenta: ");
            indice = scanner.nextInt();
            System.out.println("");
        }
        return indice;
        
    }
    
    // Metodo para depositar.
    public static void depositar(String[] nombres, double[] saldos, Scanner scanner, int indice) {
        
        System.out.print("Ingrese la cantidad a depositar: ");
        double cantidad = scanner.nextDouble();
        saldos[indice] += cantidad;
        System.out.println("Exito. Saldo actual: " + saldos[indice]);
        System.out.println("");
    }


    // Metodo para retirar
    public static void retirar(String[] nombres, double[] saldos, Scanner scanner, int indice) {
       
        System.out.print("Ingrese la cantidad a retirar: ");
        System.out.println("");
        double cantidad = scanner.nextDouble();
        if (saldos[indice] >= cantidad) {
            saldos[indice] -= cantidad;
            System.out.println("Retiro realizado con exito. Saldo actual: " + saldos[indice]);
        } else {
            System.out.println("Saldo insuficiente.");
            System.out.println("");
        }
    }

    // Metodo para consultar saldo.
    public static void consultarSaldo(String[] nombres, double[] saldos, int indice) {
       
        System.out.println("Saldo actual: " + saldos[indice]);
        
    }
}
