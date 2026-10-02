package com.example.practica2

//validador de contraseñas

fun main(){

    validador()
}
fun validador() {
    do {
        var continuar = true
        var contrasenia=""
        println("Escribe la constraseña")
        contrasenia= readln() ?: ""
        if (contrasenia.length >= 8) {
            if (contrasenia.any { it.isUpperCase() }) {
                if (contrasenia.any { it.isLowerCase() }) {
                    if (contrasenia.any { it.isDigit() }) {
                        if (contrasenia.any { !it.isLetterOrDigit() }) {
                            println("Contraseña validada")
                            continuar = false
                        } else (println("Debe contener al menos un carcater especial"))
                    } else (println("Debe contener al menos un dígito"))
                } else (println("Debe contener al menos una minúscula"))
            } else (println("Debe contener al menos una mayúscula"))
        } else (println("Debe contener minimo 8 caracteres"))
    } while (continuar)
}