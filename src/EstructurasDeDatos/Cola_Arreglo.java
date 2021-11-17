package EstructurasDeDatos;

import javax.management.RuntimeErrorException;

public class Cola_Arreglo<T> implements Interfaz<T> {

    // Atributos

    private int inicio, cola, current_size;
    private T[] array;

    // Constructor

    public Cola_Arreglo(int size){
        
        inicio=cola=current_size=0;
        array= (T[]) new Object[size];
    }

    // Metodos

    /**
     * Verifica si la cola esta vacia
     * @return "true" si la cola esta vacia
     */

    @Override
    public boolean empty(){
        return current_size<=0;
    }

    /**
     * verifica si la cola esta llena
     * @return "true" si la cola esta llena
     */
    @Override
    public boolean full(){
        return current_size>= array.length;
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
            dato = array[inicio];
            inicio = (inicio +1) % array.length;
            current_size--;
        }
        return dato;
    }

    /**
     * Coloca un dato, mediante un nodo, en la ultima posicion de la cola
     * @param dato Dato a colocar en la cola
     */
    @Override
    public void insertar(T dato){
        
        if(full())
            throw new RuntimeErrorException(null, "La cola está llena");
        else{
            array[cola] = dato;
            cola = (cola + 1) % array.length;
            current_size++; 
        }
    }
}
