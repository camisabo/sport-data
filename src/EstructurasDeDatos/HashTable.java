package EstructurasDeDatos;

import java.util.Arrays;

/**
 * @author Juan Sebastian Castro Pardo
 */

public class HashTable<T extends Comparable<T>> {

    Entrada<T>[] theArray;
    int arraySize;
    int itemsInArray = 0;

    public HashTable(int size) { 

        arraySize = size;
        theArray = new Entrada[size];
        Entrada<T> nullEntrada = new Entrada<>(-1, null);
        Arrays.fill(theArray, nullEntrada);

    }

    public void insertar (Entrada<T> entrada) {

        Entrada<T> newElementVal = entrada;

        int arrayIndex = newElementVal.getKey() % arraySize;  // Función hash

        while (theArray[arrayIndex].getKey() != -1) {  // Para arreglar colisiones

            ++arrayIndex;
            arrayIndex %= arraySize;

        }

        theArray[arrayIndex] = newElementVal;
            
    }

    public T find (String key) {

        int arrayIndexHash = Integer.parseInt(key) % arraySize;

        while (theArray[arrayIndexHash].getKey() != -1) {

            if(theArray[arrayIndexHash].getKey() == Integer.parseInt(key)) {

                return theArray[arrayIndexHash].getValue();

            }

            ++arrayIndexHash;

            arrayIndexHash %= arraySize;

        }

        return null;

    }
    
}
