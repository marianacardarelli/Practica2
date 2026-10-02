package com.example.practica2

fun main() {
    val asientos = mutableMapOf<String, Boolean>()
    val filas = 'A'..'E'

    for (fila in filas) {
        for (num in 1..5) {
            asientos["$fila$num"] = false
        }
    }
    var salir = false
    while (!salir) {
        println("\n--- CINE ---")
        println("1. Mostrar mapa")
        println("2. Reservar")
        println("3. Cancelar")
        println("4. Salir")
        print("Elige: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                for (fila in filas) {
                    for (num in 1..5) {
                        val clave = "$fila$num"
                        val estado = asientos[clave]
                        when (estado) {
                            true -> print("[X]")
                            false -> print("[ ]")
                            null -> print("[?]")
                        }
                    }
                    println()
                }
            }
            2 -> {
                print("Asiento (ej. A1): ")
                val asiento = (readLine() ?: "").uppercase()
                try {
                    val disponible = asientos[asiento] ?: throw IllegalArgumentException("Asiento no existe")
                    if (disponible) throw IllegalStateException("Asiento ocupado")
                    asientos[asiento] = true
                    println("Reservado.")
                } catch (e: Exception) {
                    println("Error: ${e.message}")
                }
            }
            3 -> {
                print("Asiento (ej. A1): ")
                val asiento = (readLine() ?: "").uppercase()
                try {
                    val ocupado = asientos[asiento] ?: throw IllegalArgumentException("Asiento no existe")
                    if (!ocupado) throw IllegalStateException("Asiento no está reservado")
                    asientos[asiento] = false
                    println("Cancelado.")
                } catch (e: Exception) {
                    println("Error: ${e.message}")
                }
            }
            4 -> salir=true
            else -> println("Opción no válida.")
        }
    }
}
