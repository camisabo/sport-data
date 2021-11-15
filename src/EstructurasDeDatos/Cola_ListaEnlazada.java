package EstructurasDeDatos;

import javax.management.RuntimeErrorException;

public class Cola_ListaEnlazada<T extends Comparable<T>> implements Interfaz<T>{

    // Atributos

    private Nodo<T> cabeza,cola;

    // Constructor

    public Cola_ListaEnlazada(){
        cabeza = null;
        cola = null;
    }

    // Metodos

    public boolean empty(){
        return cola == null;
    }

    public boolean full(){
        return false;
    }

    public void insertar(T dato){

        Nodo<T> nuevo_nodo = new Nodo<T>(dato);
        if(empty())
            cabeza = nuevo_nodo;
        else
            cola.setNodoSiguiente(nuevo_nodo);
        cola = nuevo_nodo;
    }

    public T eliminar(){

        T dato = null;
        if(empty())
            throw new RuntimeErrorException(null, "La cola está vacía");
        else{
            dato = cabeza.getDato();
            cabeza = cabeza.getNodoSiguiente();
            
        }
        return dato;
    }

}