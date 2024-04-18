package interfaces

interface IEntradaSalida {
    // Pide la opción para el menú principal.
    fun pedirOpcion(): Int?

    // Obtiene dato necesario por teclado.
    fun pedirDato(mensaje: String = ""): String?

    // Mostrará por terminal información para el usuario.
    fun <T> mostrarInformacion(mensaje: T)

    // Pedirá la letra que usara Ahorcado.
    fun pedirLetra(): String?

    // Limpia la terminal con líneas String vacías.
    fun limpiar(lineas: Int = 20)

    // Genera una pausa.
    fun pausa()

}