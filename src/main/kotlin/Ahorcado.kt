/**
 * Ahorcado mostrará el típico juego del Ahorcado
 * @property intentos Int Es el número de intentos que tiene el jugador para acertar la palabra.
 * @property consola GestorConsola Se encargrá de implementar todos los métodos necesarios para obtener y mostrar datos.
 */
class Ahorcado(private val consola: GestorConsola = GestorConsola(), private val intentos: Int = 5) : IAhorcado {

    val palabra = Palabra()
    val palabraGenerada = palabra.obtenerPalabraAleatoria()
    override fun jugar() {

    }
}