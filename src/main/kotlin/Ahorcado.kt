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
        var intentosRestantes = intentos
        var palabraAdivinada = ""
        val longitudPalabra = palabraGenerada.length
        var adivinaPalabra = "Adivina la palabra:"
        for (letra in 1..longitudPalabra){
            adivinaPalabra += " _"
        }
        do {
            consola.mostrarInformacion("$adivinaPalabra")
            val nuevaLetra = consola.pedirLetra()
            if (nuevaLetra.toString() !in palabraGenerada){
                intentosRestantes--
                consola.mostrarInformacion("Incorrecto! Intentos restantes: $intentosRestantes")
            }else{
                for (letra in palabraGenerada.indices){
                    if (palabraGenerada[letra].toString() == nuevaLetra.toString()){
                        palabraAdivinada = palabraAdivinada.replace(" _", nuevaLetra.toString())
                    }
                    consola.mostrarInformacion("Correcto!")
                }
                adivinaPalabra = palabraAdivinada
                consola.mostrarInformacion(adivinaPalabra)
            }
        } while (intentos > 0 && "_" in adivinaPalabra)
    }

}