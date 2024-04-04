class Menu(private val info: IEntradaSalida) : IMenu {
    override fun mostrarMenu() {
        var opcion = info.mostrarMensaje(
            "1.- Generar serie.\n" +
                    "2.- Jugar al ahorcado.\n" +
                    "3.- Salir."
        )

    }

    override fun generarSerie() {
        TODO("Not yet implemented")
    }

    override fun jugarAhorcado() {
        TODO("Not yet implemented")
    }


}


