package deportista;

import java.io.*;
import java.time.LocalDate;

import EstructurasDeDatos.Cola_ListaEnlazada;
import EstructurasDeDatos.ListaDoblementeEnlazada;
import EstructurasDeDatos.ListaEnlazada;
import EstructurasDeDatos.Pila_ListaEnlazada;


public class baseDeportistas {
    //ATRIBUTOS
    ListaDoblementeEnlazada<deportista> lista_deportistas = new ListaDoblementeEnlazada<deportista>(null); 
    Pila_ListaEnlazada<deportista> pila_deportistas = new Pila_ListaEnlazada<deportista>();
    FileReader fileReader;
    BufferedReader bufferedReader;

    //CONSTRUCTOR
    public baseDeportistas(){

    }

    //SETTERS GETTERS

    public void setLista_deportistas(ListaDoblementeEnlazada<deportista> lista_deportistas) {
        this.lista_deportistas = lista_deportistas;
    }

    public ListaDoblementeEnlazada<deportista> getLista_deportistas() {
        return lista_deportistas;
    }

    public void setPila_deportistas(Pila_ListaEnlazada<deportista> pila_deportistas) {
        this.pila_deportistas = pila_deportistas;
    }

    public Pila_ListaEnlazada<deportista> getPila_deportistas() {
        return pila_deportistas;
    }
    //MÉTODOS

    //1. CREAR DEPORTISTA

    public void CrearDeportista(Cola_ListaEnlazada<String> cola_datos, Pila_ListaEnlazada<deportista> pila_deportistas) {

        String[] datos_new_dep = new String[6];

        cola_datos.printLista();
        for(int i=0; i<datos_new_dep.length;i++){
            datos_new_dep[i]=cola_datos.dequeue();
        }
        deportista new_dep = new deportista(datos_new_dep);
        pila_deportistas.insertar(new_dep);

    }

    //ACTUALIZAR TXT
    public String Actualizar_txt (Pila_ListaEnlazada<deportista> pila_deportistas) {
        String dep_txt_str = "";
        deportista dep_txt;

        while( pila_deportistas.primerNodo != null){

            dep_txt = pila_deportistas.pop();
            dep_txt_str += dep_txt.númerodeidentificación + "%" + dep_txt.nombre + "%" + dep_txt.fechaDeNacimiento + "%" + dep_txt.sexo + "%" + dep_txt.nivel + "%" + dep_txt.club + "\n";
        }
        return dep_txt_str;
    }

    public String Actualizar_txt (ListaEnlazada<deportista> lista_deportistas) {
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

    public void BuscarDeportista (deportista dep_buscar, ListaEnlazada<deportista> lista_deportistas) {

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

    public deportista ActualizarDeportista (deportista dep_actualizar, String dato_actualizado, int dato_cambiar, ListaEnlazada<deportista> lista_deportistas) {

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

    //Ingreso todos los deportistas del txt a una lista
    public void txtLista(){
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
    }

    //Ingreso todos los deportistas del txt a una pila
    public void txtPila(){
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
    }
}
