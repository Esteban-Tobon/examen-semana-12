package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] nombres = {"Sara Tobon", "Maria Isabel", "Juan Esteban"};
        double[] saldos = {300, 100, 200};

        Scanner scanner = new Scanner(System.in);

        int cuentaSeleccionada = seleccionarCuenta(nombres, scanner);
        System.out.println("Seleccionaste la cuenta: " + nombres[cuentaSeleccionada]);

        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            int opcion = obtenerOpcionValida(scanner);

            switch (opcion) {
                case 1:
                    depositar(saldos, cuentaSeleccionada, scanner);
                    break;
                case 2:
                    retirar(saldos, cuentaSeleccionada, scanner);
                    break;
                case 3:
                    consultarSaldo(saldos, cuentaSeleccionada);
                    break;
                case 4:
                    System.out.println("Gracias por usar el Banco.");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("     Menú    ");
        System.out.println("1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Consultar Saldo");
        System.out.println("4. Salir");
        System.out.println();
    }

    public static int seleccionarCuenta(String[] nombres, Scanner scanner) {
        System.out.println("Seleccione una cuenta:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(i + ". " + nombres[i]);
        }
        return obtenerIndiceValido(nombres.length, scanner);
    }

    public static void depositar(double[] saldos, int cuentaSeleccionada, Scanner scanner) {
        double cantidad = obtenerCantidadValida(scanner);
        if (cantidad >= 0) {
            saldos[cuentaSeleccionada] += cantidad;
            System.out.println("Éxito. Saldo actual: " + saldos[cuentaSeleccionada]);
            System.out.println();
        }
    }

    public static void retirar(double[] saldos, int cuentaSeleccionada, Scanner scanner) {
        double cantidad = obtenerCantidadValida(scanner);
        if (cantidad >= 0) {
            if (saldos[cuentaSeleccionada] >= cantidad) {
                saldos[cuentaSeleccionada] -= cantidad;
                System.out.println("Retiro realizado con éxito. Saldo actual: " + saldos[cuentaSeleccionada]);
            } else {
                System.out.println("Saldo insuficiente.");
            }
            System.out.println();
        }
    }

    public static void consultarSaldo(double[] saldos, int cuentaSeleccionada) {
        System.out.println("Saldo actual: " + saldos[cuentaSeleccionada]);
        System.out.println();
    }

    public static int obtenerOpcionValida(Scanner scanner) {
        while (true) {
            try {
                int opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 4) {
                    return opcion;
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número válido.");
                scanner.next(); // Limpiar entrada inválida
            }
        }
    }

    public static int obtenerIndiceValido(int max, Scanner scanner) {
        while (true) {
            try {
                int indice = scanner.nextInt();
                if (indice >= 0 && indice < max) {
                    return indice;
                } else {
                    System.out.println("Índice inválido. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número válido.");
                scanner.next(); // Limpiar entrada inválida
            }
        }
    }

    public static double obtenerCantidadValida(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Ingrese cantidad (mayor o igual a 0): ");
                double cantidad = scanner.nextDouble();
                if (cantidad >= 0) {
                    return cantidad;
                } else {
                    System.out.println("Cantidad inválida. Debe ser mayor o igual a 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next(); // Limpiar entrada inválida
            }
        }
    }
}
