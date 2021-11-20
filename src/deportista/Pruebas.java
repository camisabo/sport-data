package deportista;

import java.io.*;
import java.util.Scanner;

import EstructurasDeDatos.ListaEnlazada;

public class Pruebas {

    //MÉTODOS

    //1. CREAR DEPORTISTA

    public static String CrearDeportista(String datos, ListaEnlazada<deportista> lista_deportistas) {

        String aux_str = datos.replace('-', ' ');
        String[] datos_new_dep = aux_str.split(" ");

        deportista new_dep = new deportista(datos_new_dep);
        lista_deportistas.insertar(new_dep);

        
        String dep_txt_str = "";

        for (int i = 0; i <= lista_deportistas.tamaño; i++) {
            deportista dep_txt = lista_deportistas.buscar(i);
            if(i==0) {
                dep_txt_str += dep_txt.númerodeidentificación + " " + dep_txt.nombre + " " + dep_txt.fechaDeNacimiento + " " + dep_txt.sexo + " " + dep_txt.nivel + " " + dep_txt.club;
            } else {
                dep_txt_str += "\n" + dep_txt.númerodeidentificación + " " + dep_txt.nombre + " " + dep_txt.fechaDeNacimiento + " " + dep_txt.sexo + " " + dep_txt.nivel + " " + dep_txt.club;
            }
        }

        return dep_txt_str;

    }

    // 2. BUSCAR DEPORTISTA

    public static void BuscarDeportista (deportista dep_buscar, ListaEnlazada<deportista> lista_deportistas) {

        if(lista_deportistas.buscar(dep_buscar)) {
            int posicion = lista_deportistas.buscarPos(dep_buscar);
            deportista dep_encontrado = lista_deportistas.buscar(posicion);
            System.out.println("Documento de identidad: " + dep_encontrado.númerodeidentificación + "\nNombre: " + dep_encontrado.nombre + 
            "\nFecha de nacimiento: " + dep_encontrado.fechaDeNacimiento + "\nSexo: " + dep_encontrado.sexo + "\nCategoría: " + dep_encontrado.Categoria +
            "\nClub: " + dep_encontrado.club);
        } else {
            System.out.println("No se encontro ningún deportista con ese nombre o número de identificación");
        }

    }

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

        Scanner sc_eleccion = new Scanner(System.in);
        int eleccion = sc_eleccion.nextInt();

        switch (eleccion) {
            case 1: // 1. Crear deportista
                
                System.out.println();
                System.out.println(" Ingrese los siguientes datos línea por línea y en este orden: Número de identificación, nombre,"
                + " fecha de nacimiento (yyyy-m-dd), sexo (M,F), nivel (escuela, novatos, ligados), club");

                String datos = "";
                
                Scanner sc = new Scanner(System.in);

                for(int i = 0; i < 6; i++) {
                    datos += sc.nextLine() + " ";
                }

                FileWriter myWriter = new FileWriter("data.txt");

                //Llamamos la función
                String dep_txt_str = CrearDeportista(datos, lista_deportistas);

                myWriter.write(dep_txt_str);
                myWriter.close();

                break;

            case 2: // 2. Buscar deportista

                System.out.println();
                System.out.println("Digite el número de identidad o el nombre completo del deportista que quiere buscar");
                Scanner sc_1 = new Scanner(System.in);
                deportista dep_buscar;
                String[] dep_busqueda_str = new String[2];;

                //Creamos un deportista con el dato dado
                if(sc_1.hasNextInt()) {
                    dep_busqueda_str[0] = sc_1.nextLine();
                    dep_busqueda_str[1] = "";
                    dep_buscar = new deportista(dep_busqueda_str);
                } else {
                    dep_busqueda_str[1] = sc_1.nextLine();
                    dep_busqueda_str[0] = "";
                    dep_buscar = new deportista(dep_busqueda_str);
                }

                //Llamamos la función
                BuscarDeportista(dep_buscar, lista_deportistas);

                break;

            case 3: //Actualizar deportista

            System.out.println();
            System.out.println("Digite el número de identidad o el nombre completo del deportista que quiere actualizar");

            boolean seguir_actualizando = true;

            Scanner sc_2 = new Scanner(System.in);
            deportista dep_actualizar;
            String[] dep_actualizar_str = new String[2];;

            //Creamos un deportista con el dato dado
            if(sc_2.hasNextInt()) {
                dep_actualizar_str[0] = sc_2.nextLine();
                dep_actualizar_str[1] = "";
                dep_buscar = new deportista(dep_actualizar_str);
            } else {
                dep_actualizar_str[1] = sc_2.nextLine();
                dep_actualizar_str[0] = "";
                dep_buscar = new deportista(dep_actualizar_str);
            }

            //Llamamos la función búscar
            BuscarDeportista(dep_buscar, lista_deportistas);

            while (seguir_actualizando) {

                System.out.println();
                System.out.println("¿Que dato desea actualziar?:\n1. Número de identificación\n2. Nombre\n3. Fecha de nacimiento\n4. Sexo\n5. nivel \n6. Club");

            }


            default:
                break;
        }

        sc_eleccion.close();




        
    }
    
}
