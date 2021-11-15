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

    public boolean empty(){
        return top <= 0;
    }

    public boolean full(){
        return top >= array.length;
    }

    public T eliminar(){
        
        if(empty()) 
            throw new RuntimeErrorException(null, "La pila está vacía");
        else{
            top--;
            return array[top];
        }
    }
    
    public void insertar (T dato){

        if(full())
            throw new RuntimeErrorException(null, "La pila está llena");
        else{
            array[top]=dato;
            top++;
        }
    }
}
