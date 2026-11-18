import kotlin.math.sqrt

const val TOTAL_NUMEROS = 100

fun main() {
    var numeros: List<Int> = emptyList()
    var salir = false

    while (!salir) {
        mostrarMenu()
        when (readLine()?.trim()) {
            "1" -> {
                numeros = generarNumerosAleatorios()
                println("Se han generado $TOTAL_NUMEROS números aleatorios.")
            }
            "2" -> numeros = pedirNumerosManualmente()
            "3" -> if (hayDatos(numeros)) mostrarNumeros(numeros)
            "4" -> if (hayDatos(numeros)) mostrarMedia(numeros)
            "5" -> if (hayDatos(numeros)) mostrarModa(numeros)
            "6" -> if (hayDatos(numeros)) mostrarDesviacion(numeros)
            "7" -> if (hayDatos(numeros)) {
                mostrarMedia(numeros)
                mostrarModa(numeros)
                mostrarDesviacion(numeros)
            }
            "8" -> {
                println("Hasta pronto.")
                salir = true
            }
            else -> println("Opción no válida. Introduzca un número del 1 al 8.")
        }
    }
}

// ---------- Menú ----------

fun mostrarMenu() {
    println()
    println("===== ESTADÍSTICAS CON KOTLIN =====")
    println("1. Generar $TOTAL_NUMEROS números aleatorios")
    println("2. Introducir $TOTAL_NUMEROS números manualmente")
    println("3. Mostrar números")
    println("4. Calcular media")
    println("5. Calcular moda")
    println("6. Calcular desviación típica")
    println("7. Calcular todas las estadísticas")
    println("8. Salir")
    print("Seleccione una opción: ")
}

// ---------- Datos ----------

fun generarNumerosAleatorios(): List<Int> =
    MutableList(TOTAL_NUMEROS) { (1..100).random() }

fun pedirNumerosManualmente(): List<Int> {
    val lista = mutableListOf<Int>()
    println("Introduzca $TOTAL_NUMEROS números enteros (uno por línea).")
    while (lista.size < TOTAL_NUMEROS) {
        print("Número ${lista.size + 1}/$TOTAL_NUMEROS: ")
        val numero = readLine()?.trim()?.toIntOrNull()
        if (numero == null) {
            println("  Entrada no válida: debe ser un número entero. Inténtelo de nuevo.")
        } else {
            lista.add(numero)
        }
    }
    println("Se han almacenado los $TOTAL_NUMEROS números.")
    return lista
}

fun hayDatos(numeros: List<Int>): Boolean {
    if (numeros.isEmpty()) {
        println("La lista está vacía. Use primero la opción 1 o la 2.")
        return false
    }
    return true
}

fun mostrarNumeros(numeros: List<Int>) {
    println("Números (${numeros.size}):")
    numeros.chunked(10).forEach { fila ->
        println(fila.joinToString(" ") { it.toString().padStart(4) })
    }
}

// ---------- Cálculos ----------

fun calcularMedia(numeros: List<Int>): Double =
    numeros.sum().toDouble() / numeros.size

/**
 * Devuelve la lista de modas.
 * Si todos los valores aparecen una sola vez, devuelve una lista vacía (no hay moda).
 */
fun calcularModa(numeros: List<Int>): List<Int> {
    val frecuencias = numeros.groupingBy { it }.eachCount()
    val maxFrecuencia = frecuencias.values.max()
    if (maxFrecuencia == 1) return emptyList()
    return frecuencias.filter { it.value == maxFrecuencia }.keys.sorted()
}

fun calcularDesviacionTipica(numeros: List<Int>): Double {
    val media = calcularMedia(numeros)
    val varianza = numeros.map { (it - media) * (it - media) }.sum() / numeros.size
    return sqrt(varianza)
}

// ---------- Salida de resultados ----------

fun mostrarMedia(numeros: List<Int>) {
    println("La media es: %.2f".format(calcularMedia(numeros)))
}

fun mostrarModa(numeros: List<Int>) {
    val modas = calcularModa(numeros)
    when {
        modas.isEmpty() -> println("No hay moda: todos los valores aparecen una sola vez.")
        modas.size == 1 -> println("La moda es: ${modas[0]}")
        else -> {
            val texto = modas.dropLast(1).joinToString(", ") + " y " + modas.last()
            println("Las modas son: $texto")
        }
    }
}

fun mostrarDesviacion(numeros: List<Int>) {
    println("La desviación típica es: %.2f".format(calcularDesviacionTipica(numeros)))
}