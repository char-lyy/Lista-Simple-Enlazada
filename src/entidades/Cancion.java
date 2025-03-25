package entidades;

import utilidades.GestorEntradaConsola;

/**
 * Representa una cancion que se puede escuchar en un reproductor de musica
 *
 * @author carlos
 */
public class Cancion implements Comparable {

    private String titulo;
    private String artista;
    private float duracion;
    private String genero;

    public Cancion() {
    }

    public Cancion(String titulo, String artista, float duracion, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.genero = genero;
    }

    /**
     * Compara dos canciones por su titulo lexicograficamente
     *
     * @param o objeto a comparar
     * @return verdadero si los titulos son lexicograficamente iguales. False
     * caso contrario
     */
    @Override
    public int compareTo(Object o) {
        Cancion otraCancion = (Cancion) o;
        return titulo.compareTo(otraCancion.titulo);
    }

    @Override
    public String toString() {
        return "Cancion{" + "titulo=" + titulo + ", artista=" + artista + ", duracion=" + duracion + ", genero=" + genero + '}';
    }

    /**
     * Carga los datos de esta cancion interactuando con el usuario mediante la
     * consola.
     *
     * @return La instancia actualizada de la cancion.
     */
    public Cancion cargarDatos() {

        cargarTitulo();
        cargarArtista();
        cargarDuracion();
        cargarGenero();

        return this;
    }

    /**
     * Solicita al usuario el ingreso del titulo de la cancion.
     *
     * Un titulo es válido si no está vacío ni compuesto únicamente de espacios
     * en blanco.
     *
     * @return El titulo ingresado.
     */
    public String cargarTitulo() {
        boolean esValido = false;
        while (!esValido) {
            System.out.print("Titulo: ");
            titulo = GestorEntradaConsola.leerString();
            esValido = !titulo.trim().isEmpty();
        }
        return titulo;
    }

    /**
     * Solicita al usuario el ingreso del artista de la cancion.
     *
     * Un artista es válido si no está vacío ni compuesto únicamente de espacios
     * en blanco.
     *
     * @return El artista ingresado.
     */
    public String cargarArtista() {
        boolean esValido = false;
        while (!esValido) {
            System.out.print("Artista: ");
            artista = GestorEntradaConsola.leerString();
            esValido = !artista.trim().isEmpty();
        }
        return artista;
    }

    /**
     * Solicita al usuario el ingreso de la duracion en minutos de la cancion.
     *
     * La duración de una cancion es válida si es mayor a 0
     *
     * @return La duración de la canción.
     */
    public float cargarDuracion() {
        boolean esValido = false;
        while (!esValido) {
            System.out.print("Duracion (En minutos): ");
            duracion = GestorEntradaConsola.leerFlotante();
            esValido = duracion > 0;
        }
        return duracion;
    }

    /**
     * Solicita al usuario el ingreso del genero de la cancion.
     *
     * Un genero es válido si no está vacío ni compuesto únicamente de espacios
     * en blanco.
     *
     * @return El genero ingresado.
     */
    public String cargarGenero() {
        boolean esValido = false;
        while (!esValido) {
            System.out.print("Genero: ");
            genero = GestorEntradaConsola.leerString();
            esValido = !genero.trim().isEmpty();
        }
        return genero;
    }

    /**
     * Permite actualizar los datos de una interactuando con el usuario.
     *
     * Este método presenta un menú que permite al usuario seleccionar qué campo
     * desea modificar (excepto la duracion). Los cambios se aplican
     * inmediatamente al campo seleccionado, y el usuario puede continuar
     * editando otros campos hasta que confirme salir del proceso.
     */
    public void actualizarDatos() {
        boolean confirmar = false;

        do {
            System.out.println("Actualizar cancion");
            System.out.println("1. Modificar titulo");
            System.out.println("2. Modificar artista");
            System.out.println("3. Modificar genero");
            System.out.println("0. Confirmar y Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = GestorEntradaConsola.leerEntero();

            switch (opcion) {
                case 1:
                    System.out.println("Titulo actual: " + titulo);
                    System.out.println("Actualizando titulo...");
                    cargarTitulo();
                    break;
                case 2:
                    System.out.println("Artista actual: " + artista);
                    System.out.println("Actualizando artista...");
                    cargarArtista();
                    break;
                case 3:
                    System.out.println("Genero actual: " + genero);
                    System.out.println("Actualizando genero...");
                    cargarGenero();
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

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public float getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    /**
     * Establece el titulo de una cancion.
     *
     * Un titulo es válido si no está vacío ni compuesto únicamente de espacios
     * en blanco.
     *
     * @param titulo El nuevo titulo de la canción.
     * @throws IllegalArgumentException Si el nombre proporcionado no es válido.
     */
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede estar vacío.");
        }
        this.titulo = titulo;
    }

    /**
     * Establece el artista de una cancion.
     *
     * Un artista es válido si no está vacío ni compuesto únicamente de espacios
     * en blanco.
     *
     * @param artista El nuevo artista de la canción.
     * @throws IllegalArgumentException Si el nombre proporcionado no es válido.
     */
    public void setArtista(String artista) {
        if (artista == null || artista.trim().isEmpty()) {
            throw new IllegalArgumentException("El artista no puede estar vacío.");
        }
        this.artista = artista;
    }

    /**
     * Establece la duración de una persona.
     *
     * La duración de una canción es válida si es un flotante positivo mayor a
     * 0.
     *
     * @param duracion La nueva duración de la cancion.
     * @throws IllegalArgumentException Si la duración proporcionada no es
     * válida.
     */
    public void setDuración(float duracion) {
        if (!(duracion > 0)) {
            throw new IllegalArgumentException("La duracion debe ser mayor a 0.");
        }
        this.duracion = duracion;
    }

    /**
     * Establece el genero de una cancion.
     *
     * Un genero es válido si no está vacío ni compuesto únicamente de espacios
     * en blanco.
     *
     * @param genero El nuevo genero de la canción.
     * @throws IllegalArgumentException Si el nombre proporcionado no es válido.
     */
    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("El genero no puede estar vacío.");
        }
        this.genero = genero;
    }

}
