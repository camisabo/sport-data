package EstructurasDeDatos;

import javax.management.RuntimeErrorException;

public class Pila_Arreglo<T> implements Interfaz<T>{
    
    // Atributos

    private int top;
    private T[] array;
    
    // Constructor

    public Pila_Arreglo(int size){
        top = 0;
        array = (T[]) new Object[size];
    }

    // Metodos

    /**
     * verifica que la pila esta vacia
     * @return "true" si pila esta vacia
     */

    @Override
    public boolean empty(){
        return top <= 0;
    }

    /**
     * verifica si la pila esta llena
     * @return "true" si la pila esta llena
     */
    @Override
    public boolean full(){
        return top >= array.length;
    }

    /**
     * Elimina el ultimo dato de la pila
     * @return el ultimo dato de la pila
     */
    @Override
    public T eliminar(){
        
        if(empty()) 
            throw new RuntimeErrorException(null, "La pila está vacía");
        else{
            top--;
            return array[top];
        }
    }
    
    /**
     * Coloca un dato, mediante un nodo, en la ultima posicion de la pila
     * @param dato Dato a colocar en la pila
     */
    @Override
    public void insertar (T dato){

        if(full())
            throw new RuntimeErrorException(null, "La pila está llena");
        else{
            array[top]=dato;
            top++;
        }
    }
}
