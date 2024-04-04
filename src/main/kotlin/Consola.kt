class Consola(): IEntradaSalida {
    override fun lecturaDato(info: Any): String {
        val lectura = readLine()
        if (lectura != null) {
            return lectura
        }
        return ""
    }

    override fun mostrarMensaje(mensaje: Any): String {
        val imprimir = println(mensaje)
        return imprimir.toString()
    }
}