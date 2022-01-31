package analisis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import EstructurasDeDatos.Cola_ListaEnlazada;
import EstructurasDeDatos.Entrada;
import EstructurasDeDatos.HashTable;
import EstructurasDeDatos.ListaDoblementeEnlazada;
import EstructurasDeDatos.Pila_ListaEnlazada;
import EstructurasDeDatos.ArbolAVL;


public class analisis {
    public static void main(String[] args) {

        int n = 100000;
        FileReader fileReader;
        BufferedReader bufferedReader;
        List<String> s = new ArrayList<String>();
        
        Cola_ListaEnlazada<String> cola = new Cola_ListaEnlazada<String>();
        Pila_ListaEnlazada<String> pila = new Pila_ListaEnlazada<String>();
        ListaDoblementeEnlazada<String> lista_doble = new ListaDoblementeEnlazada<String>(null);
        ArbolAVL<String> arbolAVL = new ArbolAVL<String>();
        String arreglo[] = new String[n];
        HashTable<String> hash_table = new HashTable<>(n);

        try {

            File dataFile = new File("src/analisis/100k.txt");
            fileReader = new FileReader(dataFile);
            bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
                    
            
            while(currentLine != null){

                s.add(currentLine);
                currentLine = bufferedReader.readLine();
            }
            
            
            bufferedReader.close();
            fileReader.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }

        // int randomNum = ThreadLocalRandom.current().nextInt(1, n + 1);
        
        // // final long startTime = System.currentTimeMillis();

        // for(String dato :s){
        //     pila.insertar(dato);
        // }
        // final long endTime = System.currentTimeMillis();


        // final long startTime = System.currentTimeMillis();

        // for(String dato :s){
        //     cola.insertar(dato);
        // }

        // final long endTime = System.currentTimeMillis();

        // final long startTime = System.currentTimeMillis();

        // for(String dato :s){
        //     lista_doble.insertar(dato);
        // }

        // final long endTime = System.currentTimeMillis();

        // final long startTime = System.currentTimeMillis();
        for(String dato :s){
            arbolAVL.insertar(dato);
        }
        
        // final long endTime = System.currentTimeMillis();
        
        // final long startTime = System.currentTimeMillis();

        for (int i = 0; i < s.size(); i++) {
            Entrada<String> nuevaEntrada = new Entrada<String>(i,s.get(i));
            hash_table.insertar(nuevaEntrada);
        }
        

        // final long endTime = System.currentTimeMillis();

        String str = "";
        int pos = 0;
        boolean info = false;
        final long startTime = System.currentTimeMillis();
        str = hash_table.find("49807");
        // pos = lista_doble.buscarPos("10P5U44LK4");
        // info = arbolAVL.buscarDato("ARV2UP2MC9");
        final long endTime = System.currentTimeMillis();
    
        System.out.println("Total execution time: " + (endTime - startTime)+ " "+str+" " +" " +info+ " "+pos);

        
    }
    
}
