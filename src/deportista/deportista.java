/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deportista;

import java.sql.Date;

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
    private char Nivel;
    private Date FechaDeNacimiento;
    
    //no se que tipo de dato es la categoria asi que lo dejo en tipo object
    private Object Categoria; 
    
    //contructor
    public deportista(int Númerodeidentificación, String Nombre, String Club, 
            char Sexo, char Nivel, Date FechaDeNacimiento) {
        this.Númerodeidentificación = Númerodeidentificación;
        this.Nombre = Nombre;
        this.Club = Club;
        this.Sexo = Sexo;
        this.Nivel = Nivel;
        this.FechaDeNacimiento = FechaDeNacimiento;
        //aqui se calcula o se espesifica la categoria;
        Categoria = new Object();
        
    }
    
    //getters y setters
    public Date getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date FechaDeNacimiento) {
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

    public char getNivel() {
        return Nivel;
    }

    public void setNivel(char Nivel) {
        this.Nivel = Nivel;
    }
    
    //metodos
    
    
    
}
