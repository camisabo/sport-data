/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * @author Omar Nicolas Guerrero
 * @param <T> es un dato abstracto que admite cualquier tipo de dato
 * 
 */
public class Nodo <T extends Comparable<T>> {
    private Nodo <T> NodoSiguiente;
    private Nodo <T> NodoAnterior;
    public T dato;
    
    //contructor
    public Nodo(T dato){
        this.dato = dato;
    }
    
    
    // getters
    /**
     * 
     * @return El nodo que le sigue al nodo actual.
     */    
    Nodo <T> getNodoSiguiente() {
        return NodoSiguiente;
    }

    /**
     * 
     * @return El nodo que precede al actual.
     */
    Nodo <T> getNodoAnterior() {
        return NodoAnterior;
    }

    /**
     * 
     * @return El dato almacenado en el nodo.
     */    
    public T getDato() {
        return dato;
    }

    
    //setters

    /**
     * 
     * @param NodoSiguiente Nodo por el que se va a cambiar el "NodoSiguiente"
     */
    void setNodoSiguiente(Nodo<T> NodoSiguiente) {
        this.NodoSiguiente = NodoSiguiente;
    }

    /**
     * 
     * @param NodoAnterior Nodo por el cual se va a cambiar el "NodoAnterior"
     */
    void setNodoAnterior(Nodo<T> NodoAnterior) {
        this.NodoAnterior = NodoAnterior;
    }

    /**
     * 
     * @param dato Dato (del mismo tipo) por el que se va a cambiar el dato actual
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

      
}
