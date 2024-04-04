class Consola(): IEntradaSalida {
    override fun leerInfo(info: Any): Any {
        val lectura = readLine()?.toInt()
        if (lectura != null) {
            return lectura.toInt()
        }
        return 0
    }

    override fun mostrarMensaje(mensaje: Any) {
        val imprimir = println(mensaje)
        return imprimir
    }
}