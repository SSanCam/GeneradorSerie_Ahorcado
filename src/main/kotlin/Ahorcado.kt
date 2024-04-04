/**
 * Clase principal del juego el ahorcado
 * @property intentos Int Es el número de intentos máximos que tendrá el jugador, por defecto 5.
 *
 */
class Ahorcado(intentos: Int = 5) {
    private var intentos: Int = (5..10).random()
        set(value) {
            require(intentos in 5..10) { "El número de intentos debe estar entre 5-10." }
            field = value
        }
    private val palabraAleatoria = Palabra.obtenerPalabraAleatoria()
    private val consola = Consola()
    // Métodos
    /**
     * Jugar
     * Inicia la partida de Ahorcado.
     */
    fun jugar() {
        val abecedario = "a".."z"
        var palabraOculta = ""
        var intentosRestantes = intentos
        for (letras in palabraAleatoria) {
            palabraOculta += "_ "
        }
        do {
            consola.mostrarMensaje("Adivina la palabra: $palabraOculta")
            var letra = consola.lecturaDato("Intenta con una letra:")

            // Comprobamos si la letra introducida está en la palabra aleatoria oculta y actualizamos palabraOculta para ir resolviendola.
            if (letra.lowercase() in palabraAleatoria) {
                palabraOculta.replace("_ ", letra)
                consola.mostrarMensaje(palabraOculta)
            }
            // Comprobamos si la letra introducida no está en la palabra aleatoria oculta y restamos un intento.
            if (letra.lowercase() !in palabraAleatoria) {
                consola.mostrarMensaje("Incorrecto! Intentos restantes: $intentosRestantes")
                intentosRestantes--
            }

        } while (letra != null && letra.lowercase() in abecedario && intentos <= intentosRestantes)

        if (intentosRestantes <= intentos && palabraOculta == palabraAleatoria) {
            consola.mostrarMensaje("¡Felicidades! Has acertado la palabra.")
        } else if (intentos > intentosRestantes) {
            consola.mostrarMensaje("¡Ohhh! Lo sentimos, ya no tienes más intentos.")
        }
    }

}