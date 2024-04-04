interface IMenu {
    fun mostrarMenu()
    fun generarSerie()
    fun jugarAhorcado(){
        val jugar = Ahorcado((5..10).random())
    }
}