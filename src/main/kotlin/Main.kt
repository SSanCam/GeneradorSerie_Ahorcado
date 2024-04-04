import java.util.Scanner

fun main() {
    val consola = Consola()
    val menu = Menu()
    val ahorcado = Ahorcado()

    // Recibimos la opción del menú
    do {
        consola.mostrarMensaje(menu.mostrarMenu())
        var opcion: String = consola.leerInfo("Introduce tu opción:").toString()
        when (opcion) {
            "1" -> menu.generarSerie()
            "2" -> menu.jugarAhorcado()
            "3" -> consola.mostrarMensaje("Saliendo del programa.")
            else -> consola.mostrarMensaje("Opción no válida.")
        }
    } while (opcion.toInt() != 3)

}