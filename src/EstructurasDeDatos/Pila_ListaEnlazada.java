package EstructurasDeDatos;

import javax.management.RuntimeErrorException;

public class Pila_ListaEnlazada<T extends Comparable<T>> implements Interfaz<T>  {

    // Atributos

    private Nodo<T> top;

    // Constructor

    public Pila_ListaEnlazada(){
        top = null;
    }

    // Metodos

    public boolean empty(){
        return top == null;
    }

    public boolean full(){
        return false;
    }

    public void insertar(T dato){

        Nodo<T> nuevo_nodo = new Nodo<T>(dato);
        nuevo_nodo.setNodoSiguiente(top);
        top = nuevo_nodo;
    }

    public T eliminar(){

        T dato = null;
        if(empty())
            throw new RuntimeErrorException(null, "La pila está vacía");
        else{

            dato = top.getDato();
            top = top.getNodoSiguiente();

        }
        return dato;

    }
    
}
