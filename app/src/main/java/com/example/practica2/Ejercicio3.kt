package com.example.practica2
//Estoy contando los espacios, cómo quito eso?
var frecuencia = mutableMapOf<Char, Int>()
fun main (){
    println("Escribe el texto para calcular la frecuencia de las letras: ")
    val texto = readln().trim().lowercase().toList()
    var contador = 0
    for (i in texto.indices){
        val letra = texto[i]
        if(!frecuencia.keys.contains(letra) && letra != ' ') {
            for (j in texto.indices) {
                if (texto[i] == texto[j]) {
                    contador++
                }
            }
            frecuencia[texto[i]] = contador
            contador=0
        }
    }
    println(frecuencia)
}