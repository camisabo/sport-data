package EstructurasDeDatos;

import javax.management.RuntimeErrorException;

public class Pila_ListaEnlazada<T extends Comparable<T>> extends ListaEnlazada<T>  {

    public Pila_ListaEnlazada(){
        super();
    }
    
    public Pila_ListaEnlazada(T dato){
        super(dato);
    }

    // Metodos

    /**
     * verifica que la pila esta vacia
     * @return "true" si pila esta vacia
     */

    @Override //interface 
    public boolean empty(){
        return primerNodo == null;
    }

    /**
     * Coloca un dato, mediante un nodo, en la ultima posicion de la pila
     * @param dato Dato a colocar en la pila
     */
    @Override
    public void insertar(T dato){

        tamaño++;
        Nodo<T> nuevo_nodo = new Nodo<T>(dato);
        nuevo_nodo.setNodoSiguiente(primerNodo);
        primerNodo = nuevo_nodo;
    }

    /**
     * Elimina el ultimo dato de la pila
     * @return el ultimo dato de la pila
     */
    @Override
    public T pop(){

        T dato = null;
        if(empty())
            throw new RuntimeErrorException(null, "La pila está vacía");
        else{

            dato = primerNodo.getDato();
            primerNodo = primerNodo.getNodoSiguiente();

        }
        return dato;

    }
    
}
