/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Ejercicio #3
Eliazar Canastuj
carnet: 23384
*/

import java.util.ArrayList;

public class estudiante{
    private String nombre;
    private String apellido;
    private int codigo;
    private String fecha;
    private String correo;
    private ArrayList<examen> listexamen;

    public estudiante(String nombre, String apellido, int codigo, String fecha, String correo, ArrayList<examen> listexamen){
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.fecha = fecha;
        this.correo = correo;
        this.listexamen = listexamen;
    }

//metodos

    //obtener el nombre
    public String getNombre(){
        return this.nombre;
    }

    //obtener codigo
    public int getCodigo(){
        return this.codigo;
    }

    //obtener lista de examenes
    public ArrayList<examen> getListaExamen() {
        return listexamen;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Apellido: ").append(apellido).append("\n");
        sb.append("Código: ").append(codigo).append("\n");
        sb.append("Fecha de nacimiento: ").append(fecha).append("\n");
        sb.append("Correo: ").append(correo).append("\n");
        sb.append("Exámenes:\n");
        for (examen examen : listexamen) {
            sb.append("- ").append(examen).append("\n");
        }
        return sb.toString();
    }

}
