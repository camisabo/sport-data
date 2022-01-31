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
public class ListaCircularSimple<T extends Comparable<T>> extends ListaEnlazada<T>  {
    
    public ListaCircularSimple(T dato) {
        super(dato);
        this.primerNodo.setNodoSiguiente(primerNodo);
    }

    @Override
    public void eliminar(T datoABorrar) {
        tamaño--;
        Nodo<T> nodoActual = primerNodo;
        boolean estaElDato = buscar(datoABorrar);
        if (estaElDato == false){
            System.out.println("No se encuentra "+datoABorrar+" en "+this);
            tamaño++;
        }
        
        //si hay solo un elemento y se encuentra el dato
        else if (nodoActual.getNodoSiguiente() == primerNodo){
            nodoActual.setDato(null);
        }
        
        
        do {            
            if ((nodoActual.getNodoSiguiente()).getDato().compareTo(datoABorrar) == 0){
                nodoActual.setNodoSiguiente((nodoActual.getNodoSiguiente())
                        .getNodoSiguiente());
                break;
            }
            else
                nodoActual = nodoActual.getNodoSiguiente();
        } while (estaElDato == true);
        
    }

    @Override
    public void eliminar(int posicion) {
        
    }

    @Override
    public void insertar(T nuevoDato) {
        
    }

    @Override
    public void insertar(T nuevoDato, int posicion) {
        
    }
    
    
    
}
