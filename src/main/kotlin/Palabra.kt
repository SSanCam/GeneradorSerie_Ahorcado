import com.google.gson.Gson
import java.io.File

class Palabra(private val consola: GestorConsola, private val palabras: List<String>) : IPalabra {

    companion object {
        const val RUTA_TEXTO = "src/palabras.txt"
        const val RUTA_JSON = "src/palabras.json"
        const val ES_JSON = true

        data class Palabras(val palabras: List<String>)
    }

    override fun obtenerPalabraAleatoria(): TipoArchivo {
        return TODO("Llamar a funcion de lectura segun el tipo de archivo.")
    }

    private fun leerJson(): String {
        TODO("Devolver una palabra del archivo")
    }

    private fun leerTxt(): String {
        TODO("Devolver una palabra del archivo de texto")
    }
}