/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;
import java.lang.Exception;

/**
 *
 * @author Omar Nicolas Guerrero
 * @param <T>
 */
public class ArbolDeBusqueda<T extends Comparable<T>> {
    //atributos
    public NodoArbol<T> raiz;
    private T dato;

    public ArbolDeBusqueda() {
        raiz = null;
    }

    public ArbolDeBusqueda(T dato) {
        raiz = new NodoArbol(dato);
    }
    
    //metodos

    /**
     * Vacia el arbol haciedo que su raiz sea null
     */
    
    public void Vaciar(){
        raiz = null;
    }
    
    /**
     * Verifica que el arbol este vacio comparando su raiz con null
     * @return true si el arbol esta vacio o false de lo contrario
     */
    public boolean EstaVacio(){
        return raiz == null;
    }
    
    /**
     * sacado de este<a href = "https://campus.virtual.unal.edu.co/pluginfile.php/2154753/mod_resource/content/1/10_Arboles_BST.pdf">link</a><br>
     * Ingreza un nodo en el arbol mediante el uso de recursividad y comprobaciones.
     * las comprobaciones son:<br>
     * <ol>
     * --<li> si el nodo en el que esta se encuentra vacio entonces supone que esta
     *     en la posicion correcta ygenera un nuevo nodo con el dato ingrezado el 
     *     parametro "dato".</li>
     * --<li> si el dato del nodo en el que el que se encuentra es mayor al dado en
     *     el parametro "dato" entonces intententa colocar el dato en el hijo de
     *     la derecha.</li>
     * --<li> si el dato del nodo en el que el que se encuentra es menot al dado en
     *     el parametro "dato" entonces intententa colocar el dato en el hijo de
     *     la izquierda.</li>
     * </ol>
     * @param nodoAEvaluar nodoArbol donde se hacen las comprobaciones (en un 
     * principio se usara la raiz)
     * @param dato dato que se busca insertar en el arbol
     * @return el nodo que se ingreso en los parametros para qe la recursividad 
     * funcione
     */
    private NodoArbol insertar(NodoArbol nodoAEvaluar, T dato) throws StackOverflowError{
        if (nodoAEvaluar == null){
            return new NodoArbol(dato);
        }
        if (nodoAEvaluar.getDato().compareTo(dato)<0){
            nodoAEvaluar.setNodoHijoDerecha(insertar(nodoAEvaluar.getNodoHijoDerecha(), dato));
        }
        if (nodoAEvaluar.getDato().compareTo(dato)>0){
            nodoAEvaluar.setNodoHijoIzquierda(insertar(nodoAEvaluar.getNodoHijoIzquierda(), dato));
        }
        return nodoAEvaluar;
    }
    
    /**
     * metodo que para insertar unicamente pide el dato a ingresar por practicidad
     * @param dato dato que se busca ingresar en el arbol
     */
    public void insertar(T dato){
        try {
            raiz = insertar(raiz, dato);
        } catch (StackOverflowError e) {
            System.out.println("se a llenado la memoria por rxeso de inseciones");
        }
        
    }
    
    /**
     * sacado de este<a href = "https://campus.virtual.unal.edu.co/pluginfile.php/2154753/mod_resource/content/1/10_Arboles_BST.pdf">link</a><br>
     * Ingreza un nodo en el arbol mediante el uso de recursividad y comprobaciones.
     * las comprobaciones son:<br>
     * <ol>
     * --<li> si el nodo en el que esta se encuentra vacio entonces supone que 
     *     a acabado la busqueda y devuelve un false al no encontrar el elmento del 
     *     parametro "dato".</li>
     * --<li> si el dato del nodo en el que el que se encuentra es mayor al dado en
     *     el parametro "dato" entonces intententa buscar el dato en el hijo de
     *     la derecha.</li>
     * --<li> si el dato del nodo en el que el que se encuentra es menot al dado en
     *     el parametro "dato" entonces intententa buscar el dato en el hijo de
     *     la izquierda.</li>
     * --<li>si ninguna de las condiciones anteriores es correcta entonces asume
     *     que se encontro el dato y devuelve true</li>
     * </ol>
     * @param nodoAEvaluar nodoArbol donde se hacen las comprobaciones (en un 
     * principio se usara la raiz)
     * @param dato dato que se busca en el arbol
     * @return retorna un booleano dependiendo de si encuentra o no al dato
     */
    private boolean buscar(NodoArbol nodoAEvaluar, T dato){
        if (nodoAEvaluar == null){
            return false;
        }
        else if (nodoAEvaluar.getDato().compareTo(dato)>0){
                return buscar(nodoAEvaluar.getNodoHijoDerecha(), dato);
        }
        else if (nodoAEvaluar.getDato().compareTo(dato)<0){
            return buscar(nodoAEvaluar.getNodoHijoIzquierda(), dato);
        }
        else{
            return true;
        }
    }
    
    /**
     * metodo que para buscar unicamente pide el dato a ingresar por practicidad
     * @param dato dato que se busca en el arbol
     * @return retorna un booleano dependiendo de si encuentra o no al dato
     */
    public boolean buscar(T dato){
        return buscar(raiz, dato);
    }
    
    /**
     * regresa el nodo mas a la izquierda partiendo del nodo base
     * @param nodoAEvaluar es el nodo base que se va a evaluar
     * @return el dato mas a la izquierda del nodo base
     */
    private NodoArbol minimo(NodoArbol nodoAEvaluar){
        if(nodoAEvaluar.getNodoHijoIzquierda()==null){
            return null;
        }
        else if(nodoAEvaluar.getNodoHijoIzquierda() == null){
           return nodoAEvaluar;
        }
        return minimo(nodoAEvaluar.getNodoHijoIzquierda());
    }
    
    /**
     * sacado de este<a href = "https://campus.virtual.unal.edu.co/pluginfile.php/2154753/mod_resource/content/1/10_Arboles_BST.pdf">link</a><br>
     * busca el dato a remover mediante dos comprobaciones:<br>
     * <ol>
     * --<li>si el numero es menor al dato a eliminar va al nodo de la izquierda
     *     y repite el proseso</li>
     * --<li>si el numero es mayor al dato a eliminar va al nodo de la derecha
     *     y repite el proseso</li>
     * </ol>
     * si las dos comprobaciones no se aplican y el nodo no es igual a null entonces
     * se encontro el elemento por lo que pasa a reempalzar el valor a reemplazar
     * por el menor de sub arbol derecho y se elimina de este. de solo tener hijos 
     * a la izquierda, cambiamos el nodo que tiene el valor a eliminar por su hijo
     * a la izquierda. si no tiene hijos simplemente fijamos el nodo a null
     * @param dato dato que se quiere eliminar
     * @param nodoAEvaluar es el nodo base que se va a evaluar
     * @return el nodo que se busca eliminar para facilitar la recurcividad
     */
    private  NodoArbol eliminar (Comparable dato, NodoArbol nodoAEvaluar){
        if (nodoAEvaluar == null) {
            return nodoAEvaluar;
        }
        int compaReresult = nodoAEvaluar.getDato().compareTo(dato)*-1;
        if (compaReresult < 0){
            nodoAEvaluar.setNodoHijoIzquierda(eliminar(dato, nodoAEvaluar.getNodoHijoIzquierda()));
        }
        else if (compaReresult > 0) {
            nodoAEvaluar.setNodoHijoDerecha(eliminar(dato, nodoAEvaluar.getNodoHijoDerecha()));
        }
        else if (nodoAEvaluar.getNodoHijoIzquierda() != null && nodoAEvaluar.getNodoHijoDerecha() != null) {
            nodoAEvaluar.setDato(minimo(nodoAEvaluar.getNodoHijoDerecha()).getDato());
            nodoAEvaluar.setNodoHijoDerecha(eliminar(nodoAEvaluar.getDato(), nodoAEvaluar.getNodoHijoDerecha()));
        }
        else {
            nodoAEvaluar = (nodoAEvaluar.getNodoHijoIzquierda() != null) ? nodoAEvaluar.getNodoHijoIzquierda():nodoAEvaluar.getNodoHijoDerecha();
        }
        return nodoAEvaluar;
    }
    
    /**
     * metodo que para eliminar solamente pide el dato a eliminar por practicidad
     * @param dato dato que se busca remover del arbol
     */
    public void eliminar(T dato){
        raiz = eliminar(dato, raiz);
    }
    
    /**
     * metodo que retorna la altura del nodo a evaluar, siendo 1; las hojas, 
     * -1; los elementos inexistentes y el maximo la raiz.<br>
     * 
     * esto lo consigue sumandole 1 a la mayor altura entre los hijos y repitiendo el 
     * proceso para estos.
     * @param nodoAEvaluar nodo al cual se busca saber la altura
     * @return la altura del nodo a evaluar
     */
    public int altura (NodoArbol nodoAEvaluar){
        if (nodoAEvaluar == null){
            return -1;
        }
        else{
            return 1+Math.max(altura(nodoAEvaluar.getNodoHijoIzquierda()), altura(nodoAEvaluar.getNodoHijoDerecha()));
        }
    }
}
