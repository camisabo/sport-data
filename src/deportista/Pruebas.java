package deportista;

import java.time.LocalDate;

public class Pruebas {

    public static void main(String[] args) {

        LocalDate FechaDeNacimiento = LocalDate.of(2005, 9, 23);

        deportista dep_prueba = new deportista(1001299399, "Juan Sebastian Castro Pardo", "Racing Skate", 'V', "escuela", FechaDeNacimiento);

        System.out.println(dep_prueba.Categoria);
        
    }
    
}
