/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deportista;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class deportista {
    
    //atributos
    private String [] TiposDeNiveles = new String[3]; 
    private int Númerodeidentificación;
    private String Nombre;
    private String Club;
    private char Sexo;
    private String Nivel; // escuela, novatos, ligados
    private LocalDate FechaDeNacimiento;
    private LocalDate currentDate = LocalDate.of(2021,11,15);
    
    //Categoria tipo String
    public String Categoria; 
    
    //contructor
    public deportista(int Númerodeidentificación, String Nombre, String Club, 
            char Sexo, String Nivel, LocalDate FechaDeNacimiento) {
        this.Númerodeidentificación = Númerodeidentificación;
        this.Nombre = Nombre;
        this.Club = Club;
        this.Sexo = Sexo;
        this.Nivel = Nivel;
        this.FechaDeNacimiento = FechaDeNacimiento;
        this.Categoria = generarCategoria(FechaDeNacimiento, currentDate, Nivel);
        
    }
    

    //getters y setters
    public LocalDate getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate FechaDeNacimiento) {
        this.FechaDeNacimiento = FechaDeNacimiento;
    }

    public String[] getTiposDeNiveles() {
        return TiposDeNiveles;
    }

    public void setTiposDeNiveles(String[] TiposDeNiveles) {
        this.TiposDeNiveles = TiposDeNiveles;
    }

    public int getNúmerodeidentificación() {
        return Númerodeidentificación;
    }

    public void setNúmerodeidentificación(int Númerodeidentificación) {
        this.Númerodeidentificación = Númerodeidentificación;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getClub() {
        return Club;
    }

    public void setClub(String Club) {
        this.Club = Club;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }
    
    //metodos

    //Generar categoría

    public String generarCategoria(LocalDate nacimiento, LocalDate currentDate, String Nivel) {

        int age = Period.between(nacimiento, currentDate).getYears();
        String categoria = "";

        if(age == 4) {
            categoria = Nivel + " 4";
        } else if (age == 5 || age == 6) {
            categoria = Nivel + " 5-6";
        } else if (age == 7 || age == 8) {
            categoria = Nivel + " 7-8";
        } else if (age == 9 || age == 10) {
            categoria = Nivel + " 9-10";
        } else if (age == 11 || age == 12) {
            categoria = Nivel + " 11-12";
        } else if (age >= 13 && Nivel != "ligados") { //Con niveles diferentes a ligados
            categoria = "única " + Nivel; 
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

    
    
    

