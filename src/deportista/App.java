package deportista;

import java.io.*;
import java.util.Scanner;

import EstructurasDeDatos.Cola_ListaEnlazada;
import EstructurasDeDatos.Entrada;
import EstructurasDeDatos.HashTable;
import EstructurasDeDatos.Pila_ListaEnlazada;

public class App {
    
    //MENU

    public static void menu(){
        System.out.println("¿Que desea hacer?");
        System.out.println();
        System.out.println("1. Crear nuevo deportista");
        System.out.println("2. Buscar deportista");
        System.out.println("3. Actualizar un deportista");
        System.out.println("4. Eliminar un deportista");
        System.out.println("5. Mostrar deportistas");
        System.out.println("6. Administrar competencias");
        System.out.println("7. Mostrar resultados");
        System.out.println("8. Finalizar");

    }

    public static void main(String[] args) throws IOException{

        FileReader fileReader;
        BufferedReader bufferedReader;

        Cola_ListaEnlazada<String> cola_datos = new Cola_ListaEnlazada<String>();
        HashTable<competencia> competencias = new HashTable<>(50); //máximo 50 competencias 
        int totalCompetencias = 0;
        Boolean programa = true;
        baseDeportistas deportistas = new baseDeportistas();

        //Ingreso todos los deportistas del txt a una lista
        deportistas.txtLista();

        //Ingreso todos los deportistas del txt a una pila
        deportistas.txtPila();

        Scanner sc = new Scanner(System.in);
        int eleccion = 0;

        // Le pregunto al usuario que desea hacer
        while(programa){
            menu();
            eleccion=sc.nextInt();
            String blankspace = sc.nextLine();
            
            if (eleccion == 1){ //Crear nuevo deportista
                System.out.println();
                System.out.println(" Ingrese los siguientes datos línea por línea y en este orden:\n ->Número de identificación\n ->nombre"
                + "\n ->fecha de nacimiento (yyyy-m-dd)\n ->sexo (M,F)\n ->nivel (escuela, novatos, ligados)\n ->club");


                for(int i = 0; i < 6; i++) {
                    cola_datos.insertar(sc.nextLine());
                }

                //Llamamos la función
                deportistas.CrearDeportista(cola_datos, deportistas.getPila_deportistas());
                System.out.println("Deportista creado exitosamente");

                //Actualizamos txt
                FileWriter myWriter = new FileWriter("data.txt");
                String dep_txt_str = deportistas.Actualizar_txt(deportistas.getPila_deportistas());
                myWriter.write(dep_txt_str);
                myWriter.close();

            } else if (eleccion == 2){ //Buscar deportista
                System.out.println();
                System.out.println("Digite el número de identidad del deportista que quiere buscar");
                
                deportista dep_buscar;
                String[] dep_busqueda_str = new String[2];

                //Creamos un deportista con el dato dado
                if(sc.hasNextInt()) {
                    dep_busqueda_str[0] = sc.nextLine();
                    dep_busqueda_str[1] = "";
                    dep_buscar = new deportista(dep_busqueda_str);
                } else {
                    dep_busqueda_str[1] = sc.nextLine();
                    dep_busqueda_str[0] = "";
                    dep_buscar = new deportista(dep_busqueda_str);
                }

                //Llamamos la función
                deportistas.BuscarDeportista(dep_buscar, deportistas.getLista_deportistas());
                

            } else if (eleccion == 3){ //Actualizar un deportista
                System.out.println();
                System.out.println("Digite el número de identidad o el nombre completo del deportista que quiere actualizar");

                boolean seguir_actualizando = true;
                deportista dep_actualizar;
                String[] dep_actualizar_str = new String[2];;

                //Creamos un deportista con el dato dado
                if(sc.hasNextInt()) {
                    dep_actualizar_str[0] = sc.nextLine();
                    dep_actualizar_str[1] = "";
                    dep_actualizar = new deportista(dep_actualizar_str);
                } else {
                    dep_actualizar_str[1] = sc.nextLine();
                    dep_actualizar_str[0] = "";
                    dep_actualizar = new deportista(dep_actualizar_str);
                }

                //Llamamos la función búscar
                deportistas.BuscarDeportista(dep_actualizar, deportistas.getLista_deportistas());

                while (seguir_actualizando) {
                    System.out.println();
                    System.out.println("¿Que dato desea actualzar?:\n1. Número de identificación\n2. Nombre\n3. Fecha de nacimiento\n4. Sexo\n5. nivel \n6. Club");
                    
                    int dato_cambiar = sc.nextInt();
                    blankspace = sc.nextLine();
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
                        if(sc.nextLine().compareTo("") == 0){
                            EmptyLine = true;
                        }
                    }
                    dato_actualizado = sc.nextLine();

                    //Actualizamos deportista
                    dep_actualizado = deportistas.ActualizarDeportista(dep_actualizar, dato_actualizado, dato_cambiar, deportistas.getLista_deportistas());

                    //Actualizamos txt
                    dep_act_str = deportistas.Actualizar_txt(deportistas.getLista_deportistas());
                    myWriter_1.write(dep_act_str);
                    myWriter_1.close();

                    //Imprimimos deportista actualziado
                    System.out.println();
                    System.out.println("Se ha actualizado el deportista exitosamente!");
                    System.out.println();
                    deportistas.BuscarDeportista(dep_actualizado, deportistas.getLista_deportistas());

                    seguir_actualizando = false;
        
                }

                
            } else if (eleccion == 4){ //Eliminar un deportista
                System.out.println();
                System.out.println("Digite el número de identidad o el nombre completo del deportista que quiere borrar");
                
                deportista dep_borrar;
                String[] dep_borrar_str = new String[2];;

                FileWriter myWriter_2 = new FileWriter("data.txt");
                String borrar_act_str = "";

                //Creamos un deportista con el dato dado
                if(sc.hasNextInt()) {
                    dep_borrar_str[0] = sc.nextLine();
                    dep_borrar_str[1] = "";
                    dep_borrar = new deportista(dep_borrar_str);
                } else {
                    dep_borrar_str[1] = sc.nextLine();
                    dep_borrar_str[0] = "";
                    dep_borrar = new deportista(dep_borrar_str);
                }

                //Llamamos la función búscar
                deportistas.BuscarDeportista(dep_borrar, deportistas.getLista_deportistas());

                //Preguntamos si quiere eliminar este deportista
                System.out.println();
                System.out.println("¿Esta seguro de que quiere eliminar este deportista? \n0. Si\n1. No");
                int decision = sc.nextInt();
                blankspace = sc.nextLine();

                if(decision == 0) {

                    int pos = deportistas.getLista_deportistas().buscarPos(dep_borrar);
                    if(pos == deportistas.getLista_deportistas().tamaño) {
                        deportistas.getLista_deportistas().eliminar();
                    } else {
                        deportistas.getLista_deportistas().eliminar(pos);
                    }

                    //Actualizamos txt
                    borrar_act_str = deportistas.Actualizar_txt(deportistas.getLista_deportistas());
                    myWriter_2.write(borrar_act_str);
                    myWriter_2.close();


                    System.out.println();
                    System.out.println("Deportista eliminado exitosamente!");

                }
                
                myWriter_2.close();

            } else if (eleccion == 5){ //Mostrar deportistas
                String[] arreglo_imprimir = new String[deportistas.getLista_deportistas().tamaño+1];

                for (int i =0; i<arreglo_imprimir.length; i++){
                    arreglo_imprimir[i]=deportistas.getLista_deportistas().buscar(i).númerodeidentificación +" " + deportistas.getLista_deportistas().buscar(i).nombre +" "+ deportistas.getLista_deportistas().buscar(i).Categoria +" "+ deportistas.getLista_deportistas().buscar(i).sexo +" "+deportistas.getLista_deportistas().buscar(i).nivel +" "+ deportistas.getLista_deportistas().buscar(i).club;
                }

                for (int k =0; k<arreglo_imprimir.length; k++){
                    System.out.println(arreglo_imprimir[k]+"\t");
                }

            } else if (eleccion == 6){ //Administrar competencias
                
                // Primero pasamos los datos del txt a la clase competencia
        
                File dataFile = new File("competencias.txt");
                fileReader = new FileReader(dataFile);
                bufferedReader = new BufferedReader(fileReader);
                String currentLine = bufferedReader.readLine();
                    
                while(currentLine != null) {
                    String nombreComp = currentLine;
                    int numeroDeportistas = Integer.parseInt(bufferedReader.readLine());
                    Pila_ListaEnlazada<String> IDs = new Pila_ListaEnlazada<>();
                    for (int i=0; i<numeroDeportistas; i++){
                        currentLine = bufferedReader.readLine();
                        IDs.insertar(currentLine);
                    }

                    competencia nuevaCompetencia = new competencia(nombreComp, deportistas.getLista_deportistas(), IDs);
                    Entrada<competencia> nuevaEntrada = new Entrada<competencia>(totalCompetencias, nuevaCompetencia);
                    totalCompetencias++;
                    competencias.insertar(nuevaEntrada);
                    currentLine = bufferedReader.readLine();
                }
                    
                System.out.println();
                System.out.println("¿ Qué desea hacer?");
                System.out.println("1. Inscribir deportistas en competencias existentes");
                System.out.println("2. Ingresar tiempos");
                System.out.println("3. Crear nueva competencia");

                int elec_Comp = sc.nextInt();
                blankspace = sc.nextLine();

                if (elec_Comp==1){              //inscribir deportistas
                    System.out.println();
                    System.out.println("Ingrese el numero de la competencia:");
                    String numeroCompetencia = sc.nextLine();
                    competencia compInscribir = competencias.find(numeroCompetencia);

                    System.out.println("Ingrese el número de deportistas a inscribir:");

                    int num_deportistas_inscribir = sc.nextInt();
                    blankspace = sc.nextLine();

                    System.out.println("Digite los números de identificación de los deportistas linea por linea:");
                    

                    // Agregamos deportistas
                    for (int i = 0; i < num_deportistas_inscribir; i++) {
                        String id = sc.nextLine(); 
                        compInscribir.añadirDeportista(id);
                    }

                    System.out.println("Deportistas añadidos a la competencia!");
                            
                    // Actualizamos TXT
                    FileWriter myWriter3 = new FileWriter("competencias.txt");
                    String competencias_txt = "";
                    for(int i=0; i<totalCompetencias; i++){
                        String competenciaI = competencias.find(String.valueOf(i)).actualizarTxtCompetencia();
                        if (i==0){
                            competencias_txt=competencias_txt + competenciaI;
                        } else {
                            competencias_txt= competencias_txt +"\n"+ competenciaI;
                        }
                    }
                    myWriter3.write(competencias_txt);
                    myWriter3.close();

                    System.out.println("Competencia actualizada exitosamente");
                            
                        
                } else if (elec_Comp== 2) {     // ingresar tiempos
                    System.out.println();
                    System.out.println("Ingrese el numero de la competencia:");
                    String numeroCompetencia = sc.nextLine();
                    competencia compCerrar = competencias.find(numeroCompetencia);
                    compCerrar.cerrarCompetencia();
                    compCerrar.añadirResultado();

                } else if (elec_Comp== 3){      // crear nueva competencia
                    System.out.println();
                    System.out.println("Ingrese el nombre de la competencia:");
                    String nombreComp = sc.nextLine();
                    competencia nuevaCompetencia = new competencia(nombreComp, deportistas.getLista_deportistas());

                    System.out.println("Ingrese el número de deportistas a inscribir:");
                    int num_deportistas_inscribir = sc.nextInt();
                    blankspace = sc.nextLine();

                    System.out.println("Digite los números de identificación de los deportistas linea por linea:");
                    

                    // Agregamos deportistas
                    for (int i = 0; i < num_deportistas_inscribir; i++) {
                       String id = sc.nextLine(); 
                        nuevaCompetencia.añadirDeportista(id);
                    }

                    Entrada<competencia> nuevaEntrada = new Entrada<competencia>(totalCompetencias, nuevaCompetencia);
                    totalCompetencias++;
                    competencias.insertar(nuevaEntrada);
                    
                    // Actualizamos TXT
                    FileWriter myWriter3 = new FileWriter("competencias.txt");
                    String competencias_txt = "";
                    for(int i=0; i<totalCompetencias; i++){
                        String competenciaI = competencias.find(String.valueOf(i)).actualizarTxtCompetencia();
                        if (i==0){
                            competencias_txt=competencias_txt + competenciaI;
                        } else {
                            competencias_txt= competencias_txt +"\n"+ competenciaI;
                        }
                    }
                    myWriter3.write(competencias_txt);
                    myWriter3.close();

                    System.out.println("Competencia creada exitosamente");
                }
                
                
            } else if (eleccion == 7){ //Mostrar resultados
                
                System.out.println();
                System.out.println("Ingrese el numero de la competencia:");
                String numeroCompetencia = sc.nextLine();
                competencia compResultados = competencias.find(numeroCompetencia);
                compResultados.mostrarResultados();
            } else if (eleccion == 8){ //Finalizar
                programa=false;
            } 
            
            System.out.println();
            
        }
        sc.close();
    }
    
}
