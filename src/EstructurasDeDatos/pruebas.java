/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

import java.util.Scanner;


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
        Scanner entrada = new Scanner(System.in);

        ArbolAVL<Integer> arbolAVL = new ArbolAVL(4);
        arbolAVL.insertar(8);
        arbolAVL.insertar(9);
        arbolAVL.insertar(10);
        arbolAVL.insertar(1);
        arbolAVL.insertar(3);
        arbolAVL.insertar(6);
        arbolAVL.insertar(2);
        arbolAVL.preorden();
        System.out.println(arbolAVL.buscarDato(10));
        System.out.println(arbolAVL.buscarDato(2));
        System.out.println(arbolAVL.buscarDato(13));        
        
          
        
        entrada.close();
    }
    
    
}
