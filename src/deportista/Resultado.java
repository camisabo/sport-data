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
}
