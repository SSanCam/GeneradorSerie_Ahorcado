import gestores.*

/**
 * Programa principal que llama al Menú
 */
fun main() {
    val consola = GestorConsola()
    val gestorMenu = GestorMenu(consola)

    gestorMenu.mostrarMenu()
}