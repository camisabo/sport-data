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
        
        /*ListaEnlazada<Integer> lista2 = new ListaDoblementeEnlazada<>(12);
        lista2.insertar(13);
        lista2.printLista();
        lista2.insertar(11, 0);
        System.out.println();
        lista2.printLista();*/

        String a = "1001299399";
        String b = "1001299399";

        System.out.println(a.compareTo(b));

        
        
        lista2.eliminar();
        lista2.printLista();
        lista2.insertar(16);
        lista2.eliminar(2);
        lista2.printLista();
        
        lista2.insertar(133, 3);
        lista2.printLista();
        lista2.insertar(166, 2);
        lista2.printLista();
        System.out.println(lista2.buscar(0));

    }
    
}
