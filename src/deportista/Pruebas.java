package deportista;

import java.io.*;
import java.util.Scanner;

import EstructurasDeDatos.ListaEnlazada;

public class Pruebas {

    public static void main(String[] args) throws IOException{


        FileReader fileReader;
        BufferedReader bufferedReader;

        ListaEnlazada<deportista> lista_deportistas = new ListaEnlazada<deportista>(null);


        //Ingreso todos los deportistas del txt a una lista

        try {

            File dataFile = new File("data.txt");
            fileReader = new FileReader(dataFile);
            bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            int n = 0;

            while(currentLine != null){
                String dataLine = currentLine.replace('-', ' ');
                String[] DataArray = dataLine.split(" ");

                deportista dep = new deportista(DataArray);

                if(n == 0) {
                    lista_deportistas.primerNodo.setDato(dep);
                } else {
                    lista_deportistas.insertar(dep);
                }

                n++;
                currentLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }

        // Le pregunto al usuario que desea hacer

        System.out.println("¿Que desea hacer?");
        System.out.println();
        System.out.println("1. Crear nuevo deportista");
        System.out.println("2. Buscar deportista");
        System.out.println("3. Actualizar un deportista");
        System.out.println("4. Eliminar un deportista");

        Scanner sc = new Scanner(System.in);
        int eleccion = sc.nextInt();

        switch (eleccion) {
            case 1:
                
                System.out.println();
                System.out.println(" Ingrese los siguientes datos línea por línea y en este orden: Número de identificación, nombre,"
                + " fecha de nacimiento (yyyy-m-dd), sexo (M,F), nivel (escuela, novatos, ligados), club");

                String datos = " ";
                
                for (int i = 0; i < 7; i++) {
                    datos += sc.nextLine() + " "; 
                }

                String aux_str = datos.replace('-', ' ');
                System.out.println(aux_str);
                String[] datos_new_dep = aux_str.split(" ");

                deportista new_dep = new deportista(datos_new_dep);

            default:
                break;
        }




        
    }
    
}
