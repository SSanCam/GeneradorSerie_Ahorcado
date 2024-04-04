/**
 * Programa principal.
 */
fun main() {
    val menu = Menu()

    // Recibimos la opción del menú
    do {
        val consola = Consola()
        consola.mostrarMensaje(menu.mostrarMenu())
        val opcion = consola.lecturaDato(consola.mostrarMensaje("Introduce tu opción"))
        when (opcion) {
            "1" -> menu.generarSerie()
            "2" -> menu.jugarAhorcado()
            "3" -> {
                consola.mostrarMensaje("Saliendo del programa.")
                Thread.sleep(200)
            }

            else -> consola.mostrarMensaje("Opción no válida.")
        }
    } while (opcion != "3")

}