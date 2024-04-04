/**
 * Palabra generará la palabra que el jugador debe adivinar.
 */
import com.google.gson.Gson
import java.io.File

class Palabra {
    data class Palabras(
        val palabras: List<String>
    )

    companion object {

        private const val RUTA_TEXTO = "src/palabras.txt"
        private const val RUTA_JSON = "src/palabras.json"
        private const val ES_JSON = true


        private fun leerFicheroTexto(ruta: String): List<String> = File(ruta).readLines()

        private fun leerFicheroJSON(ruta: String): List<String> {
            val json = File(ruta).readText()
            return Gson().fromJson(json, Palabras::class.java).palabras
        }

        open fun obtenerPalabraAleatoria(): String {

            val leerFichero = leerFicheroTexto(RUTA_TEXTO)
            val numPalabras = leerFichero.size

            var palabraAleatoria: String = leerFichero[(0..numPalabras).random()]
            return palabraAleatoria

        }
    }

}