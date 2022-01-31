/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

import deportista.deportista;


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

        HashTable<deportista> test = new HashTable<>(30);

        String[] data = {"1001299399", "Juan Sebastian Castro Pardo", "2002-9-23", "M", "ligados", "Racing"};

        deportista dep = new deportista(data);

        Entrada<deportista> nuevaEntrada = new Entrada<>(Integer.parseInt(dep.getnúmerodeidentificación()), dep);

        test.insertar(nuevaEntrada);

        deportista dep2 = test.find(dep.getnúmerodeidentificación());

    }
    
    
}
