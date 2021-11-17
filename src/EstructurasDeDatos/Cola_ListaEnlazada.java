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

    /**
     * Verifica si la cola esta vacia
     * @return "true" si la cola esta vacia
     */

    @Override
    public boolean empty(){
        return cola == null;
    }

    /**
     * verifica si la cola esta llena
     * @return "true" si la cola esta llena (en este caso no puede pasar)
     */
    @Override
    public boolean full(){
        return false;
    }

    /**
     * Coloca un dato, mediante un nodo, en la ultima posicion de la cola
     * @param dato Dato a colocar en la cola
     */
    @Override
    public void insertar(T dato){

        Nodo<T> nuevo_nodo = new Nodo<T>(dato);
        if(empty())
            cabeza = nuevo_nodo;
        else
            cola.setNodoSiguiente(nuevo_nodo);
        cola = nuevo_nodo;
    }

    /**
     * Elimina el primer dato de la cola
     * @return el perimer dato de la cola
     */
    @Override
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