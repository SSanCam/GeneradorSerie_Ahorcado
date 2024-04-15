interface IEntradaSalida {
    fun pedirOpcion(): Int?
    fun pedirDato(mensaje: String = ""): String?
    fun <T> mostrarInformacion(mensaje: T)
    fun pedirLetra(): String?
    fun limpiar(lineas: Int = 20)
    fun pausa()

}