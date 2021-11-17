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

    /**
     * verifica que la pila esta vacia
     * @return "true" si pila esta vacia
     */

    @Override //interface 
    public boolean empty(){
        return top == null;
    }

    /**
     * verifica si la pila esta llena
     * @return "true" si la pila esta llena (en este caso no puede pasar)
     */
    @Override
    public boolean full(){
        return false;
    }

    /**
     * Coloca un dato, mediante un nodo, en la ultima posicion de la pila
     * @param dato Dato a colocar en la pila
     */
    @Override
    public void insertar(T dato){

        Nodo<T> nuevo_nodo = new Nodo<T>(dato);
        nuevo_nodo.setNodoSiguiente(top);
        top = nuevo_nodo;
    }

    /**
     * Elimina el ultimo dato de la pila
     * @return el ultimo dato de la pila
     */
    @Override
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
