/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * @author Omar Nicolas Guerrero
 * @param <T>
 */
public class TablaHash<T extends Comparable<T>> {
    
    private int tamaño;
    private int indice;
    private T llave;
    private ListaEnlazada[] array; 

    public TablaHash(int tamaño) {
        this.tamaño = tamaño;
        array = (ListaEnlazada[]) new Object[tamaño];
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public T getLlave() {
        return llave;
    }

    public void setLlave(T llave) {
        this.llave = llave;
    }

    public ListaEnlazada[] getArray() {
        return array;
    }

    public void setArray(ListaEnlazada[] array) {
        this.array = array;
    }

    private static int hash(String llave,int tamaño){
        int hashVal = 0;
        
        for (int i = 0; i<llave.length();i++){
            hashVal = 37 * hashVal + llave.charAt(i);
        }
        hashVal %= tamaño;
        if (hashVal < 0){
            hashVal +=tamaño;
        }
        return hashVal;
    }
    
    public int hash(String llave){
        return hash(llave,getTamaño());
    }
    
    public void insertar(T llave){
        
    }
    public void eliminar(T llave){
        
    }
    public void buscar(T llave){
        
    }
    
}
