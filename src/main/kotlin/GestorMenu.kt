class GestorMenu(private val consola: GestorConsola): IMenu {
    override fun mostrarMenu() {
        consola.mostrarInformacion("""
            1. Generar serie.
            2. Jugar al ahorcado.
            3. Salir.
        """.trimIndent())

        val opcion = consola.pedirOpcion()
        when (opcion){
            1 -> generarSerie()
            2 -> jugarAhorcado()
            3 -> {
                consola.mostrarInformacion("Saliendo del programa.")
                consola.pausa()
            }
        }
    }

    override fun generarSerie() {
        val generadorSeries = GeneradorSeries(consola)
        generadorSeries.generarSerie()

    }

    override fun jugarAhorcado() {
        Ahorcado().jugar()
    }
}