/**
 * Menu
 * Hereda los metodos de la Interface IMenu
 */
class Menu() : IMenu {
    private val consola = Consola()


    /**
     * Mostrar menu
     * @return String Mostrando un texto con las opciones del menú.
     */
    override fun mostrarMenu(): String  {
        return consola.mostrarMensaje(
            "1.- Generar serie.\n" +
                    "2.- Jugar al ahorcado.\n" +
                    "3.- Salir."
        )
    }

    /**
     * Generar Serie
     * Devuelve la serie que se generará según el primer rango aleatorio y el número introducido por teclado.
     */
    override fun generarSerie() {
        CrearSerie().crearRangoAleatorio()
    }

    override fun jugarAhorcado() {
        Ahorcado().jugar()
    }
}


