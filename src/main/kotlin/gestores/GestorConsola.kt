package gestores
import interfaces.IEntradaSalida

/**
 * Gestor consola
 *
 */
class GestorConsola : IEntradaSalida {
    override fun pedirOpcion(): Int? {
        var opcion: Int? = null
        try {
            do {
                opcion = pedirDato("\nPor favor, selecciona opción: ")?.toInt()
            } while (opcion.toString().isBlank() || opcion !in 1..3)

        } catch (e: IllegalArgumentException) {
            mostrarInformacion("Ésa opción no está disponible.")
        }
        return opcion
    }

    override fun pedirDato(mensaje: String): String? {
        try {
            if (mensaje.isNotBlank()) {
                mostrarInformacion(mensaje)
            }
        } catch (e: Exception) {
            mostrarInformacion("ERROR al recibir los datos del usuario.")
        }
        return readLine()
    }

    override fun pedirLetra(): String? {
        var letra: String? = null
        try {
            do {
                letra = pedirDato("Intenta con una letra:\n")
            }while (letra == null || letra.length != 1 || letra.isEmpty())
        }catch (e: IllegalArgumentException){
            mostrarInformacion("Debes introducir una única letra.")
        }
        return letra?.lowercase()
    }

    override fun <T> mostrarInformacion(mensaje: T) {
        println(mensaje)
    }

    override fun limpiar(lineas: Int) {
        for (linea in 1..lineas) {
            mostrarInformacion("")
        }
    }

    override fun pausa() {
        Thread.sleep(100)
    }
}