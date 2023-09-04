/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Ejercicio #3
Eliazar Canastuj
carnet: 23384
*/


public class examen{
    private String nombre;
    private float nota;

    public examen(String nombre, float nota){
        this.nombre = nombre;
        this.nota = nota;
    }

//metodos

    //obtener el nombre
    public String getNameE(){
        return this.nombre;
    }

    //obtener la nota
    public float getNota(){
        return this.nota;
    }

    public String toString() {
        return "Nombre del examen: " + nombre + ", Nota: " + nota;
    }

}