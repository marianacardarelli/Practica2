package com.example.practica2
//se usa this.filter{!it.startsWuth("[X]")}
//for ((i,t) in tareas.withIndex()) devuelve en i el indice y en t la tarea
//Defini la lista mutabla donde se guardarán las tareas
//tareas.indice es una propiedad que devuelve el rango de posiciones válidas de una colección o array (0..size-1).
val listaTareas = mutableListOf<String>()
fun main() {
    menu()
}
fun menu(){
    var opcion: Int
    do {
            println("Elige una opción: "+
            "\n"+ "1.Añadir Tarea" +
            "\n"+ "2. Completar tarea" +
            "\n"+ "3. Listar las tareas" +
            "\n"+ "4. Listar pendientes" +
            "\n"+ "5. Filtrar" +
            "\n"+ "6. Salir")
            opcion = readLine()!!.toIntOrNull() ?: 0
        when(opcion){
            1 -> anhadirTarea()
            2 ->  completarTarea()
            3 -> listarLasTareas()
            4 -> listarPendientes()
            5 -> filtrar()
        }
    } while (opcion!=6)
}

fun filtrar() {
    var continuar= -1
    do {
        println("Escribe que tarea desea buscar")
        var busqueda = readLine() ?: ""
        for (tarea in listaTareas){
            if (tarea.contains(busqueda) ){
                println("La tarea buscada es: ")
                println(tarea)
            }
            println("Desea seguir buscando? 1-Sí/2-No")
            continuar = readln().toInt()
    }
    } while (continuar != 2)
}

fun listarPendientes() {
    for (i in listaTareas.indices){
        if (!listaTareas[i].contains("[X]")) {
            println("Tarea pendiente: " + listaTareas[i])
        }
    }
}

fun listarLasTareas() {
    var i = 1
    for (tareas in listaTareas){
        println("$i - $tareas")
        i++
    }
}

fun completarTarea() {
    println(listaTareas)
    println("Elige la tarea que desea completar: ")
   var tareaCompletar = readLine().toString()
   for (i in 0..listaTareas.size-1 ){
              if (listaTareas[i].contains(tareaCompletar)){
                  listaTareas[i]= "[X] " + listaTareas[i]
                  println("Tarea actualizada con éxito.")
                  println(listaTareas)
              }
    }
}


fun anhadirTarea() {
    do {
        var parar= false
        println("Escribe la tarea a realizar")
        //Agrego la tarea a la lista mutable
        var tarea = readln()
        listaTareas.add(tarea)
        println("Desea continuar? 1-Sí o 2-No")
        var decision = readLine()!!.toIntOrNull()
        if (decision == 1){
            parar=false
        } else {
            parar=true
        }
    } while(!parar)


}
