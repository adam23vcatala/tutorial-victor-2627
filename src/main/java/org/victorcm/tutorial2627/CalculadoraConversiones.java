package org.victorcm.tutorial2627;

import java.util.Locale;
import java.util.Scanner;

public class CalculadoraConversiones {

    // Unidades de longitud y su equivalencia en metros.
    private static final String[] UNIDADES_LONGITUD = {
            "Milímetro (mm)", "Centímetro (cm)", "Metro (m)", "Kilómetro (km)",
            "Pulgada (in)", "Pie (ft)", "Yarda (yd)", "Milla (mi)", "Milla náutica (nmi)"
    };
    private static final double[] FACTORES_LONGITUD = {
            0.001, 0.01, 1, 1000,
            0.0254, 0.3048, 0.9144, 1609.344, 1852
    };

    // Unidades de masa y su equivalencia en gramos.
    private static final String[] UNIDADES_MASA = {
            "Miligramo (mg)", "Gramo (g)", "Kilogramo (kg)", "Tonelada (t)",
            "Onza (oz)", "Libra (lb)", "Stone (st)"
    };
    private static final double[] FACTORES_MASA = {
            0.001, 1, 1000, 1_000_000,
            28.349523125, 453.59237, 6350.29318
    };

    // Unidades de volumen y su equivalencia en litros.
    private static final String[] UNIDADES_VOLUMEN = {
            "Mililitro (ml)", "Litro (l)", "Metro cúbico (m³)",
            "Onza líquida US (fl oz)", "Taza US (cup)", "Pinta US (pt)",
            "Galón US (gal)", "Galón imperial (gal UK)"
    };
    private static final double[] FACTORES_VOLUMEN = {
            0.001, 1, 1000,
            0.0295735295625, 0.2365882365, 0.473176473,
            3.785411784, 4.54609
    };

    // Unidades de velocidad y su equivalencia en metros por segundo.
    private static final String[] UNIDADES_VELOCIDAD = {
            "Metro por segundo (m/s)", "Kilómetro por hora (km/h)",
            "Milla por hora (mph)", "Nudo (kn)", "Pie por segundo (ft/s)"
    };
    private static final double[] FACTORES_VELOCIDAD = {
            1, 1.0 / 3.6,
            0.44704, 1852.0 / 3600.0, 0.3048
    };

    private static final String[] UNIDADES_TEMPERATURA = {
            "Grado Celsius (°C)", "Grado Fahrenheit (°F)", "Kelvin (K)"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero(scanner, "Elige una opción: ");

            switch (opcion) {
                case 1 -> convertirPorFactor(scanner, "Longitud", UNIDADES_LONGITUD, FACTORES_LONGITUD);
                case 2 -> convertirPorFactor(scanner, "Masa", UNIDADES_MASA, FACTORES_MASA);
                case 3 -> convertirPorFactor(scanner, "Volumen", UNIDADES_VOLUMEN, FACTORES_VOLUMEN);
                case 4 -> convertirPorFactor(scanner, "Velocidad", UNIDADES_VELOCIDAD, FACTORES_VELOCIDAD);
                case 5 -> convertirTemperatura(scanner);
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
        System.out.println("=== Calculadora de Conversiones (métrico e imperial) ===");
        System.out.println("1. Longitud (mm, cm, m, km, in, ft, yd, mi, nmi)");
        System.out.println("2. Masa (mg, g, kg, t, oz, lb, st)");
        System.out.println("3. Volumen (ml, l, m³, fl oz, cup, pt, gal)");
        System.out.println("4. Velocidad (m/s, km/h, mph, kn, ft/s)");
        System.out.println("5. Temperatura (°C, °F, K)");
        System.out.println("0. Salir");
    }

    private static void convertirPorFactor(Scanner scanner, String categoria, String[] unidades, double[] factores) {
        System.out.println();
        System.out.println("--- " + categoria + " ---");
        mostrarUnidades(unidades);

        int origen = leerUnidad(scanner, unidades, "Unidad de origen: ");
        int destino = leerUnidad(scanner, unidades, "Unidad de destino: ");
        double valor = leerDouble(scanner, "Cantidad a convertir: ");

        // Se pasa la cantidad a la unidad base de la categoría y de ahí a la unidad de destino.
        double resultado = valor * factores[origen] / factores[destino];

        mostrarResultado(valor, unidades[origen], resultado, unidades[destino]);
    }

    private static void convertirTemperatura(Scanner scanner) {
        System.out.println();
        System.out.println("--- Temperatura ---");
        mostrarUnidades(UNIDADES_TEMPERATURA);

        int origen = leerUnidad(scanner, UNIDADES_TEMPERATURA, "Unidad de origen: ");
        int destino = leerUnidad(scanner, UNIDADES_TEMPERATURA, "Unidad de destino: ");
        double valor = leerDouble(scanner, "Temperatura a convertir: ");

        // Las escalas de temperatura no son proporcionales, así que se usa Celsius como escala intermedia.
        double celsius = switch (origen) {
            case 1 -> (valor - 32) * 5 / 9;
            case 2 -> valor - 273.15;
            default -> valor;
        };
        double resultado = switch (destino) {
            case 1 -> celsius * 9 / 5 + 32;
            case 2 -> celsius + 273.15;
            default -> celsius;
        };

        mostrarResultado(valor, UNIDADES_TEMPERATURA[origen], resultado, UNIDADES_TEMPERATURA[destino]);
    }

    private static void mostrarUnidades(String[] unidades) {
        for (int i = 0; i < unidades.length; i++) {
            System.out.println((i + 1) + ". " + unidades[i]);
        }
    }

    private static void mostrarResultado(double valor, String unidadOrigen, double resultado, String unidadDestino) {
        System.out.println(formatear(valor) + " " + unidadOrigen + " = " + formatear(resultado) + " " + unidadDestino);
    }

    private static int leerUnidad(Scanner scanner, String[] unidades, String mensaje) {
        while (true) {
            int opcion = leerEntero(scanner, mensaje);
            if (opcion >= 1 && opcion <= unidades.length) {
                return opcion - 1;
            }
            System.out.println("Unidad no válida. Elige un número entre 1 y " + unidades.length + ".");
        }
    }

    private static String formatear(double numero) {
        // Muestra hasta 6 decimales con punto decimal, sin ceros innecesarios al final.
        String texto = String.format(Locale.US, "%.6f", numero);
        if (texto.contains(".")) {
            texto = texto.replaceAll("0+$", "").replaceAll("[.]$", "");
        }
        return texto;
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
