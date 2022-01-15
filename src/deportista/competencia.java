package deportista;

import EstructurasDeDatos.Cola_ListaEnlazada;
import EstructurasDeDatos.ListaDoblementeEnlazada;
import EstructurasDeDatos.ListaEnlazada;

public class competencia {

    public ListaDoblementeEnlazada<deportista> deportistas;
    

    public competencia(Cola_ListaEnlazada<String> IDs_deportistas, ListaEnlazada<deportista> lista_deportistas) {
        inscribirDeportistas(IDs_deportistas, lista_deportistas);
    }

    public void inscribirDeportistas(Cola_ListaEnlazada<String> IDs, ListaEnlazada<deportista> lista) {
        
        deportista dep_inscribir;

        while (!IDs.empty()) {

            String[] dep_data = new String[2];
            dep_data[0] = IDs.dequeue();
            dep_data[1] = "";
            dep_inscribir = new deportista(dep_data);

            if(lista.buscar(dep_inscribir)) {
                int pos = lista.buscarPos(dep_inscribir);
                deportista dep_found = lista.buscar(pos);
                deportistas.insertar(dep_found);
            } else {
                System.out.println("No existe el deportista con ese número de identificación");
            }

        }

    }
    
}
