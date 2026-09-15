import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalculadoraDias {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate fechaInicio = leerFecha(scanner, "Introduce la fecha inicial (AAAA-MM-DD): ");
        LocalDate fechaFin = leerFecha(scanner, "Introduce la fecha final (AAAA-MM-DD): ");

        long diasEntreFechas = ChronoUnit.DAYS.between(fechaInicio, fechaFin);

        System.out.println("Días entre " + fechaInicio + " y " + fechaFin + ": " + Math.abs(diasEntreFechas));

        scanner.close();
    }

    private static LocalDate leerFecha(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                return LocalDate.parse(entrada);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Usa el formato AAAA-MM-DD, por ejemplo 2026-09-15.");
            }
        }
    }
}
