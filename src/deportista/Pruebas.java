package deportista;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

import EstructurasDeDatos.Cola_ListaEnlazada;
import EstructurasDeDatos.ListaDoblementeEnlazada;
import EstructurasDeDatos.ListaEnlazada;
import EstructurasDeDatos.Pila_ListaEnlazada;

public class Pruebas {

    //MÉTODOS

    //1. CREAR DEPORTISTA

    public static void CrearDeportista(Cola_ListaEnlazada<String> cola_datos, Pila_ListaEnlazada<deportista> pila_deportistas) {

        
        String[] datos_new_dep = new String[6];

        cola_datos.printLista();
        for(int i=0; i<datos_new_dep.length;i++){
            datos_new_dep[i]=cola_datos.dequeue();
        }
        deportista new_dep = new deportista(datos_new_dep);
        pila_deportistas.insertar(new_dep);

    }

    //ACTUALIZAR TXT
    public static String Actualizar_txt (Pila_ListaEnlazada<deportista> pila_deportistas) {
        String dep_txt_str = "";
        deportista dep_txt;

        while( pila_deportistas.primerNodo != null){

            dep_txt = pila_deportistas.pop();
            dep_txt_str += dep_txt.númerodeidentificación + "%" + dep_txt.nombre + "%" + dep_txt.fechaDeNacimiento + "%" + dep_txt.sexo + "%" + dep_txt.nivel + "%" + dep_txt.club + "\n";
        }
        return dep_txt_str;
    }

    public static String Actualizar_txt (ListaEnlazada<deportista> lista_deportistas) {
        String dep_txt_str = "";
        for (int i = 0; i <= lista_deportistas.tamaño; i++) {
            deportista dep_txt = lista_deportistas.buscar(i);
            if(i==0) {
                dep_txt_str += dep_txt.númerodeidentificación + "%" + dep_txt.nombre + "%" + dep_txt.fechaDeNacimiento + "%" + dep_txt.sexo + "%" + dep_txt.nivel + "%" + dep_txt.club;
            } else {
                dep_txt_str += "\n" + dep_txt.númerodeidentificación + "%" + dep_txt.nombre + "%" + dep_txt.fechaDeNacimiento + "%" + dep_txt.sexo + "%" + dep_txt.nivel + "%" + dep_txt.club;
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

    // 3. ACTUALIZAR DEPORTISTA

    public static deportista ActualizarDeportista (deportista dep_actualizar, String dato_actualizado, int dato_cambiar, ListaEnlazada<deportista> lista_deportistas) {

        int[] fecha_num = new int[3];

        //Buscamos el deportista y le cambiamos el dato
        int posicion = lista_deportistas.buscarPos(dep_actualizar);
        deportista dep_act = lista_deportistas.buscar(posicion);
        System.out.println(posicion);
        
        switch (dato_cambiar) {
            case 1: 
                dep_act.setnúmerodeidentificación(dato_actualizado);
                break;
            case 2:
                dep_act.setnombre(dato_actualizado);
                break;
            case 3:
                String[] nacimiento = dato_actualizado.split("-");
                for(int i = 0; i < 3; i++) {
                    fecha_num[i] = Integer.parseInt(nacimiento[i]);
                }
                dep_act.setfechaDeNacimiento(LocalDate.of(fecha_num[0], fecha_num[1], fecha_num[2]));
                break;
            case 4:
                dep_act.setsexo(dato_actualizado);
                break;
            case 5:
                dep_act.setnivel(dato_actualizado);
                break;
            case 6:
                dep_act.setclub(dato_actualizado);
            default:
                break;
        }

        //Ingresamos el deportista actualizado a la lista
        lista_deportistas.eliminar(posicion);
        lista_deportistas.insertar(dep_act, posicion);

        return dep_act;

    }

    public static void main(String[] args) throws IOException{


        FileReader fileReader;
        BufferedReader bufferedReader;

        ListaDoblementeEnlazada<deportista> lista_deportistas = new ListaDoblementeEnlazada<deportista>(null); 
        Cola_ListaEnlazada<String> cola_datos = new Cola_ListaEnlazada<String>();
        Pila_ListaEnlazada<deportista> pila_deportistas = new Pila_ListaEnlazada<deportista>();

        //Ingreso todos los deportistas del txt a una lista

        try {


            File dataFile = new File("data.txt");
            fileReader = new FileReader(dataFile);
            bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            int n = 0;


            while(currentLine != null){

                String[] DataArray = currentLine.split("%");
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

        //Ingreso todos los deportistas del txt a una pila

        try {

            File dataFile = new File("data.txt");
            fileReader = new FileReader(dataFile);
            bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();

            while(currentLine != null){
                
                String[] DataArray = currentLine.split("%");
                deportista dep = new deportista(DataArray);
                pila_deportistas.insertar(dep);
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
                + " fecha de nacimiento (yyyy/mm/dd), sexo (M,F), nivel (escuela, novatos, ligados), club");
                
                Scanner sc = new Scanner(System.in);

                for(int i = 0; i < 6; i++) {
                    cola_datos.insertar(sc.nextLine());
                }

                //Llamamos la función
                CrearDeportista(cola_datos, pila_deportistas);

                //Actualizamos txt

                FileWriter myWriter = new FileWriter("data.txt");
                String dep_txt_str = Actualizar_txt(pila_deportistas);
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
                dep_actualizar = new deportista(dep_actualizar_str);
            } else {
                dep_actualizar_str[1] = sc_2.nextLine();
                dep_actualizar_str[0] = "";
                dep_actualizar = new deportista(dep_actualizar_str);
            }

            //Llamamos la función búscar
            BuscarDeportista(dep_actualizar, lista_deportistas);

            while (seguir_actualizando) {

                System.out.println();
                System.out.println("¿Que dato desea actualzar?:\n1. Número de identificación\n2. Nombre\n3. Fecha de nacimiento\n4. Sexo\n5. nivel \n6. Club");
                Scanner sc_3 = new Scanner(System.in);
                int dato_cambiar = sc_3.nextInt();
                String dato_actualizado = "";

                FileWriter myWriter_1 = new FileWriter("data.txt");
                deportista dep_actualizado;
                String dep_act_str;

                String dato_cambiar_str = "";

                switch (dato_cambiar) {
                    case 1:
                        dato_cambiar_str = "el neuvo número de identificación";
                        break;
                    case 2:
                        dato_cambiar_str = "el nuevo nombre";
                        break;
                    case 3:
                        dato_cambiar_str = "la nueva fecha de nacimiento";
                        break;
                    case 4:
                        dato_cambiar_str = "el sexo que le asignará al deportista (M,F)";
                        break;
                    case 5:
                        dato_cambiar_str = "el nivel al que desea cambiar al deportista";
                        break;
                    case 6:
                        dato_cambiar_str = "el nuevo club";
                    default:
                        break;
                }

                System.out.println();
                System.out.println("Digite " + dato_cambiar_str); 

                //Recibimos el nuevo dato
                boolean EmptyLine = false;
                while(!EmptyLine) {
                    if(sc_3.nextLine().compareTo("") == 0){
                        EmptyLine = true;
                    }
                }
                dato_actualizado = sc_3.nextLine();

                //Actualizamos deportista
                dep_actualizado = ActualizarDeportista(dep_actualizar, dato_actualizado, dato_cambiar, lista_deportistas);

                //Actualizamos txt
                dep_act_str = Actualizar_txt(lista_deportistas);
                myWriter_1.write(dep_act_str);
                myWriter_1.close();

                //Imprimimos deportista actualziado

                System.out.println();
                System.out.println("Se ha actualizado el deportista exitosamente!");
                System.out.println();
                BuscarDeportista(dep_actualizado, lista_deportistas);

                sc_3.close();
                seguir_actualizando = false;
  
                }
                
                break;

            case 4: //Eliminar un deportista

                System.out.println();
                System.out.println("Digite el número de identidad o el nombre completo del deportista que quiere borrar");

                Scanner sc_4 = new Scanner(System.in);
                deportista dep_borrar;
                String[] dep_borrar_str = new String[2];;

                FileWriter myWriter_2 = new FileWriter("data.txt");
                String borrar_act_str = "";

                //Creamos un deportista con el dato dado
                if(sc_4.hasNextInt()) {
                    dep_borrar_str[0] = sc_4.nextLine();
                    dep_borrar_str[1] = "";
                    dep_borrar = new deportista(dep_borrar_str);
                } else {
                    dep_borrar_str[1] = sc_4.nextLine();
                    dep_borrar_str[0] = "";
                    dep_borrar = new deportista(dep_borrar_str);
                }

                //Llamamos la función búscar
                BuscarDeportista(dep_borrar, lista_deportistas);

                //Preguntamos si quiere eliminar este deportista

                System.out.println();
                System.out.println("¿Esta seguro de que quiere eliminar este deportista? \n0. Si\n1. No");
                int decision = sc_4.nextInt();

                if(decision == 1) {
                    break;
                } else if(decision == 0) {

                    int pos = lista_deportistas.buscarPos(dep_borrar);
                    if(pos == lista_deportistas.tamaño) {
                        lista_deportistas.eliminar();
                    } else {
                        lista_deportistas.eliminar(pos);
                    }

                    //Actualizamos txt

                    borrar_act_str = Actualizar_txt(lista_deportistas);
                    myWriter_2.write(borrar_act_str);
                    myWriter_2.close();


                    System.out.println();
                    System.out.println("Deportista eliminado exitosamente!");

                    break;

                }

                break;

            default:
                break;
        }

        sc_eleccion.close();




        
    }
    
}
