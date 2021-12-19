/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * @author Omar Nicolas Guerrero
 * @param <T> tipo de dato a ingresar
 */
public class NodoArbol <T extends Comparable<T>> {
    
    //atributos
    
    private NodoArbol <T> nodoPadre;
    private NodoArbol <T> nodoHijoDerecha;
    private NodoArbol <T> nodoHijoIzquierda;
    private int altura = 0;
    private T dato;
    
    //constructor

    public NodoArbol(T dato) {
        this.dato = dato;
    }
    
    //getters y setters

    public NodoArbol <T> getNodoPadre() {
        return nodoPadre;
    }

    public void setNodoPadre(NodoArbol <T> nodoPadre) {
        this.nodoPadre = nodoPadre;
    }

    public NodoArbol <T> getNodoHijoDerecha() {
        return nodoHijoDerecha;
    }

    public void setNodoHijoDerecha(NodoArbol <T> nodoHijoDerecha) {
        this.nodoHijoDerecha = nodoHijoDerecha;
    }

    public NodoArbol <T> getNodoHijoIzquierda() {
        return nodoHijoIzquierda;
    }

    public void setNodoHijoIzquierda(NodoArbol <T> nodoHijoIzquierda) {
        this.nodoHijoIzquierda = nodoHijoIzquierda;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public T getDato() { 
        return dato;
    }
    

    public void setDato(T dato) {
        this.dato = dato;
    }
    
    
    
}
