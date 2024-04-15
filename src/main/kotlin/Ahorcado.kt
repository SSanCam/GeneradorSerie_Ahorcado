/**
 * Ahorcado mostrará el típico juego del Ahorcado
 * @property intentos Int Es el número de intentos que tiene el jugador para acertar la palabra.
 * @property consola GestorConsola Se encargrá de implementar todos los métodos necesarios para obtener y mostrar datos.
 */
class Ahorcado(private val consola: GestorConsola = GestorConsola(), private val intentos: Int = 5) : IAhorcado {

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
        var palabraOculta = ""
        var intentosRestantes = intentos

        for (letras in palabraGenerada) {
            palabraOculta += " _"
        }

        do {
            consola.mostrarInformacion("Adivina la palabra:$palabraOculta")
            var letraNueva = consola.pedirLetra()

            /* Comprobamos si la letra introducida está en la palabra aleatoria oculta y actualizamos palabraOculta
            para ir resolviendola.
            */
            if (letraNueva.toString() in palabraGenerada) {
                palabraOculta.replace("_ ", "$letraNueva ")
                consola.mostrarInformacion(palabraOculta)
            }
            // Comprobamos si la letra introducida no está en la palabra aleatoria oculta y restamos un intento.
            if (letraNueva?.lowercase().toString() !in palabraGenerada) {
                consola.mostrarInformacion("Incorrecto! Intentos restantes: $intentosRestantes")
                intentosRestantes--
            }

        } while (letraNueva != null && intentos > 0)

        if (intentosRestantes <= intentos && palabraOculta == palabraGenerada) {
            consola.mostrarInformacion("¡Felicidades! Has acertado la palabra.")
        } else if (intentos > intentosRestantes) {
            consola.mostrarInformacion("¡Ohhh! Lo sentimos, ya no tienes más intentos.")
        }
    }

}
