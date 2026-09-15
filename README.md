# Tutorial de GitHub (2026/2027)
Mi prueba de GitHub (2026.09.15)

## HolaMundo.java

Este repositorio incluye un programa básico en Java para probar que todo funciona correctamente.

El archivo [HolaMundo.java](HolaMundo.java) define una clase llamada `HolaMundo` con un método `main`, que es el punto de entrada que Java ejecuta al iniciar el programa. Dentro de `main`, la instrucción `System.out.println("¡Hola, mundo!");` imprime el texto "¡Hola, mundo!" por consola.

### Cómo ejecutarlo

Con el JDK instalado, desde la terminal en la raíz del repositorio:

```bash
javac HolaMundo.java
java HolaMundo
```

El primer comando compila el código fuente y genera `HolaMundo.class`; el segundo ejecuta el programa compilado.

## CalculadoraDias.java

Programa que calcula el número de días entre dos fechas introducidas por el usuario.

El archivo [CalculadoraDias.java](CalculadoraDias.java) pide por consola una fecha inicial y una fecha final en formato `AAAA-MM-DD` (por ejemplo `2026-09-15`), usando la clase `LocalDate` de `java.time`. Si el formato introducido no es válido, vuelve a pedir la fecha hasta que sea correcto. Una vez leídas ambas fechas, calcula la diferencia en días con `ChronoUnit.DAYS.between(...)` y la muestra por pantalla.

### Cómo ejecutarlo

```bash
javac CalculadoraDias.java
java CalculadoraDias
```

El programa pedirá primero la fecha inicial y después la fecha final, y mostrará el número de días entre ambas.
