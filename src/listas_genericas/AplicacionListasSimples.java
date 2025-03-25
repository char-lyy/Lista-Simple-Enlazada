package listas_genericas;

import entidades.Cancion;
import utilidades.GestorEntradaConsola;
import utilidades.GestorSalidaConsola;

/**
 * Ejemplo de Aplicacion de Listas Simples Enlazadas.
 *
 * @author Carlos Álvarez
 */
public class AplicacionListasSimples {

    private static final int LIMITES_CARACTER_CONSOLA = 120;
    private ListaSimple listaCanciones;

    void inicializar() {
        listaCanciones = new ListaSimple();
    }

    void cargarCasosDePrueba() {

        Cancion c1 = new Cancion("Mostly Clear Skies", "True Lust", 2.47f, "Rock");
        Cancion c2 = new Cancion("War Inside My Head", "Suicidal Tendencies", 4.57f, "Trash");
        Cancion c3 = new Cancion("Flor de lino", "Horacio Molina", 3.33f, "Vals");
        Cancion c4 = new Cancion("Stargezer", "Rainbow", 8.27f, "Neo-Classical Rock");
        Cancion c5 = new Cancion("Bohemian Rhapsody", "Queen", 5.55f, "Rock");
        Cancion c6 = new Cancion("Stairway to Heaven", "Led Zeppelin", 8.02f, "Rock");
        Cancion c7 = new Cancion("Toccata and Fugue", "J.S. Bach", 5.01f, "Baroque");


        listaCanciones.insertarFrente(c1);
        listaCanciones.insertarFrente(c2);
        listaCanciones.insertarFrente(c3);
        listaCanciones.insertarFrente(c4);
        listaCanciones.insertarFrente(c5);
        listaCanciones.insertarFrente(c6);
        listaCanciones.insertarFrente(c7);

    }

    void menu() {
        int opcion;

        do {
            mostrarOpciones();
            switch (opcion = GestorEntradaConsola.leerEntero()) {
                case 1:
                    cargarNuevaCancion();
                    break;
                case 2:
                    listaCanciones.mostrar();
                    break;
                case 3:
                    listarTabulado();
                    break;
                case 4:
                    actualizarPersona();
                    break;
                case 5:
                    eliminarCanciones();
                    break;
                case 6:
                    listarCancionesMenoresQue5();
                    break;
            }
        } while (opcion != 0);
    }

    void mostrarOpciones() {
        System.out.println("*** App Listas Simples ***");
        System.out.println("1. Cargar cancion");
        System.out.println("2. Listar canciones");
        System.out.println("3. Listar canciones (Formato tabla)");
        System.out.println("4. Actualizar cancion");
        System.out.println("5. Eliminar cancion");
        System.out.println("6. Listar canciones con duracion menor a 5 minutos");
        System.out.println("0. Salir");
    }

    void cargarNuevaCancion() {

        do {
            Cancion nuevaCancion = new Cancion();
            nuevaCancion.cargarDatos();
            listaCanciones.insertarFrente(nuevaCancion);
        } while (GestorEntradaConsola.confirmar());

    }

    /**
     * Lista de forma tabulada los datos de los nodos de una lista simple
     * enlazada
     */
    void listarTabulado() {
        GestorSalidaConsola.generarTitulosColumnas(Cancion.class, LIMITES_CARACTER_CONSOLA);
        NodoSimple actual = listaCanciones.getPrimero();
        while (actual != null) {

            GestorSalidaConsola.mostrarTabulado(actual.getDato().getClass(), actual.getDato(), LIMITES_CARACTER_CONSOLA);
            actual = actual.getSiguiente();
        }
    }

    /**
     * Actualiza los datos de una persona dado su DNI.
     */
    void actualizarPersona() {

        Cancion cancionBuscada = new Cancion();
        cancionBuscada.cargarTitulo();
        NodoSimple nodoBuscado = listaCanciones.buscar(cancionBuscada);

        if (nodoBuscado != null) {

            nodoBuscado.getDato().actualizarDatos();

        } else {

            System.out.println("La cancion no se encuentra en la lista");

        }

    }

    /**
     * Elimina una persona de una lista simple enlazada hasta que el usuario
     * desee no continuar
     */
    void eliminarCanciones() {
        do {
            Cancion cancionBuscada = new Cancion();
            cancionBuscada.cargarTitulo();
            NodoSimple nodoBuscado = listaCanciones.eliminar(cancionBuscada);

            if (nodoBuscado != null) {

                System.out.println("La cancion: ");
                GestorSalidaConsola.mostrarTabulado(Cancion.class, nodoBuscado.getDato(), LIMITES_CARACTER_CONSOLA);
                System.out.println("Fue quitada de la lista");

            } else {

                System.out.println("La cancion no se encuentra en la lista");

            }

        } while (GestorEntradaConsola.confirmar());
    }

    void listarCancionesMenoresQue5() {

        NodoSimple nodoActual = listaCanciones.getPrimero();

        while (nodoActual != null) {

            if (nodoActual.getDato().getDuracion() < 5.00) {
                System.out.println(nodoActual.getDato().toString());
            }
            nodoActual = nodoActual.getSiguiente();
        }

    }

    public static void main(String[] args) {

        AplicacionListasSimples app = new AplicacionListasSimples();
        app.inicializar();
        app.cargarCasosDePrueba();
        app.menu();
    }

}
