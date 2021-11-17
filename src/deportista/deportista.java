/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deportista;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Omar Nicolas Guerrero
 * @author SebastianCastro
 */
public class Deportista {
    
    //atributos
    private int númerodeidentificación;
    private String nombre;
    private String club;
    private char sexo;
    private String nivel; // escuela, novatos, ligados
    private LocalDate fechaDeNacimiento;
    private LocalDate CurrentDate = LocalDate.of(2021,11,15);
    
    //Categoria tipo String
    private String Categoria; 
    
    //contructor
    public Deportista(int númerodeidentificación, String nombre, String club, 
            char sexo, String nivel, LocalDate fechaDeNacimiento) {
        this.númerodeidentificación = númerodeidentificación;
        this.nombre = nombre;
        this.club = club;
        this.sexo = sexo;
        this.nivel = nivel;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.Categoria = generarCategoria(fechaDeNacimiento, CurrentDate, nivel);
        
    }
    

    //getters y setters
    public LocalDate getfechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setfechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getnúmerodeidentificación() {
        return númerodeidentificación;
    }

    public void setnúmerodeidentificación(int númerodeidentificación) {
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

    public char getsexo() {
        return sexo;
    }

    public void setsexo(char sexo) {
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

    public LocalDate getCurrentDate() {
        return CurrentDate;
    }

    public void setCurrentDate(LocalDate CurrentDate) {
        this.CurrentDate = CurrentDate;
    }

    
    //metodos

    //Generar categoría

    private String generarCategoria(LocalDate nacimiento, LocalDate CurrentDate, String nivel) {

        int age = Period.between(nacimiento, CurrentDate).getYears();
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