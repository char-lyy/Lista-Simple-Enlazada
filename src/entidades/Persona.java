package entidades;

import java.time.LocalDate;
import utilidades.GestorEntradaConsola;

/**
 * Representa una persona con atributos básicos como DNI, nombre completo,
 * domicilio y fecha de nacimiento. Proporciona métodos para cargar datos desde
 * la consola, compararse con otras personas por su DNI y generar una
 * representación textual de sí misma.
 *
 * Esta clase implementa la interfaz {@code Comparable} para facilitar el
 * ordenamiento por DNI de objetos de tipo Persona.
 *
 * @author Carlos Álvarez
 */
public class Persona {

    private long dni;
    private String nombreCompleto;
    private String domicilio;
    private int edad;

    public Persona(long dni, String nombreCompleto, String domicilio, int edad) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.edad = edad;
    }

    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", domicilio=" + domicilio + ", edad=" + edad + '}';
    }

    /**
     * Carga los datos de la persona interactuando con el usuario mediante la
     * consola.
     *
     * @return La instancia actualizada de la persona.
     */
    public Persona cargarDatos() {

        cargarDni();
        cargarNombreCompleto();
        cargarDomicilio();
        cargarEdad();
        return this;
    }

    /**
     * Solicita al usuario el ingreso del DNI de la persona.
     *
     * Un DNI es válido si es un número entero positivo mayor a 0.
     *
     * @return El DNI ingresado.
     */
    public long cargarDni() {
        boolean esValido = false;
        while (!esValido) {
            System.out.print("DNI: ");
            dni = GestorEntradaConsola.leerLong();
            esValido = dni > 0;
        }
        return dni;
    }

    /**
     * Solicita al usuario el ingreso del nombre completo de la persona.
     *
     * Un nombre completo es válido si no está vacío ni compuesto únicamente de
     * espacios en blanco.
     *
     * @return El nombre completo ingresado.
     */
    public String cargarNombreCompleto() {
        boolean esValido = false;
        while (!esValido) {
            System.out.print("Nombre Completo: ");
            nombreCompleto = GestorEntradaConsola.leerString();
            esValido = !nombreCompleto.trim().isEmpty();
        }
        return nombreCompleto;
    }

    /**
     * Solicita al usuario el ingreso del domicilio de la persona.
     *
     * Un domicilio es válido si no está vacío ni compuesto únicamente de
     * espacios en blanco.
     *
     * @return El domicilio ingresado.
     */
    public String cargarDomicilio() {
        boolean esValido = false;
        while (!esValido) {
            System.out.print("Domicilio: ");
            domicilio = GestorEntradaConsola.leerString();
            esValido = !domicilio.trim().isEmpty();
        }
        return domicilio;
    }

    /**
     * Solicita al usuario el ingreso de la edad de la persona.
     *
     * Una edad es válida si es un número entero positivo mayor a 0.
     *
     * @return La edad ingresada.
     */
    public long cargarEdad() {
        boolean esValido = false;
        while (!esValido) {
            System.out.print("Edad: ");
            edad = GestorEntradaConsola.leerEntero();
            esValido = dni > 0;
        }
        return edad;
    }

    /**
     * Permite actualizar los datos de la persona interactuando con el usuario.
     *
     * Este método presenta un menú que permite al usuario seleccionar qué campo
     * desea modificar (excepto el DNI y fecha de nacimiento, que no se puede
     * cambiar). Los cambios se aplican inmediatamente al campo seleccionado, y
     * el usuario puede continuar editando otros campos hasta que confirme salir
     * del proceso.
     */
    public void actualizarDatos() {
        boolean confirmar = false;

        do {
            System.out.println("Actualizar Datos de Persona");
            System.out.println("1. Modificar Nombre Completo");
            System.out.println("2. Modificar Domicilio");
            System.out.println("0. Confirmar y Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = GestorEntradaConsola.leerEntero();

            switch (opcion) {
                case 1:
                    System.out.println("Nombre actual: " + nombreCompleto);
                    System.out.println("Actualizando Nombre Completo:");
                    cargarNombreCompleto();
                    break;
                case 2:
                    System.out.println("Domicilio actual: " + nombreCompleto);
                    System.out.println("Actualizando Domicilio:");
                    cargarDomicilio();
                    break;
                case 0:
                    System.out.println("¿Desea confirmar los cambios? (S/N): ");
                    String confirmarInput = GestorEntradaConsola.leerString().trim().toUpperCase();
                    confirmar = confirmarInput.equals("S");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (!confirmar);

        System.out.println("Datos actualizados!");
    }

    public long getDni() {
        return dni;
    }

    /**
     * Establece el número de identificación personal (DNI) de la persona.
     *
     * Un DNI es válido si es un número entero positivo mayor a 0.
     *
     * @param dni El nuevo DNI de la persona.
     * @throws IllegalArgumentException Si el DNI proporcionado no es válido.
     */
    public void setDni(long dni) {
        if (dni <= 0) {
            throw new IllegalArgumentException("El DNI debe ser un número positivo mayor a 0.");
        }
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo de la persona.
     *
     * Un nombre es válido si no está vacío ni compuesto únicamente de espacios
     * en blanco.
     *
     * @param nombreCompleto El nuevo nombre completo de la persona.
     * @throws IllegalArgumentException Si el nombre proporcionado no es válido.
     */
    public void setNombreCompleto(String nombreCompleto) {
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre completo no puede estar vacío.");
        }
        this.nombreCompleto = nombreCompleto;
    }

    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Establece el domicilio de la persona.
     *
     * Un domicilio es válido si no está vacío ni compuesto únicamente de
     * espacios en blanco.
     *
     * @param domicilio El nuevo domicilio de la persona.
     * @throws IllegalArgumentException Si el domicilio proporcionado no es
     * válido.
     */
    public void setDomicilio(String domicilio) {
        if (domicilio == null || domicilio.trim().isEmpty()) {
            throw new IllegalArgumentException("El domicilio no puede estar vacío.");
        }
        this.domicilio = domicilio;
    }

    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de una persona.
     *
     * Una es válida si es un número entero positivo mayor a 0.
     *
     * @param edad La nueva edad de la persona.
     * @throws IllegalArgumentException Si la edad proporcionado no es válido.
     */
    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser un número positivo mayor a 0.");
        }
        this.edad = edad;
    }

}
