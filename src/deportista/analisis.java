package deportista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import EstructurasDeDatos.Cola_ListaEnlazada;

public class analisis {
    public static void main(String[] args) {

        FileReader fileReader;
        BufferedReader bufferedReader;
        
        Cola_ListaEnlazada<String> cola = new Cola_ListaEnlazada<>();
        
        try {

            File dataFile = new File("analisis.txt");
            fileReader = new FileReader(dataFile);
            bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            
            final long startTime = System.currentTimeMillis();
            while(currentLine != null){
                            
                currentLine = bufferedReader.readLine();
                cola.insertar(currentLine);
            }
            final long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime));
            
            bufferedReader.close();
            fileReader.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }

        
    }
    
}
