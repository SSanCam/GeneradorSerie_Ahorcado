class Menu() : IMenu {
    private val consola = Consola()
    private val serie = CrearSerie()
    override fun mostrarMenu() {
        var opcion = consola.mostrarMensaje(
            "1.- Generar serie.\n" +
                    "2.- Jugar al ahorcado.\n" +
                    "3.- Salir."
        )
    }
    override fun generarSerie() {
        val generarSerie = serie.crearRangoAleatorio()
        consola.mostrarMensaje(generarSerie)
    }

    override fun jugarAhorcado() {
        consola.mostrarMensaje(("Aún no se ha implementado."))
    }
}


