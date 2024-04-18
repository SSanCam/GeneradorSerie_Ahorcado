package interfaces

interface IGestorAhorcado {
    // Inicia el juego.
    fun jugar()

    // Muestra el mensaje de bienvenida del juego.
    fun mostrarMensajeBienvenida()

    /*
    // Reemplaza las letras de la palabra a adivinar por "_"
    fun ocultarPalabra(): String

    // Actualiza la palabra oculta conforme el jugador adivine letras.
    fun actualizarPalabra(letraNueva: String, palabraGenerada: String, palabraOculta: String): String

    // Mostrará el resultado del fin de juego.
        fun mostrarResultado(intentosRestantes: Int, palabraOculta: String)
    */

    // Realiza lo que se tiene que hacer en cada ronda del juego.
    fun jugarRonda(intentos: Int, palabraGenerada: String)


}