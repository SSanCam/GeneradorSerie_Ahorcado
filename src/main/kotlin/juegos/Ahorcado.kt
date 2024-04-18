package juegos

import interfaces.IGestorAhorcado
import gestores.*
import misc.Palabra

/**
 * Ahorcado mostrará el típico juego del Ahorcado
 * @property intentos Int Es el número de intentos que tiene el jugador para acertar la palabra.
 * @property consola GestorConsola Se encargrá de implementar todos los métodos necesarios para obtener y mostrar datos.
 */
class Ahorcado(private val consola: GestorConsola = GestorConsola(), private val intentos: Int = 5) : IGestorAhorcado {

    val palabraGenerada = Palabra().obtenerPalabraAleatoria()

    /**
     * Jugar
     * Inicializa el juego del Ahorcado.
     */
    override fun jugar() {
        consola.mostrarInformacion(mostrarMensajeBienvenida())
        jugarRonda(intentos, this.palabraGenerada)
    }

    override fun mostrarMensajeBienvenida() {
        consola.mostrarInformacion(
            """
            |¡Bienvenido al juego del Ahorcado!
            |La palabra que tienes que adivinar tiene ${palabraGenerada.length} letras.
        """.trimMargin()
        )
    }

    /**
     * Jugar ronda
     * Gestiona los pasos de una ronda del juego
     * @param intentos: Int Son los intentos por juego.
     *
     */
    override fun jugarRonda(intentos: Int, palabraGenerada: String) {
        val palabraAleatoria = palabraGenerada
        var palabraOculta = " _".repeat(palabraAleatoria.length)
        var intentosRestantes = intentos
        val letrasUsadas: MutableSet<String> = mutableSetOf()
        val palabraAdivinada: MutableMap<String, Char?> = mutableMapOf()

        for (letra in palabraAleatoria) {
            palabraAdivinada[" _"] = null
        }

        do {
            consola.mostrarInformacion("Adivina la palabra:$palabraOculta")
            val letraNueva = consola.pedirLetra().toString()

            if (letraNueva in palabraGenerada) {
                letrasUsadas.add(letraNueva)
                for (letra in palabraGenerada.indices) {
                    if (palabraGenerada[letra].toString() == letraNueva) {
                        palabraOculta = palabraOculta.replaceRange(letra * 2, letra * 2 + 1, letraNueva)
                    }
                }
                if (letraNueva in letrasUsadas){
                    consola.mostrarInformacion("Ya has usado esa letra, prueba con otra.")
                }
            } else {
                intentosRestantes--
                consola.mostrarInformacion("Incorrecto! Intentos restantes: $intentosRestantes")
            }

        } while (intentosRestantes > 0 && " _" in palabraOculta)

        consola.mostrarInformacion("Adivina la palabra:$palabraOculta")

        if (" _" !in palabraOculta) {
            consola.mostrarInformacion("¡Felicidades! Has acertado la palabra.")
            Thread.sleep(3000)
            consola.limpiar(20)
            GestorMenu(consola).mostrarMenu()
        } else {
            consola.mostrarInformacion("¡Ohhh! Lo sentimos, ya no tienes más intentos. La palabra era: $palabraGenerada")
            Thread.sleep(3000)
            consola.limpiar(20)
            GestorMenu(consola).mostrarMenu()
        }
    }

}
