package interfaces

import gestores.GestorConsola

interface IGenerarSerie {
    // Genera el primer rango aleatorio.
    fun generarRangoAleatorio(min: Int = 1, max: Int = 100) : IntRange

    // Genera la serie de forma ascendente o descendente, según el tipo.
    fun generarSerie(consola: GestorConsola)

    // Genera la serie creciente.
    fun serieCreciente(rangoFinal: IntRange)

    // Genera la serie decreciente.
    fun serieDecreciente(rangoFinal: IntRange)
}