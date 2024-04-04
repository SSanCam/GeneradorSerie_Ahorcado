class Menu() : IMenu {
    private val consola = Consola()


    override fun mostrarMenu(): String  {
        return consola.mostrarMensaje(
            "1.- Generar serie.\n" +
                    "2.- Jugar al ahorcado.\n" +
                    "3.- Salir."
        )
    }

    override fun generarSerie() {
        val serie = CrearSerie()
        consola.mostrarMensaje(serie.crearRangoAleatorio())

    }

    override fun jugarAhorcado() {
        val ahorcado = Ahorcado((5..10).random())
        consola.mostrarMensaje(ahorcado.jugar())
    }
}


