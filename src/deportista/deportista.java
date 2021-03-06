/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deportista;

import java.time.LocalDate;
import java.time.Period;

import EstructurasDeDatos.ListaEnlazada;

/**
 *
 * @author Omar Nicolas Guerrero
 * @author SebastianCastro
 */
public class deportista implements Comparable<deportista> {
    
    //atributos
    public String númerodeidentificación;
    public String nombre;
    public String club;
    public String sexo;
    public String nivel;                                       // escuela, novatos, ligados
    public LocalDate fechaDeNacimiento;
    private LocalDate refDate = LocalDate.of(2021,6,1);         //Fecha referencia para calcular la edad y al categoría
    public ListaEnlazada<String> competencias = new ListaEnlazada<String>();
    public ListaEnlazada<Float> tiempos = new ListaEnlazada<Float>();


    //Categoria tipo String
    public String Categoria; 
    
    //contructor
    public deportista(String[] datos) {

        if(datos.length == 2){ //Para la busqueda por nombre o por documento
            this.númerodeidentificación = datos[0];
            this.nombre = datos[1];
            this.fechaDeNacimiento = null;
            this.sexo = null;
            this.nivel = null;
            this.club = null;
        } else { // en caso normal

            this.númerodeidentificación = datos[0];
            int[] fechaNacimiento = new int[3];
            String[] fecha = datos[2].split("-");
            String aux_nombre = datos[1];

            for (int i =0; i<fecha.length;i++){
                fechaNacimiento[i] = Integer.parseInt(fecha[i]);

            }

            this.nombre = aux_nombre.replaceFirst("\\s++$", "");

            this.fechaDeNacimiento = LocalDate.of(fechaNacimiento[0], fechaNacimiento[1], fechaNacimiento[2]);

            this.sexo = datos[3];
            this.nivel = datos[4];
            this.club = datos[5];
            
            this.Categoria = generarCategoria(fechaDeNacimiento, refDate, nivel);
        }
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

    public ListaEnlazada<String> getCompetencias(){
        return competencias;
    }

    public void setCompetencias(ListaEnlazada<String> competencias){
        this.competencias = competencias;
    }

    public ListaEnlazada<Float> getTiempos(){
        return tiempos;
    }

    public void setTiempos(ListaEnlazada<Float> tiempos){
        this.tiempos = tiempos;
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


    @Override
    public int compareTo(deportista d) {
        if(this.númerodeidentificación.compareTo(d.númerodeidentificación) == 0) {
            return 0;
        } else if (this.nombre.compareTo(d.nombre) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    }