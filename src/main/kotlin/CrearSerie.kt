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
    private fun crearRangoAleatorio() {
        val primerLimite = (1..100).random()
        val limiteRango: IntRange
        // Comprobamos que el rango que se genere esté dentro del propio rango 1..100.
        // El rango debe de poder tener al menos 30 números tanto inferiores como superiores.
        limiteRango = if (primerLimite < 30) {
            (primerLimite..100)
        } else if (primerLimite > 70) {
            (1..primerLimite)
        } else {
            (primerLimite - 30..primerLimite + 30)
        }

        // Pedimos un número dentro del rango creado:
        val numPedido = leerInfo("Introduce un número[${limiteRango.first}-${limiteRango.last}]").toString().toInt()
        if (numPedido > limiteRango.last / 2) {
            // El número pedido se acerca más al número de mayor valor en el rango, por lo que será una serie ASCENDIENTE.
            var suma = numPedido
            var niveles = 0
            var serieFinal = ""
            for (num in limiteRango) {
                serieFinal += "${numPedido}+${num} ($niveles)\n"
                suma += num
                niveles++
            }
            serieFinal += "Suma => $suma"
            mostrarMensaje(serieFinal)
        }// Si el número pedido se acerca al extremo de menor valor del rango, será una serie DESCENDIENTE.
        else {
            var resta = limiteRango.last
            var niveles = 1
            var serieFinal = ""
            for (num in (limiteRango.last..numPedido)) {
                serieFinal += "0$niveles -> $numPedido+$num \n"
                niveles++
                resta -= num
            }
            serieFinal += "Total => $resta"
            mostrarMensaje(serieFinal)
        }
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
