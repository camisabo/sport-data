/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * @author Omar Nicolas Guerrero
 * @param <T>
 */
public class ListaDoblementeEnlazada<T extends Comparable<T>> extends ListaEnlazada<T> {
    
    
    public ListaDoblementeEnlazada(T dato) {
        super(dato);
    }

    @Override
    public void borrar() {
        super.borrar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(int posicion) {
        tamaño--;
        Nodo nodoActual = primerNodo;
        
        //si hay solo un elemento
        if (nodoActual.getNodoSiguiente() == null){
            nodoActual.setDato(null);
        }
        
        //si la posicion es menor que o igual a cero
        else if (1 > posicion){
            primerNodo = primerNodo.getNodoSiguiente();
            nodoActual.setDato(null);
            nodoActual.setNodoSiguiente(null);
        }
    }
    
    
    @Override
    public void insertar(T nuevoDato) {
        tamaño++;
        Nodo nodoActual = primerNodo;
        Nodo nuevoNodo = new Nodo(nuevoDato);   
        
        while (nodoActual.getNodoSiguiente() != null){
            nodoActual= nodoActual.getNodoSiguiente();
        }
        
        nodoActual.setNodoSiguiente(nuevoNodo);
        nuevoNodo.setNodoAnterior(nodoActual);
    }

    

    @Override
    public void insertar(T nuevoDato, int posicion) {
        super.insertar(nuevoDato, posicion); //To change body of generated methods, choose Tools | Templates.
    }

    
}
