package org.victorcm.tutorial2627;

import java.util.Scanner;

public class CalculadoraAvanzada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero(scanner, "Elige una opción: ");

            switch (opcion) {
                case 1 -> {
                    double a = leerDouble(scanner, "Introduce el primer número: ");
                    double b = leerDouble(scanner, "Introduce el segundo número: ");
                    System.out.println("Resultado: " + (a + b));
                }
                case 2 -> {
                    double a = leerDouble(scanner, "Introduce el primer número: ");
                    double b = leerDouble(scanner, "Introduce el segundo número: ");
                    System.out.println("Resultado: " + (a - b));
                }
                case 3 -> {
                    double a = leerDouble(scanner, "Introduce el primer número: ");
                    double b = leerDouble(scanner, "Introduce el segundo número: ");
                    System.out.println("Resultado: " + (a * b));
                }
                case 4 -> {
                    double a = leerDouble(scanner, "Introduce el dividendo: ");
                    double b = leerDouble(scanner, "Introduce el divisor: ");
                    if (b == 0) {
                        System.out.println("Error: no se puede dividir entre cero.");
                    } else {
                        System.out.println("Resultado: " + (a / b));
                    }
                }
                case 5 -> {
                    double n = leerDouble(scanner, "Introduce un número: ");
                    System.out.println("El cuadrado es: " + (n * n));
                }
                case 6 -> {
                    int n = leerEntero(scanner, "Introduce un número entero no negativo: ");
                    if (n < 0) {
                        System.out.println("Error: el factorial no está definido para negativos.");
                    } else {
                        System.out.println("El factorial de " + n + " es: " + factorial(n));
                    }
                }
                case 7 -> {
                    int n = leerEntero(scanner, "Introduce un número entero: ");
                    System.out.println(n + (esPrimo(n) ? " es primo." : " no es primo."));
                }
                case 8 -> {
                    int n = leerEntero(scanner, "Introduce un número entero: ");
                    System.out.println(n + (n % 2 == 0 ? " es par." : " es impar."));
                }
                case 9 -> {
                    int n = leerEntero(scanner, "Introduce el número para su tabla de multiplicar: ");
                    mostrarTablaMultiplicar(n);
                }
                case 0 -> {
                    salir = true;
                    System.out.println("¡Hasta luego!");
                }
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("=== Calculadora Aritmética Avanzada ===");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Número al cuadrado");
        System.out.println("6. Factorial");
        System.out.println("7. Comprobar si es primo");
        System.out.println("8. Comprobar si es par o impar");
        System.out.println("9. Tabla de multiplicar");
        System.out.println("0. Salir");
    }

    private static long factorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    private static boolean esPrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void mostrarTablaMultiplicar(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Introduce un número entero.");
            }
        }
    }

    private static double leerDouble(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                return Double.parseDouble(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Introduce un número.");
            }
        }
    }
}
