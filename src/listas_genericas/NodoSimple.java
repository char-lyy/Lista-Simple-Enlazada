package listas_genericas;

import entidades.Cancion;


/**
 * Representa un nodo simple de una estructura de datos enlazada.
 *
 * @author Carlos Álvarez
 */
public class NodoSimple {

    private Cancion dato;
    private NodoSimple siguiente;

    public NodoSimple(Cancion dato) {
        this.dato = dato;
    }

    public Cancion getDato() {
        return dato;
    }

    public void setDato(Cancion dato) {
        this.dato = dato;
    }

    public NodoSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "NodoSimple{" + "dato=" + dato + ", siguiente=" + siguiente + '}';
    }

}
