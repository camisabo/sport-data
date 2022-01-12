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
public class ArbolAVL <T extends Comparable<T>> extends ArbolDeBusqueda<T>{
    
    public ArbolAVL() {
        raiz = null;
    }

    public ArbolAVL(T dato) {
        raiz = new NodoArbol(dato);
    }

    /**
     * coloca la altura del dato dado (raiz) y verifica si tiene hijos, si los 
     * tiene aplica el mismo procedimiento en los mismos.
     * @param nodoAEvaluar nodo al que le van a colocar la altura (en un pricipio
     * se usara raiz)
     */
    private void colocarAlturas(NodoArbol <T> nodoAEvaluar){
        nodoAEvaluar.setAltura(altura(nodoAEvaluar));
        if(nodoAEvaluar.getNodoHijoDerecha() != null){
            colocarAlturas(nodoAEvaluar.getNodoHijoDerecha());
        }
        if(nodoAEvaluar.getNodoHijoIzquierda() != null){
            colocarAlturas(nodoAEvaluar.getNodoHijoIzquierda());
        }
    }
    
    /**
     * metodo para colocar las alturas sin que pida nada por practicidad
     */
    public void colocarAlturas(){
        colocarAlturas(raiz);
    }
    
    /**
     * busca y evalua los minimos y los maximos de cada sub arbol para verificar
     * que el arbol este equilibrado, esto lo hacehaciendo las siguientes 
     * comprobaciones:<br>
     * <ol>
     * --<li>si tiene los dos hijos entonces comprueba en cual de los dos esta el
     *       nodo con menos altura y en cual el que esta el que tiene mas altura</li>
     * --<li>si solo tiene uno de los dos fija el valor minimo a la altura del 
     *       nodo actual y el maximo a la mayor altura entre sus hijos</li>
     * --<li>si no tiene hijos fija el mayor a la altira del nodo actual</li>
     * </ol>
     * al hacer estas comprobaciones de forma recurciva y al guardar en la posicion
     * sub 2 el tipo de balanceo que se requiere se proceda a determinar si el 
     * arbol tiene un desbalanceo, restando el menor al mayor y viendo si el 
     * resultado es mayor a 2. de ser este el caso se usa los metodos de balanceo
     * 
     * @param nodoAEvaluar nodo al cual se le aplican las comprobaciones
     * @param lista arreglo de numeros enteros que guarda: en la posicion 0; el
     * valor minimo de altura encontrado hasta el momento, el la posicion 1; el
     * valor maximo encontrado hasta el momento, y en la posicion 2; un numero 
     * entero entre 1 y -1 que determina el tipo de balanceo a usar 
     * @return la lista de interos del nodoAEvaluar por practicidad de la recurcion
     */
    public int[] balanceo(NodoArbol <T> nodoAEvaluar, int [] lista){
        if(nodoAEvaluar.getNodoHijoDerecha() != null && nodoAEvaluar.getNodoHijoIzquierda() != null){ 
        //si tiene los dos hijos
            int[] derecha = balanceo(nodoAEvaluar.getNodoHijoDerecha(), lista);
            int[] izquierda = balanceo(nodoAEvaluar.getNodoHijoIzquierda(), lista);
            lista[0] =Integer.min(derecha[0], izquierda[0]);
            lista[1] =Integer.max(derecha[1], izquierda[1]);
            if(derecha[1]<izquierda[1]){// para definir si es izquierda o derecha
                if(lista[2] == 1){ /*
                    lista sub 2 es por donde se inserto el mayor
                    -- 1 es que el mayor siempre a estado a la derecha
                    -- (-1) es que el mayor siempre a estado a la izquierda
                    -- 0 es que a estado variando
                    
                    (esto se comprueba porque hay dos tipos de balanceos que dependen
                    de si siempre estuvo del mismo lado como es "balanceo Izquierda
                    izquierda" o por el contrario varian de lado)
                    */
                    lista[2] = 0;
                }
            }
            if(derecha[1]>izquierda[1]){// para definir si es izquierda o derecha
                if(lista[2] == -1){ /*
                    lista sub 2 es por donde se inserto el mayor
                    -- 1 es que el mayor siempre a estado a la derecha
                    -- (-1) es que el mayor siempre a estado a la izquierda
                    -- 0 es que a estado variando
                    
                    (esto se comprueba porque hay dos tipos de balanceos que dependen
                    de si siempre estuvo del mismo lado como es "balanceo Izquierda
                    izquierda" o por el contrario varian de lado)
                    */
                    lista[2] = 0;
                }
            }
        } 
        else if(nodoAEvaluar.getNodoHijoDerecha() != null){
        //si solo tiene el hijoderecho
            lista[1] = balanceo(nodoAEvaluar.getNodoHijoDerecha(), lista)[1];
            lista[0] = nodoAEvaluar.getAltura();
            if(lista[2] == -1) {
                lista[2] = 0;
            }
            
        }
        else if(nodoAEvaluar.getNodoHijoIzquierda() != null){
        //si solo tiene el hijoderecho
            lista[1] = balanceo(nodoAEvaluar.getNodoHijoIzquierda(), lista)[1];
            lista[0] = nodoAEvaluar.getAltura();
            if(lista[2] == 1) {
                lista[2] = 0;
            }
        }
        else{
        //si no tiene ningun hijo
            lista[1] = nodoAEvaluar.getAltura();
            
        }
        boolean desbalanceado = (2<=lista[1]-lista[0])?true:false;
        if (desbalanceado){
            
        }
        return lista;
    }
    
}
