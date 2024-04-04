class Menu() : IMenu {
    private val consola = Consola()
    private val serie = CrearSerie()
    private val ahorcado = Ahorcado((5..10).random())
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
        ahorcado.jugar()
    }
}


