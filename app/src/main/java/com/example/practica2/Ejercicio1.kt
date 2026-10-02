package com.example.practica2
fun main() {
    csv()
}
//"\t" añade un tabulador
//ejemplo: encabezados.joinToString{"\n"}
//drop(n) devuelve una nueva colección sin los primeros n elementos. Se usa en listas, arrays, strings y secuencias.
// notas.average() para calcular la media
fun csv(){
    var notas = """nombre,nota1,nota2,nota3
                    Ana,7,8,9
                    Luis,5,6,4
                    Marta,9,10,8"""
    val texto= notas.split("\n")
    var cabecera: String
    var nombre: String
    var nota1: Int
    var nota2: Int
    var nota3: Int
    var promedio: Double
     for (i in 0 until texto.size){
         if (i==0){
             cabecera = texto[0]
             println(cabecera)
         } else {
             var estudiante = texto[i].split(",")
             nombre = estudiante[0]
             nota1= estudiante[1].toInt()
             nota2= estudiante[2].toInt()
             nota3=estudiante[3].toInt()
             promedio = (nota1 + nota2 + nota3)/3.0
            var resultado= when(promedio){
                 in 1.0 .. 5.0 -> "Suspenso"
                 in 5.0..6.0 -> "Aprobado"
                 in 7.0..8.0-> "Notable"
                 in 9.0..10.0 ->"Sobresaliente"
                else -> "Nota inválida"
            }

             println("$nombre $nota1 $nota2 $nota3 $promedio $resultado")
         }
     }

}