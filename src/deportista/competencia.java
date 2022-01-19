package deportista;

import EstructurasDeDatos.ArbolAVL;
import EstructurasDeDatos.Cola_ListaEnlazada;
import EstructurasDeDatos.ListaEnlazada;
import EstructurasDeDatos.Pila_ListaEnlazada;
import EstructurasDeDatos.*;
import java.lang.Integer;
import java.util.Scanner;

public class competencia implements Comparable<competencia>{

    //Atributos 
    public ListaDoblementeEnlazada<deportista> listaDeportistas;
    public Boolean competenciaAbierta = true;
    public ListaEnlazada<deportista> deportistasInscritos = new ListaEnlazada<>();
    public String nombreCompetencia;
    public int id;
    public ArbolAVL<Resultado> resultadosArbol = new ArbolAVL<>();
    public ListaEnlazada<Resultado> resultadosLista = new ListaEnlazada();

    public competencia(){

    }
    
    public competencia(String nombre, ListaDoblementeEnlazada<deportista> listaDeportistas){
        this.listaDeportistas = listaDeportistas;
        this.nombreCompetencia = nombre;
    }

    public competencia(String nombre, ListaDoblementeEnlazada<deportista> listaDeportistas, Pila_ListaEnlazada<String> IDs){
        this.listaDeportistas = listaDeportistas;
        this.nombreCompetencia = nombre;
        deportista dep_inscribir;

        while (!IDs.empty()) {

            String[] dep_data = new String[2];
            dep_data[0] = IDs.pop();
            dep_data[1] = "";
            dep_inscribir = new deportista(dep_data);

            if(listaDeportistas.buscar(dep_inscribir)) {
                int pos = listaDeportistas.buscarPos(dep_inscribir);
                deportista dep_found = listaDeportistas.buscar(pos);
                if(this.deportistasInscritos == null) {
                    this.deportistasInscritos = new ListaEnlazada<deportista>(dep_found);
                } else {
                    deportistasInscritos.insertar(dep_found);
                }            
            } else {
                System.out.println("No existe el deportista con ese número de identificación");
            }

        }
    }

    //Métodos

    //Agrega uno por uno los deportistas inscritos según el número de identificación
    public void añadirDeportista(String numeroIdentificacion){
        if (competenciaAbierta == true) {
            String[] depAñadirStr = new String[2];
            depAñadirStr[0] = numeroIdentificacion;
            depAñadirStr[1] = "";
            deportista deportistaNuevo = new deportista(depAñadirStr);
            if(listaDeportistas.buscar(deportistaNuevo)) {
                int posicion = listaDeportistas.buscarPos(deportistaNuevo);
                deportista deportistaEncontrado = listaDeportistas.buscar(posicion);
                deportistasInscritos.insertar(deportistaEncontrado);
                deportistaEncontrado.competencias.insertar(nombreCompetencia);
                deportistaEncontrado.tiempos.insertar(new Float(0));
            } else {
                System.out.println("No se encontro ningún deportista con ese nombre o número de identificación");
            }
 
        }
    }

    public void cerrarCompetencia(){
        competenciaAbierta = false;
    }

    public void añadirResultado(){
        Nodo<deportista> deportistaResultado = deportistasInscritos.primerNodo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte los tiempos frente al número de identificación correspondiente (usar coma)");
        while (deportistaResultado!=null){
            System.out.print(deportistaResultado.getDato().getnúmerodeidentificación()+": ");
            Float tiempo = sc.nextFloat();
            Resultado resultado = new Resultado(deportistaResultado.getDato(), tiempo);
            resultadosArbol.insertar(resultado);
            resultadosLista.insertar(resultado);
            deportistaResultado = deportistaResultado.NodoSiguiente;
        }
        sc.nextLine();
        sc.close();
        System.out.println("Resultados añadidos con éxito!");
    }

    public void mostrarResultados(){
        
    }
    @Override
    public int compareTo(competencia c) {
        if(this.nombreCompetencia.compareTo(c.nombreCompetencia) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    
    
}
