/**
 * Programa principal que llama al Menú
 */
fun main() {
    val consola = GestorConsola()
    val menu = Menu(consola)

    menu.mostrarMenu()
}