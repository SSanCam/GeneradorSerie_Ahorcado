/**
 * Clase principal del juego el ahorcado
 * @property intentos Int Es el número de intentos máximos que tendrá el jugador, por defecto 5.
 *
 */
class Ahorcado(intentos: Int) {
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
        for (letras in palabraAleatoria){
            palabraOculta += "_ "
        }
        do {
            consola.mostrarMensaje("Adivina la palabra: $palabraOculta")
            var letra = consola.leerInfo("Intenta con una letra:").toString()
            if (letra.lowercase() in abecedario){

            }
        }while (letra != null && letra.lowercase() in abecedario)


    }

}