package juegos

import misc.TipoSerie
import interfaces.IGenerarSerie
import gestores.*

/**
 * Generador series
 * Clase que genera series numéricas de forma aleatoria y determina su tipo (creciente o decreciente).
 *
 *@property consola GestorConsola para manejar la entrada y salida de datos.
 */
class GeneradorSeries(private val consola: GestorConsola) : IGenerarSerie {

    /**
     * Generar rango aleatorio
     * Genera un rango aleatorio entre los valores mínimo y máximo especificados.
     * @param min Int Valor mínimo del rango.
     * @param max Int Valor máximo del rango.
     * @return Devuelve un rango aleatorio entre 1-100, que tiene al menos 30 números entre el valor máximo y el valor mínimo.
     */
    override fun generarRangoAleatorio(min: Int, max: Int): IntRange {
        val numeroAleatorio = (min..max).random()
        val rangoAleatorio: IntRange

        if (numeroAleatorio < 30) {
            val nuevoMin = max - (max - numeroAleatorio)
            rangoAleatorio = numeroAleatorio..max
        } else if (numeroAleatorio > 70) {
            val nuevoMax = min + (numeroAleatorio - min)
            rangoAleatorio = min..nuevoMax
        } else {
            rangoAleatorio = min..max
        }
        return rangoAleatorio
    }

    /**
     * Generar Serie
     * Éste método recibe un rango aleatorio, pide al usuario un número dentro de dicho rango y determina que tipo de serie (creciente o decreciente) debe crear.
     * @return Devuelve IntRange generado a partir del método generarRangoAleatorio.
     */
    override fun generarSerie(consola: GestorConsola) {
        consola.limpiar(20)
        val numeroPedido: Int?
        val tipoSerie: TipoSerie
        val rangoSerie = generarRangoAleatorio()

        try {
            // Pedimos un número que esté dentro del rango aleatorio generado:
            numeroPedido =
                consola.pedirDato("Ingresa un número entre ${rangoSerie.first}-${rangoSerie.last}")?.toInt()

            // Indentificamos el tipo de serie que vamos a generear, según si el número ingresado se hacerca más al primer número del rango o alg último.
            tipoSerie = if (numeroPedido != null && numeroPedido < (rangoSerie.last / 2)) {
                TipoSerie.CRECIENTE
            } else {
                TipoSerie.DECRECIENTE
            }
            // Llamamos a la función encargada de generar la serie según el `TipoSerie`, pasandole por parámetros el rango aleatorio creado
            if (tipoSerie == TipoSerie.CRECIENTE) {
                consola.mostrarInformacion(serieCreciente(rangoSerie))
            } else {
                consola.mostrarInformacion(serieDecreciente(rangoSerie))
            }
        } catch (e: IllegalArgumentException) {
            consola.mostrarInformacion("**ERROR**")
        } catch (e: NumberFormatException) {
            consola.mostrarInformacion("Debes ingresar un número dentro del rango ${rangoSerie.first}-${rangoSerie.last}")
        }
        Thread.sleep(3000)
        consola.limpiar(20)
        GestorMenu(consola).mostrarMenu()
    }

    /**
     * Serie Creciente
     * @param rangoFinal IntRange Es el rango que se ha determinado a raíz de la función `generarSerie()`
     * @return Devuelve una pirámide representada por los números del rango generado aleatoriamente, que se van sumando poco a poco.
     */
    override fun serieCreciente(rangoFinal: IntRange) {
        var sumaFinal = 0
        var serie = ""

        for ((index, numero) in rangoFinal.withIndex()) {
            sumaFinal += numero
            serie += if (index > 0) "+$numero" else "$numero"
            consola.mostrarInformacion("$serie ($index)\n")
            consola.pausa()
        }
        consola.mostrarInformacion("Suma => $sumaFinal")
    }

    /**
     * Serie Creciente
     * @param rangoFinal IntRange Es el rango que se ha determinado a raíz de la función `generarSerie()`
     * @return Devuelve un triángulo representada por los números del rango que se van sumando poco a poco, de forma contraria a la creciente.
     */
    override fun serieDecreciente(rangoFinal: IntRange) {
        var sumaFinal = 0
        // Se itera el rango desde el último número al primero.
        for (numero in rangoFinal.last downTo  rangoFinal.first){
            var serie = ""
            // Vuelve a iterarse el rango desde el numero actual, hasta el primero, pero en cada vuelta el número actual será el penúltimo, por lo que el rango será cada vez un número más pequeño.
            for (nuevaPosicion in numero downTo rangoFinal.first){
                serie +="$nuevaPosicion+"
                sumaFinal += nuevaPosicion
            }
            consola.mostrarInformacion("${(rangoFinal.last - numero + 1).toString().padStart(2,'0')} -> $serie = $sumaFinal\n")
            consola.pausa()
        }
        consola.mostrarInformacion("Total = $sumaFinal")
    }

}