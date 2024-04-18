 import gestores.*

/**
 * Programa principal
 *
 * Crea una instancia del gestor de consola y del gestor del menú, luego muestra el menú principal.
 * El usuario puede seleccionar entre generar una serie, jugar al ahorcado o salir del programa.
 *
 */
fun main() {

    val consola = GestorConsola()
    val gestorMenu = GestorMenu(consola)

    // Muestra el menú principal.
    gestorMenu.mostrarMenu()
}