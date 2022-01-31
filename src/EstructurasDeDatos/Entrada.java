package EstructurasDeDatos;

public class Entrada<T extends Comparable<T>> {

    int key;
    T value;

    public Entrada(int key, T value) {

        this.key = key;
        this.value = value;

    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
}
