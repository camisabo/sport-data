/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deportista;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Omar Nicolas Guerrero
 * @author SebastianCastro
 */
public class deportista {
    
    //atributos
    public String númerodeidentificación;
    public String nombre;
    public String club;
    public String sexo;
    public String nivel;                                       // escuela, novatos, ligados
    public LocalDate fechaDeNacimiento;
    private LocalDate refDate = LocalDate.of(2021,6,1);         //Fecha referencia para calcular la edad y al categoría
    
    //Categoria tipo String
    public String Categoria; 
    
    //contructor
    public deportista(String[] datos) {
        this.númerodeidentificación = datos[0];
        
        this.nombre = "";

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher;
        boolean matchFound;
        int n = 0;
        int[] fechaNacimiento = new int[3];
        
        for (int i = 1; i < datos.length; i++) {
            matcher = pattern.matcher(datos[i]);
            matchFound = matcher.find();
            if(matchFound) {
                fechaNacimiento[0] = Integer.parseInt(datos[i]);
                fechaNacimiento[1] = Integer.parseInt(datos[i+1]);
                fechaNacimiento[2] = Integer.parseInt(datos[i+2]);
                n = i + 3;
                i = datos.length;
            } else {
                this.nombre += " " + datos[i];
            }
        }

        this.fechaDeNacimiento = LocalDate.of(fechaNacimiento[0], fechaNacimiento[1], fechaNacimiento[2]);

        this.sexo = datos[n];
        this.nivel = datos[n+1];
        this.club = "";

        for (int x = n+2; x < datos.length; x++) {
            this.club += " " + datos[x];
        }

        this.Categoria = generarCategoria(fechaDeNacimiento, refDate, nivel);
    }
    

    //getters y setters
    public LocalDate getfechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setfechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getnúmerodeidentificación() {
        return númerodeidentificación;
    }

    public void setnúmerodeidentificación(String númerodeidentificación) {
        this.númerodeidentificación = númerodeidentificación;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getclub() {
        return club;
    }

    public void setclub(String club) {
        this.club = club;
    }

    public String getsexo() {
        return sexo;
    }

    public void setsexo(String sexo) {
        this.sexo = sexo;
    }

    public String getnivel() {
        return nivel;
    }

    public void setnivel(String nivel) {
        this.nivel = nivel;
    }
    
    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }


    
    //metodos

    //Generar categoría

    private String generarCategoria(LocalDate nacimiento, LocalDate CurrentDate, String nivel) {


        int age = Period.between(nacimiento, refDate).getYears();    //Edad calculada con la fecha referencia
        String categoria = "";

        if(age == 4) {
            categoria = nivel + " 4";
        } else if (age == 5 || age == 6) {
            categoria = nivel + " 5-6";
        } else if (age == 7 || age == 8) {
            categoria = nivel + " 7-8";
        } else if (age == 9 || age == 10) {
            categoria = nivel + " 9-10";
        } else if (age == 11 || age == 12) {
            categoria = nivel + " 11-12";
        } else if (age >= 13 && nivel != "ligados") { //Con niveles diferentes a ligados
            categoria = "única " + nivel; 
        } 

        //Con ligados

        else if (age == 14) {
            categoria = "prejuvenil";
        } else if (age == 15 || age == 16) {
            categoria = "juvenil"; 
        } else if (age >= 17) {
            categoria = "mayores";
        }

        return categoria;

        }

    }