package gestores
import juegos.*
import interfaces.IMenu

/**
 * Gestor menu
 *
 * @property consola GestorConsola Para poder manejar la entrada/salida de datos.
 */
class GestorMenu(private val consola: GestorConsola): IMenu {

    /**
     * Muestra el menú principal del programa.
     */
    override fun mostrarMenu() {
        consola.mostrarInformacion("""
            1. Generar serie.
            2. Jugar al ahorcado.
            3. Salir.
        """.trimIndent())

        val opcion = consola.pedirOpcion()
        when (opcion){
            1 -> generarSerie()
            2 -> jugarAhorcado()
            3 -> {
                consola.mostrarInformacion("Saliendo del programa.")
                consola.pausa()
            }
        }
    }

    /**
     * Genera una serie numérica.
     */
    override fun generarSerie() {
        val generador = GeneradorSeries(consola)
        generador.generarSerie(consola)
    }

    /**
     * Inicia el juego del Ahorcado.
     */
    override fun jugarAhorcado() {
        Ahorcado().jugar()
    }
}