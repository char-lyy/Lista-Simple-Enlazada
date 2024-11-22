package listas_genericas;

import entidades.Persona;

/**
 * Representa un nodo simple de una estructura de datos enlazada.
 *
 * @author Carlos Álvarez
 */
public class NodoSimple {

    private Persona dato;
    private NodoSimple siguiente;

    public NodoSimple(Persona dato) {
        this.dato = dato;
    }

    public Persona getDato() {
        return dato;
    }

    public void setDato(Persona dato) {
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
