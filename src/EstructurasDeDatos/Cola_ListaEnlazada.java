package EstructurasDeDatos;

import javax.management.RuntimeErrorException;

public class Cola_ListaEnlazada<T extends Comparable<T>> extends ListaEnlazada<T>{

    // Atributos

    private Nodo<T> ultimoNodo;

    // Constructor
    public Cola_ListaEnlazada(){
        super();
        this.ultimoNodo=primerNodo;
    }
    public Cola_ListaEnlazada(T dato){
        super(dato);
        this.ultimoNodo = primerNodo;
    }

    // Metodos

    /**
     * Verifica si la cola esta vacia
     * @return "true" si la cola esta vacia
     */

    @Override
    public boolean empty(){
        return ultimoNodo == null;
    }

    /**
     * Coloca un dato, mediante un nodo, en la ultima posicion de la cola
     * @param dato Dato a colocar en la cola
     */
    @Override
    public void insertar(T dato){

        tamaño++;
        Nodo<T> nuevo_nodo = new Nodo<T>(dato);
        if(empty())
            primerNodo = nuevo_nodo;
        else
            ultimoNodo.setNodoSiguiente(nuevo_nodo);
        ultimoNodo = nuevo_nodo;
    }

    /**
     * Elimina el primer dato de la cola
     * @return el perimer dato de la cola
     */
    @Override
    public T dequeue(){

        T dato = null;
        if(empty())
            throw new RuntimeErrorException(null, "La cola está vacía");
        else{
            dato = primerNodo.getDato();
            primerNodo = primerNodo.getNodoSiguiente();
            
        }
        return dato;
    }

}