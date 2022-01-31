package deportista;


public class Resultado implements Comparable<Resultado>{
    
    public deportista deportista;
    public Float tiempo;

    public Resultado(deportista deportista, Float tiempo){
        this.deportista = deportista;
        this.tiempo = tiempo;
    }

    @Override
    public int compareTo(Resultado r) {
        if(this.tiempo.compareTo(r.tiempo) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public Float getTiempo() {
        return tiempo;
    }
    
    public void setTiempo(Float tiempo) {
        this.tiempo = tiempo;
    }

    public deportista getDeportista() {
        return deportista;
    }

    public void setDeportista(deportista deportista) {
        this.deportista = deportista;
    }
}
