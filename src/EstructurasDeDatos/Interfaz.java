package EstructurasDeDatos;

public interface Interfaz<T>{
    public boolean empty();
    public boolean full();
    public T eliminar();
    public void insertar(T dato);
        
}
