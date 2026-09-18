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

## CalculadoraAvanzada.java

Calculadora aritmética con menú interactivo por consola.

El archivo [CalculadoraAvanzada.java](CalculadoraAvanzada.java) muestra un menú con las operaciones suma, resta, multiplicación, división, número al cuadrado, factorial, comprobación de número primo, comprobación de par o impar, y tabla de multiplicar. El usuario elige una opción escribiendo su número y el programa pide los datos necesarios, valida que sean números correctos y muestra el resultado. El menú se repite hasta que se elige la opción de salir (`0`).

### Cómo ejecutarlo

```bash
javac CalculadoraAvanzada.java
java CalculadoraAvanzada
```

## MensajePersonal.java

Programa que construye un mensaje personalizado a partir de datos introducidos por el usuario.

El archivo [MensajePersonal.java](MensajePersonal.java) pide por consola el nombre, la edad y el peso, validando que la edad y el peso sean números correctos, y muestra un mensaje que combina los tres datos.

### Cómo ejecutarlo

```bash
javac MensajePersonal.java
java MensajePersonal
```

## CalculadoraCumpleanos.java

Programa que calcula la edad y el tiempo restante hasta el próximo cumpleaños.

El archivo [CalculadoraCumpleanos.java](CalculadoraCumpleanos.java) pide por consola el nombre y la fecha de nacimiento en formato `DD/MM/AAAA` (por ejemplo `15/09/2000`), usando `LocalDate` y `DateTimeFormatter` de `java.time`. Si el formato introducido no es válido, vuelve a pedir la fecha hasta que sea correcto. Con la fecha actual del sistema, calcula la edad actual, los días que faltan para el próximo cumpleaños y la edad que se cumplirá. Si la fecha de nacimiento coincide con la fecha actual, muestra únicamente un mensaje de felicitación con la edad que se cumple ese día.

### Cómo ejecutarlo

```bash
javac CalculadoraCumpleanos.java
java CalculadoraCumpleanos
```
