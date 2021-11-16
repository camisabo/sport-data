/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * 
 * @author Omar Nicolas Guerrero
 * @param <T>
 */
public class ListaEnlazada <T extends Comparable<T>>{
    //atributos
    Nodo<T> primerNodo;
    private T dato;
    protected int tamaño = 0;
    
    //constructor
    
    public ListaEnlazada(T dato) {
        this.primerNodo = new Nodo(dato);
    }

    //getters and setters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
    
    
    
    //metodos
    /**
     * Imprime la lista con su posicion 
     */
    public void printLista (){
        Nodo nodoActual = primerNodo;
        int contador  = 0;   
        
        for (int i = 0;tamaño+1>i;i++){
            System.out.println("posicion: "+contador+"\t"+nodoActual.getDato());
            if (nodoActual.getNodoSiguiente() != null){
                nodoActual = nodoActual.getNodoSiguiente();
            }
            contador++;
        }
    }
    /**
     * 
     * Busca desde el primer hasta el ultimo nodo el dato que se le es dado como
     * parametro
     * @param datoABuscar El dato a buscar dentro de la lista
     * @return "true" si el @param datoABuscar se encuentra y "false" de lo
     * contrario
     */
    public boolean buscar (T datoABuscar){
        Nodo nodoActual = primerNodo;
        
        do {            
            if (nodoActual.getDato().compareTo(datoABuscar) == 0){
                return true;
            }
            else if (nodoActual.getNodoSiguiente() == null){
                return false;
            }
            else
                nodoActual = nodoActual.getNodoSiguiente();
        } while (true);
        
    }
    /**
     * Coloca un dato, mediante un nodo, en la posicion dada dentro de la lista
     * enlazada (comenzando desde 0), si la posicion se exede, se colocara el
     * dato en la ultima pocicion, asi mismo si la posicion es menor a 1 se
     * colocara en la primera posicion
     * @param nuevoDato Dato a colocar en la lista enlazada
     * @param posicion Numero entero que determina la posicion en la que se
     * coloca el nuevo dato
     */
    public void insertar (T nuevoDato, int posicion){
        tamaño++;
        System.out.println(tamaño);
        Nodo nodoActual = primerNodo;
        Nodo nuevoNodo = new Nodo(nuevoDato);
        
        //si hay solo un elemento
        if (nodoActual.getNodoSiguiente() == null){
            insertar(nuevoDato);
        }
        
        //si la posicion es menor que o igual a cero
        else if (1 > posicion){
            nuevoNodo.setNodoSiguiente(primerNodo);
            primerNodo = nuevoNodo;
        }
        
        //en un caso normal
        else{
            for(int i = 0; i< posicion-1;i++){ /*pocicionar un apuntador al dato
                                              anterior a la pocicion a insertar
                                            */ 
                nodoActual = nodoActual.getNodoSiguiente();
                if (nodoActual.getNodoSiguiente() == null){/*verifica que la 
                                                           pocicion exista
                                                           */
                    insertar(nuevoDato);
                }
            }
            nuevoNodo.setNodoSiguiente(nodoActual.getNodoSiguiente());
            nodoActual.setNodoSiguiente(nuevoNodo);
        }
    }
    /**
     * Coloca un dato, mediante un nodo, en la ultima posicion de la lista
     * @param nuevoDato Dato a colocar en la lista enlazada
     */
    public void insertar (T nuevoDato){
        tamaño++;
        Nodo nodoActual = primerNodo;
        Nodo nuevoNodo = new Nodo(nuevoDato);
        
        while (nodoActual.getNodoSiguiente() != null){
            nodoActual= nodoActual.getNodoSiguiente();
        }
        
        nodoActual.setNodoSiguiente(nuevoNodo);
    }
    /**
     * elimina el dato en la posicion dada, si la posicion no esta en la lista 
     * enlazada, se eliminara el dato mas cercano a esta
     * @param posicion Numero entero que determina la posicion a eliminar
     */
    public void eliminar (int posicion){
        tamaño--;
        Nodo nodoActual = primerNodo;
        
        //si hay solo un elemento
        if (nodoActual.getNodoSiguiente() == null){
            nodoActual.setDato(null);
            tamaño = 0;
        }
        
        //si la posicion es menor que o igual a cero
        else if (1 > posicion){
            primerNodo = primerNodo.getNodoSiguiente();
            nodoActual.setDato(null);
            nodoActual.setNodoSiguiente(null);
        }
        
        //en un caso normal
        else{
            for(int i = 0; i< posicion-1;i++){ /*pocicionar un apuntador al dato
                                              anterior a la pocicion a insertar
                                            */ 
                nodoActual = nodoActual.getNodoSiguiente();
                if ((nodoActual.getNodoSiguiente()).getNodoSiguiente() == null){
                                                           /*verifica que la 
                                                           pocicion exista
                                                           */
                    nodoActual.setNodoSiguiente(null);
                }
            }
            
            //se quita la referencia al nodo seleccionado
            nodoActual.setNodoSiguiente((nodoActual.getNodoSiguiente())
                    .getNodoSiguiente());
        }   
    }
    /**
     * Busca y elimina el dato dado, si el dato se repite se eliminara el 
     * primero. en caso de no encontrarse el dato mandar aun mensaje por consola
     * @param datoABorrar Dato que se busca eliminar
     */
    public void eliminar (T datoABorrar){
        tamaño--;
        Nodo nodoActual = primerNodo;
        boolean estaElDato = buscar(datoABorrar);
        if (estaElDato == false){
            System.out.println("No se encuentra "+datoABorrar+" en "+this);
            tamaño++;
        }
        
        //si hay solo un elemento y se encuentra el elemento
        else if (nodoActual.getNodoSiguiente() == null){
            nodoActual.setDato(null);
            tamaño = 0;
        }
        
        
        do {            
            if ((nodoActual.getNodoSiguiente()).getDato().compareTo(datoABorrar) == 0){
                nodoActual.setNodoSiguiente((nodoActual.getNodoSiguiente())
                        .getNodoSiguiente());
                break;
            }
            else
                nodoActual = nodoActual.getNodoSiguiente();
        } while (estaElDato == true);
        
    }
    /**
     * Elimina el ultimo dato añadido a la lista
     */
    public void eliminar (){
        tamaño--;
        Nodo nodoActual = primerNodo;
        
        //si hay solo un elemento
        if (nodoActual.getNodoSiguiente() == null){
            nodoActual.setDato(null);
            tamaño = 0;
        }
        
        //en un caso normal
        else{
            while((nodoActual.getNodoSiguiente()).getNodoSiguiente() != null){
                    nodoActual = nodoActual.getNodoSiguiente();
            }
            nodoActual.setNodoSiguiente(null);
        }
    }
}
