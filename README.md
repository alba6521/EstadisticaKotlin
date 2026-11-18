# EstadisticaKotlin

Aplicación de consola en **Kotlin** para trabajar con una colección de 100 números y calcular diferentes medidas estadísticas básicas, como la media, la moda y la desviación típica.

## Objetivo

Comprender cómo almacenar, manipular y analizar datos numéricos mediante listas, trabajando con:

- Colecciones mutables (`mutableListOf`)
- Entrada de datos por consola
- Generación de números aleatorios
- Bucles y estructuras de control
- Funciones
- Operaciones matemáticas
- Cálculo de estadísticas básicas (media, moda y desviación típica)
- Validación de datos

## Funcionalidades

```text
===== ESTADÍSTICAS CON KOTLIN =====
1. Generar 100 números aleatorios
2. Introducir 100 números manualmente
3. Mostrar números
4. Calcular media
5. Calcular moda
6. Calcular desviación típica
7. Calcular todas las estadísticas
8. Salir
```

| **Opción** | **Descripción** |
|---|---|
| **1. Generar 100 números aleatorios** | Genera automáticamente una lista de 100 números aleatorios dentro de un rango definido, por ejemplo, entre 1 y 100. |
| **2. Introducir 100 números manualmente** | Solicita al usuario la introducción de 100 números por teclado y los almacena en una lista mutable. |
| **3. Mostrar números** | Muestra por pantalla los 100 números almacenados en la lista. |
| **4. Calcular media** | Calcula la media aritmética de los números almacenados, sumando todos los valores y dividiendo entre la cantidad de datos. |
| **5. Calcular moda** | Determina el valor o los valores que aparecen con mayor frecuencia en la lista, contemplando posibles empates. |
| **6. Calcular desviación típica** | Calcula la desviación típica de los datos para conocer cuánto se dispersan los valores respecto a la media. |
| **7. Calcular todas las estadísticas** | Calcula y muestra conjuntamente la media, la moda y la desviación típica. |
| **8. Salir** | Finaliza el programa. |

El menú se repite hasta que el usuario selecciona la opción de salir.

## Requisitos

- IntelliJ IDEA
- JDK 17 o superior
- Kotlin

## Estructura del proyecto

```text
UD01_Actividad08_Estadisticas/
├── src/
│   └── main/
│       └── kotlin/
│           └── Main.kt
└── README.md
```
