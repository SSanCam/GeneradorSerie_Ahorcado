interface IGestorAhorcado {
    fun jugar()
    fun mostrarMensajeBienvenida()
    fun ocultarPalabra(): String
    fun actualizarPalabra(letraNueva: String, palabraGenerada: String, palabraOculta: String): String
    fun jugarRonda(intentos: Int, palabraGenerada: String)
    fun mostrarResultado(intentosRestantes: Int, palabraOculta: String)
}