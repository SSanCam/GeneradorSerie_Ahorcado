import com.google.gson.Gson
import java.io.File

/**
 * Palabra
 * Obtendrá una palabra de un archivo, según su tipo
 */
class Palabra() : IPalabra {


    companion object {
        // Definimos la ruta del archivo
        const val RUTA_TEXTO = "src/palabras.txt"
        const val RUTA_JSON = "src/palabras.json"
        const val ES_JSON = true

        // Clase de datos interna que representa una lista de palabras.
        data class Palabras(val palabras: List<String>)
    }

    /**
     * Obtener palabra aleatoria
     * @return String Devuelve una palabra aleatoria sacada de la lista de palabras que hay en el archivo..
     */
    override fun obtenerPalabraAleatoria(): String {
        val palabraAleatoria = if (ES_JSON) {
            leerJson()
        } else {
            leerTxt()
        }
        return palabraAleatoria.random()
    }


    /**
     * Leer JSON
     * Función privada para la lectura del archivo JSON
     * @return List<String> Devuelve una lista con las palabras encontradas en el archivo.
     */
    private fun leerJson(): List<String> {
        val json = File(RUTA_JSON).readText()
        val palabras = Gson().fromJson(json, Palabras::class.java)
        return palabras.palabras
    }

    /**
     * Leer TXT
     * Función privada para la lectura del archivo Txt
     * @return List<String> Devuelve una lista con las palabras encontradas en el archivo.
     */
    private fun leerTxt(): List<String> {
        return File(RUTA_TEXTO).readLines()
    }
}