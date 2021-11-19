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
public class pruebas <T> {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListaEnlazada<Integer> lista = new ListaEnlazada(12);
//        
//        lista.insertar(34);
//        lista.insertar(334);
//        lista.insertar(3123);
//        lista.insertar(134);
//        lista.insertar(344);
//        lista.insertar(12344);
//        lista.insertar(35);
//        lista.printLista();
//        lista.insertar(0, 1);
////        lista.printLista();
////        System.out.println(lista.buscar(0));
////        System.out.println(lista.buscar(123));
////        lista.eliminar(5);
//        System.out.println("-----------------------");
//        lista.printLista();
//        lista.eliminar(new Integer(52));
//        System.out.println("-----------------------");
//        lista.printLista();
////        lista.eliminar();
////        System.out.println("-----------------------");
////        lista.printLista();
        
        ListaDoblementeEnlazada<Integer> lista2 = new ListaDoblementeEnlazada<>(12);
        lista2.insertar(13);
        lista2.insertar(14);
        lista2.insertar(15);
        lista2.insertar(16);
        lista2.printLista();
        
    }
    
}
