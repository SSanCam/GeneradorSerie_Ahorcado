class Menu() : IMenu {
    private val consola = Consola()
    private val serie = CrearSerie()

    override fun mostrarMenu() {
        consola.mostrarMensaje(
            "1.- Generar serie.\n" +
                    "2.- Jugar al ahorcado.\n" +
                    "3.- Salir."
        )
    }

    override fun generarSerie() {
        serie.crearRangoAleatorio()

    }

    override fun jugarAhorcado() {
        val ahorcado = Ahorcado((5..10).random())
        ahorcado.jugar()
    }
}


