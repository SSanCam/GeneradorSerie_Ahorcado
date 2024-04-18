package juegos

import interfaces.*
import gestores.*
import misc.Palabra
/**
 * Ahorcado mostrará el típico juego del Ahorcado
 * @property intentos Int Es el número de intentos que tiene el jugador para acertar la palabra.
 * @property consola GestorConsola Se encargrá de implementar todos los métodos necesarios para obtener y mostrar datos.
 */
class Ahorcado(private val consola: GestorConsola = GestorConsola(), private val intentos: Int = 5) : IGestorAhorcado {

    private val palabraGenerada: String = Palabra().obtenerPalabraAleatoria()

    /**
     * Jugar
     *
     * Inicializa el juego del Ahorcado.
     */
    override fun jugar() {
        consola.mostrarInformacion(mostrarMensajeBienvenida())
        jugarRonda(intentos, this.palabraGenerada)
    }

    /**
     * Mostrar mensaje Bienvenida
     *
     * Muestra el mensaje que veremos al comenzar el juego.
     */
    override fun mostrarMensajeBienvenida() {
        consola.mostrarInformacion(
            """
            |¡Bienvenido al juego del Ahorcado!
            |La palabra que tienes que adivinar tiene ${palabraGenerada.length} letras.
        """.trimMargin()
        )
    }

    /**
     * Ocultar palabra
     * @return Reemplaza cada letra de la palabra con " _"
     */
    override fun ocultarPalabra(): String {
        return " _".repeat(palabraGenerada.length)
    }

    /**
     * Actualizar palabra
     *
     * Actualiza la palabra oculta con las letras adivinadas por el jugador.
     *
     * @param letraNueva        String  Letra introducida por el jugador.
     * @param palabraGenerada   String  Palabra que el jugador debe adivinar.
     * @param palabraOculta     String  Palabra oculta, con las letras adivinadas actualizadas.
     *
     * @return Actualiza la palabra oculta con las letras adivinadas por el jugador.
     */
    override fun actualizarPalabra(letraNueva: String, palabraGenerada: String, palabraOculta: String): String {
        return palabraGenerada.map { if (it.toString() == letraNueva) it else "_"}.joinToString(" ")
    }


    /**
     * Jugar ronda
     *
     * Gestiona los pasos de una ronda del juego
     *
     * @param intentos Int Son los intentos por juego.
     * @param palabraGenerada String Palabra obtenida de forma aleatoria que el jugador debe adivinar.
     *
     */
    override fun jugarRonda(intentos: Int, palabraGenerada: String) {
        val palabraOculta = ocultarPalabra()
        var intentosRestantes = intentos
        try {
            do {
                consola.mostrarInformacion("Adivina la palabra: $palabraOculta")
                val letraNueva: String = consola.pedirLetra().toString()
                val palabraActualizada = actualizarPalabra(letraNueva,palabraGenerada,palabraOculta)
                consola.mostrarInformacion(palabraActualizada)
                if (letraNueva.lowercase() !in palabraGenerada){
                    consola.mostrarInformacion("Incorrecto! Intentos restantes: $intentosRestantes")
                    intentosRestantes--
                }
            } while (intentosRestantes > 0 && "_" in palabraOculta)

        } catch (e: Exception) {
            consola.mostrarInformacion("**Error**")
        } catch (e: IllegalArgumentException) {
            consola.mostrarInformacion("No permitido.")
        }

    }

    /**
     * Mostrar resultado
     *
     * Muestra el resultado final de la partida.
     * @param intentosRestantes Int Representa el número de intentos disponibles.
     * @param palabraOculta String Es la palabra oculta que debemos adivinar.
     */
    override fun mostrarResultado(intentosRestantes: Int, palabraOculta: String) {
        if (intentosRestantes <= 0 && "_" !in palabraOculta){
            consola.mostrarInformacion("¡Felicidades! Has acertado la palabra.")
            Thread.sleep(3000)
            consola.limpiar(20)
            GestorMenu(consola).mostrarMenu()
        }else{
            consola.mostrarInformacion("¡Ohhh! Lo sentimos, ya no tienes más intentos. La palabra era: $palabraGenerada")
            Thread.sleep(3000)
            consola.limpiar(20)
            GestorMenu(consola).mostrarMenu()
        }
    }
}
