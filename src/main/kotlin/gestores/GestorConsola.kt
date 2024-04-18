package gestores
import interfaces.IEntradaSalida

/**
 * Gestor consola
 *
 * Clase que gestiona la entrada y salida de datos por consola.
 */
class GestorConsola : IEntradaSalida {

    /**
     * Pide al usuario que seleccione una opción del menú.
     * @return La opción seleccionada por el usuario.
     */

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


    /**
     * Pide al usuario un dato específico.
     * @param mensaje Mensaje a mostrar al usuario.
     * @return El dato ingresado por el usuario.
     */
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


    /**
     * Pide al usuario que ingrese una letra.
     * @return La letra ingresada por el usuario.
     */
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

    /**
     * Muestra un mensaje por consola.
     * @param mensaje El mensaje a mostrar.
     */
    override fun <T> mostrarInformacion(mensaje: T) {
        println(mensaje)
    }

    /**
     * Limpia la consola.
     * @param lineas El número de líneas a limpiar.
     */
    override fun limpiar(lineas: Int) {
        for (linea in 1..lineas) {
            mostrarInformacion("")
        }
    }

    /**
     * Pausa la ejecución del programa.
     */
    override fun pausa() {
        Thread.sleep(100)
    }
}