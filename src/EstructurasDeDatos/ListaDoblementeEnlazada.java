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
    //atributos
    Nodo<T> ultimoNodo;

    public ListaDoblementeEnlazada(T dato) {
        super(dato);
        this.ultimoNodo = primerNodo;
    }

    @Override
    public void eliminar() {
        tamaño--;
        Nodo<T> nodoActual = ultimoNodo;
        
        //si solo hay un dato
        if (nodoActual.getNodoAnterior()==null){
            nodoActual.setDato(null);
            tamaño = 0;
        }
        
        //en un caso normal
        else{
            nodoActual.setDato(null);
            nodoActual = nodoActual.getNodoAnterior(); 
            nodoActual.setNodoSiguiente(null);
            ultimoNodo = nodoActual;
        }
        
    }

    @Override
    public void eliminar(int posicion) {
        Nodo<T> nodoActual = primerNodo;
        
        //si hay solo un elemento
        if (nodoActual.getNodoSiguiente() == null){
            nodoActual.setDato(null);
            tamaño = 0;
        }
        
        //si la posicion es menor que o igual a cero
        else if (1 > posicion){
            primerNodo = primerNodo.getNodoSiguiente();
            nodoActual.setDato(null);
            nodoActual.setNodoSiguiente(null);
        }

        else if (posicion==tamaño){
            eliminar();
        }

        //en un caso normal
        else {
            //verificamos que la posicion existe
            if (posicion>tamaño){
                eliminar();
            }

            //si es mas efectivo por la cabeza
            else if (posicion <= ((int)(tamaño/2))){
                for(int i = 0; i< posicion-1;i++){  // apuntador anterior a la posición a eliminar
                    nodoActual = nodoActual.getNodoSiguiente();
                }

                //se quita la referencia al nodo seleccionado
                nodoActual.setNodoSiguiente((nodoActual.getNodoSiguiente()).getNodoSiguiente());
                (nodoActual.getNodoSiguiente()).setNodoAnterior(nodoActual);
            } 
            //si es más efectivo por la cola
            else {
                nodoActual = ultimoNodo;
                for(int i = tamaño; i> posicion+1;i--){  // apuntador siguiente a la posición a eliminar
                    nodoActual = nodoActual.getNodoAnterior();
                }
                
                //se quita la referencia al nodo seleccionado
                ((nodoActual.getNodoAnterior()).getNodoAnterior()).setNodoSiguiente(nodoActual);
                nodoActual.setNodoAnterior((nodoActual.getNodoAnterior()).getNodoAnterior());

            }
        }
        tamaño--;
    }
    
    
    @Override
    public void insertar(T nuevoDato) {
        tamaño++;
        Nodo<T> nodoActual = ultimoNodo;
        Nodo<T> nuevoNodo = new Nodo(nuevoDato);   
        
        nodoActual.setNodoSiguiente(nuevoNodo);
        nuevoNodo.setNodoAnterior(nodoActual);
        ultimoNodo=nuevoNodo;
    }

    
    @Override
    public void insertar(T nuevoDato, int posicion) {
        Nodo<T> nodoActual = primerNodo;
        Nodo<T> nuevoNodo = new Nodo<>(nuevoDato);
        //si hay solo un elemento
        if (nodoActual.getNodoSiguiente() == null){
            insertar(nuevoDato);
            tamaño--;
        }
        
        //si la posicion es menor que o igual a cero
        else if (1 > posicion){
            nuevoNodo.setNodoSiguiente(primerNodo);
            primerNodo.setNodoAnterior(nuevoNodo);
            primerNodo = nuevoNodo;
            
        }

        //si la posicion es igual al tamaño
        else if (posicion==tamaño){
            (ultimoNodo.getNodoAnterior()).setNodoSiguiente(nuevoNodo);
            nuevoNodo.setNodoAnterior(ultimoNodo.getNodoAnterior());
            nuevoNodo.setNodoSiguiente(ultimoNodo);
            ultimoNodo.setNodoAnterior(nuevoNodo);
        }

        //en un caso normal
        else {
            //verificamos que la posicion existe
            if (posicion>tamaño){
                insertar(nuevoDato);
                tamaño--;
            }

            //si es mas efectivo por la cabeza
            else if (posicion <= ((int)(tamaño/2))){
                for(int i = 0; i< posicion-1;i++){  // apuntador anterior a la posición a añadir
                    nodoActual = nodoActual.getNodoSiguiente();
                }
                nuevoNodo.setNodoSiguiente(nodoActual.getNodoSiguiente());
                nodoActual.setNodoSiguiente(nuevoNodo);
                nuevoNodo.setNodoAnterior(nodoActual);
                (nuevoNodo.getNodoSiguiente()).setNodoAnterior(nuevoNodo);

            } 
            //si es más efectivo por la cola
            else {
                nodoActual = ultimoNodo;
                for(int i = tamaño; i> posicion+1;i--){  // apuntador siguiente a la posición a insertar
                    nodoActual = nodoActual.getNodoAnterior();
                }
                nuevoNodo.setNodoAnterior(nodoActual.getNodoAnterior());
                nodoActual.setNodoAnterior(nuevoNodo);
                (nuevoNodo.getNodoAnterior()).setNodoSiguiente(nuevoNodo);
                nuevoNodo.setNodoSiguiente(nodoActual);

            }
        }
        tamaño++;
    }

    
    public T buscar (int posicion) {
        Nodo<T> nodoActual = primerNodo;
        Boolean buscando = true;
        int posicionActual = 0;

        //si es mas efectivo por la cabeza
        if (posicion <= ((int)(tamaño/2))){
            while(buscando){
                if (posicionActual == posicion) {
                    buscando = false;
                    return nodoActual.getDato();
                } else {
                    nodoActual = nodoActual.getNodoSiguiente();
                    posicionActual++;
                }
            }
        } 
        //si es más efectivo por la cola
        else {
            nodoActual = ultimoNodo;
            posicionActual = tamaño;
            while(buscando){
                if (posicionActual == posicion) {
                    buscando = false;
                    return nodoActual.getDato();
                } else {
                    nodoActual = nodoActual.getNodoAnterior();
                    posicionActual--;
                }
            }
            
        }

        return null;
    }
}
