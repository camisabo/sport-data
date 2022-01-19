package EstructurasDeDatos;

public class ArbolAVL2 <T extends Comparable<T>> {

    //Atributos
    public NodoArbol<T> raiz;

    public ArbolAVL2() {
        raiz = null;
    }

    public ArbolAVL2(T dato) {
        raiz = new NodoArbol<T>(dato);
    }

    //Métodos

    public void Vaciar(){
        raiz = null;
    }

    public boolean EstaVacio(){
        return raiz == null;
    }

    //calcula la altura de un nodo a partir de la altura de sus hijos
    public void actualizarAltura(NodoArbol<T> nodo){
        if (nodo.getNodoHijoDerecha()==null && nodo.getNodoHijoIzquierda()== null ){
            nodo.setAltura(0);
        } else if (nodo.getNodoHijoDerecha()==null){
            nodo.setAltura(nodo.getNodoHijoIzquierda().getAltura()+1);
        } else if (nodo.getNodoHijoIzquierda()==null){
            nodo.setAltura(nodo.getNodoHijoDerecha().getAltura() +1);
        } else {
            int nuevaAltura =  Math.max(nodo.getNodoHijoIzquierda().getAltura(), nodo.getNodoHijoDerecha().getAltura())+1;
            nodo.setAltura(nuevaAltura);
        }
    }

    //si el arbol está desbalanceado, busca donde está el desbalanceo para rotar lo necesario
    public NodoArbol<T> equilibrar(NodoArbol<T> nodo){
        if (nodo == null){
            return null;
        }
        int alturaIzquierda = nodo.getNodoHijoIzquierda()==null ? 0 : nodo.getNodoHijoIzquierda().getAltura();
        int alturaDerecha = nodo.getNodoHijoDerecha()==null ? 0 : nodo.getNodoHijoDerecha().getAltura();

        //si está desbalanceado a la izquierda
        if (alturaIzquierda - alturaDerecha > 1){
            int alturaIzqIzq = nodo.getNodoHijoIzquierda().getNodoHijoIzquierda()==null ? 0 : nodo.getNodoHijoIzquierda().getNodoHijoIzquierda().getAltura();
            int alturaIzqDer = nodo.getNodoHijoIzquierda().getNodoHijoDerecha()== null ? 0 : nodo.getNodoHijoIzquierda().getNodoHijoDerecha().getAltura();
            if(alturaIzqIzq > alturaIzqDer){
                nodo = rotarDerecha(nodo);
            } else {
                nodo = rotarDobleIzquierda(nodo);
            }

        //si está desbalanceado a la derecha
        } else if (alturaDerecha - alturaIzquierda > 1) {
            int alturaDerIzq = nodo.getNodoHijoDerecha().getNodoHijoIzquierda()==null ? 0 : nodo.getNodoHijoDerecha().getNodoHijoIzquierda().getAltura();
            int alturaDerDer = nodo.getNodoHijoDerecha().getNodoHijoDerecha()== null ? 0 : nodo.getNodoHijoDerecha().getNodoHijoDerecha().getAltura();
            if (alturaDerDer > alturaDerIzq){
                nodo = rotarIzquierda(nodo);
            } else {
                nodo = rotarDobleDerecha(nodo);
            }
        }
        //actualizamos la altura del nodo
        actualizarAltura(nodo);
        return nodo;
    }

    //rotación simple a la derecha
    public NodoArbol<T> rotarDerecha(NodoArbol<T> nodo){
        NodoArbol izquierda = nodo.getNodoHijoIzquierda();
        nodo.setNodoHijoIzquierda(izquierda.getNodoHijoDerecha());
        izquierda.setNodoHijoDerecha(nodo);
        actualizarAltura(nodo);
        actualizarAltura(izquierda);
        return izquierda;
    }

    //rotación simple a la izquierda
    public NodoArbol<T> rotarIzquierda(NodoArbol<T> nodo){
        NodoArbol derecha = nodo.getNodoHijoDerecha();
        nodo.setNodoHijoDerecha(derecha.getNodoHijoIzquierda());
        derecha.setNodoHijoIzquierda(nodo);
        actualizarAltura(nodo);
        actualizarAltura(derecha);
        return derecha;
    }

    //rotación doble derecha izquierda 
    public NodoArbol<T> rotarDobleDerecha(NodoArbol<T> nodo){
        nodo.setNodoHijoDerecha(rotarDerecha(nodo.getNodoHijoDerecha()));
        return rotarIzquierda(nodo);
    }

    //rotación doble izquierda derecha
    public NodoArbol<T> rotarDobleIzquierda(NodoArbol<T> nodo){
        nodo.setNodoHijoIzquierda(rotarIzquierda(nodo.getNodoHijoIzquierda()));
        return rotarDerecha(nodo);
    }

    public void insertar(T dato ){
        if (EstaVacio()){
            this.raiz= new NodoArbol(dato);

        } else {
            raiz = insertar(this.raiz, dato);
        }
    }

    //método recursivo para insertar datos en el arbol
    public NodoArbol<T> insertar(NodoArbol<T> nodo, T dato){
        if (nodo.getDato().compareTo(dato)<0){
            if (nodo.getNodoHijoDerecha() == null){
                nodo.setNodoHijoDerecha(new NodoArbol<T>(dato));
            } else {
                nodo.setNodoHijoDerecha(insertar(nodo.getNodoHijoDerecha(), dato));
            }

        } else if (nodo.getDato().compareTo(dato)>0){
            if (nodo.getNodoHijoIzquierda()==null){
                nodo.setNodoHijoIzquierda(new NodoArbol<T>(dato));
            } else {
                nodo.setNodoHijoIzquierda(insertar(nodo.getNodoHijoIzquierda(), dato));
            }
        } 
        // siempre que se recorra un nodo se balancea el árbol
        return equilibrar(nodo);
    }

    public void eliminar(T dato){
        if (EstaVacio()== false){
            raiz = eliminar(dato, raiz);   
        }      
    }

    public NodoArbol<T> eliminar(T dato, NodoArbol<T> nodo){
        if (nodo == null){
            return null;
        }
        if (nodo.getDato().compareTo(dato)<0){
            nodo.setNodoHijoDerecha(eliminar(dato, nodo.getNodoHijoDerecha()));
        } else if (nodo.getDato().compareTo(dato)>0){
            nodo.setNodoHijoIzquierda(eliminar(dato, nodo.getNodoHijoIzquierda()));
        } else if (nodo.getNodoHijoDerecha()!= null && nodo.getNodoHijoIzquierda()!=null){
            //encontramos el nodo a eliminar y tiene 2 hijos
            NodoArbol<T> nodoMinimo = hallarMinimo(nodo.getNodoHijoDerecha());
            nodo.setDato(nodoMinimo.getDato());
            nodo.setNodoHijoDerecha(eliminar(nodo.getDato(), nodo.getNodoHijoDerecha()));
        } else {
            if (nodo.getNodoHijoDerecha()== null ){
                nodo = nodo.getNodoHijoIzquierda();
            } else {
                nodo = nodo.getNodoHijoDerecha();
            }
        }
        // siempre que se recorra un nodo se balancea el árbol
        return equilibrar(nodo);
    }

    public NodoArbol<T> hallarMinimo(NodoArbol<T> nodo){
        if (nodo == null){
            return null;
        } else if (nodo.getNodoHijoIzquierda()==null){
            return nodo;
        } else {
            return hallarMinimo(nodo.getNodoHijoIzquierda());
        }
    }

    public boolean buscarDato(T dato){
        return buscarDato(this.raiz, dato);
    }

    //método recursivo para buscar un dato en el árbol
    public boolean buscarDato(NodoArbol<T> nodo, T dato){
        if (nodo == null){
            return false;
        } else {
            if (nodo.getDato()== dato){
                return true;
            } else if (nodo.getDato().compareTo(dato)<0){
                return buscarDato(nodo.getNodoHijoDerecha(), dato);
            } else {
                return buscarDato(nodo.getNodoHijoIzquierda(), dato);
            }
        }
    }

    public void preorden(NodoArbol<T> nodo){
        if (nodo != null){
            System.out.println(nodo.getDato());
            preorden(nodo.getNodoHijoIzquierda());
            preorden(nodo.getNodoHijoDerecha());
        }        
    }

    public void postorden(NodoArbol<T> nodo){
        if (nodo != null){
            postorden(nodo.getNodoHijoIzquierda());
            postorden(nodo.getNodoHijoDerecha());
            System.out.println(nodo.getDato());
        }        
    }

    public void inorden(NodoArbol<T> nodo){
        if (nodo != null){
            inorden(nodo.getNodoHijoIzquierda());
            System.out.println(nodo.getDato());
            inorden(nodo.getNodoHijoDerecha());
        }        
    }
    
    public void preorden(){
        this.preorden(this.raiz);
    }

    public void postorden(){
        this.postorden(this.raiz);
    }

    public void inorden(){
        this.inorden(this.raiz);
    }
}
