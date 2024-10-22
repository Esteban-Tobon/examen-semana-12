package com.example;

import java.util.Scanner;

public class banco {

    public static void main(String[] args) {
        String[] nombres = {"Sara Tobon", "Maria Isabel", "Juan Esteban"};
        double[] saldos = { 0, 0 , 0 };

        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1: 
                    depositar(nombres, saldos, scanner);
                    break;
                case 2: 
                    retirar(nombres, saldos, scanner);
                    break;
                case 3: 
                    consultarSaldo(nombres, saldos, scanner);
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el Banco Simple!");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
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
}
