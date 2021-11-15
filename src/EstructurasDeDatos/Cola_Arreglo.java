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

    public boolean empty(){
        return current_size<=0;
    }
    public boolean full(){
        return current_size>= array.length;
    }

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
