package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalculadoraCumpleanos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();

        LocalDate fechaNacimiento = leerFecha(scanner, "Introduce tu fecha de nacimiento (DD/MM/AAAA): ");
        LocalDate hoy = LocalDate.now();

        LocalDate proximoCumple = fechaNacimiento.withYear(hoy.getYear());
        if (proximoCumple.isBefore(hoy)) {
            proximoCumple = proximoCumple.plusYears(1);
        }

        if (proximoCumple.isEqual(hoy)) {
            int edadQueCumple = hoy.getYear() - fechaNacimiento.getYear();
            System.out.println("¡Feliz cumpleaños, " + nombre + "! Hoy cumples " + edadQueCumple + " años.");
        } else {
            int edadActual = hoy.getYear() - fechaNacimiento.getYear() - 1;
            if (!hoy.isBefore(fechaNacimiento.withYear(hoy.getYear()))) {
                edadActual++;
            }
            int edadQueCumplira = proximoCumple.getYear() - fechaNacimiento.getYear();
            long diasFaltantes = ChronoUnit.DAYS.between(hoy, proximoCumple);

            System.out.println("Hola " + nombre + ", tu edad actual es de " + edadActual + " años.");
            System.out.println("Faltan " + diasFaltantes + " días para tu próximo cumpleaños.");
            System.out.println("Cumplirás " + edadQueCumplira + " años.");
        }

        scanner.close();
    }

    private static LocalDate leerFecha(Scanner scanner, String mensaje) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                return LocalDate.parse(entrada.trim(), formato);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Usa el formato DD/MM/AAAA, por ejemplo 15/09/2000.");
            }
        }
    }
}
