/**
 * Clase Serie creciente
 * Hereda funcionalidades de las interface IEntradaSalida e IMenu
 *
 */
class CrearSerie() : IEntradaSalida {
    /**
     * Generar Serie, es heredada de la interface IMenu.
     * Lee y devuelve datos por las funciones heredadas de IEntradaSalida
     */
    private fun generarSerie():  {

        val primerLimite = (1..100).random()
        val limiteRango: IntRange
        // Comprobamos que el rango que se genere esté dentro del propio rango 1..100.
        // El rango debe de poder tener al menos 30 números tanto inferiores como superiores.
        if (primerLimite < 30) {
            limiteRango = (primerLimite..100)
        } else if (primerLimite > 70) {
            limiteRango = (1..primerLimite)
        }

        // Pedimos un número dentro del rango creado:
        val numPedido = leerInfo("Introduce un número[]")
    }

    /**
     * Leer info
     * En éste caso queremos recibir por teclado un número entero, por lo que en la función controlamos la entrada de datos, para que se nos devuelva un número entero.
     */
    override fun leerInfo(info: Any): Int {
        val lectura = readLine()?.toInt()
        if (lectura != null) {
            return lectura.toInt()
        }
        return 0
    }

    /**
     * Salida info
     * Recibe cualquier tipo de dato y lo devolveremos como tipo Unit
     */
    override fun mostrarMensaje(mensaje: Any) {
        val imprimir = println(mensaje)
        return imprimir
    }
}
