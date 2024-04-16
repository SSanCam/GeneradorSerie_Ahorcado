/**
 * Ahorcado mostrará el típico juego del Ahorcado
 * @property intentos Int Es el número de intentos que tiene el jugador para acertar la palabra.
 * @property consola GestorConsola Se encargrá de implementar todos los métodos necesarios para obtener y mostrar datos.
 */
class Ahorcado(private val consola: GestorConsola = GestorConsola(), private val intentos: Int = 5) : IGestorAhorcado {

    val palabra = Palabra()
    val palabraGenerada = palabra.obtenerPalabraAleatoria()

    /**
     * Jugar
     * Inicializa el juego del Ahorcado.
     */
    override fun jugar() {
        consola.mostrarInformacion(
            """
            |¡Bienvenido al juego del Ahorcado!
            |La palabra que tienes que adivinar tiene ${palabraGenerada.length} letras.
        """.trimMargin()
        )
        jugarRonda(intentos, this.palabraGenerada)
    }

    /**
     * Jugar ronda
     * Gestiona los pasos de una ronda del juego
     * @param intentos: Int Son los intentos por juego.
     *
     */
    private fun jugarRonda(intentos: Int, palabraGenerada: String = this.palabraGenerada) {
        var palabraOculta = " _".repeat(palabraGenerada.length)
        var intentosRestantes = intentos

        val palabraAdivinada: MutableMap<String, Char?> = mutableMapOf()

        for (letra in palabraGenerada) {
            palabraAdivinada[" _"] = null
        }

        do {
            consola.mostrarInformacion(palabraAdivinada)
            val nuevaLetra = consola.pedirLetra()
            if (nuevaLetra.toString() !in palabraGenerada) {
                intentosRestantes--
                consola.mostrarInformacion("Incorrecto! Intentos restantes: $intentosRestantes")
            } else {
                for (letra in palabraGenerada.indices) {
                    if (palabraGenerada[letra].toString() == nuevaLetra.toString()) {
                        palabraAdivinada = palabraOculta.replace(" _", nuevaLetra.toString())
                    }

                }
                consola.mostrarInformacion("Correcto!")
                palabraAdivinada = palabraAdivinada
                consola.mostrarInformacion(palabraAdivinada)
                consola.mostrarInformacion("Adivina la palabra:$palabraOculta")
                val letraNueva = consola.pedirLetra().toString()

                if (letraNueva in palabraGenerada) {
                    for (letra in palabraGenerada.indices) {
                        if (palabraGenerada[letra].toString() == letraNueva) {
                            palabraOculta = palabraOculta.replaceRange(letra * 2, letra * 2 + 1, letraNueva)
                        }
                    }
                } else {
                    consola.mostrarInformacion("Incorrecto! Intentos restantes: $intentosRestantes")
                    intentosRestantes--
                }

            }

            consola.mostrarInformacion("Adivina la palabra:$palabraOculta")

            if (" _" !in palabraOculta) {
                consola.mostrarInformacion("¡Felicidades! Has acertado la palabra.")
            } else {
                consola.mostrarInformacion("¡Ohhh! Lo sentimos, ya no tienes más intentos. La palabra era: $palabraGenerada")
            }
        } while (intentosRestantes > 0 && " _" in palabraOculta)

    }
}
