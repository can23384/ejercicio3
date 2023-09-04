/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Ejercicio #3
Eliazar Canastuj
carnet: 23384
*/

import java.util.ArrayList;
import java.util.Collections;

public class sede{
    private String nombre;
    private ArrayList<estudiante> listestudiante;

    public sede(String nombre, ArrayList<estudiante> listestudiante){
        this.nombre = nombre;
        this.listestudiante = listestudiante;
    }

//metodos

    //obtener el nombre
    public String getNombre(){
        return this.nombre;
    }

    //obtener la lista de estudiantes
    public ArrayList<estudiante> getListaEstudiantes(){
        return this.listestudiante;
    }


    public static float promedio(ArrayList<Float> lista){
        float suma = 0;

        for (float numero : lista) {
            suma += numero;
        }

        float prom = suma / lista.size();
        return prom;
    }

    public static float mediana(ArrayList<Float> numero){
        Collections.sort(numero);

        float num_mediana = (numero.size() + 1) / 2;

        if(numero.size() % 2 == 0){
            float medio1 = numero.get((numero.size() / 2) - 1);
            float medio2 = numero.get(numero.size() / 2);
            return (float) (medio1 + medio2) / 2;
        }
        else{
            return numero.get(numero.size() / 2);
        }
    }

    public ArrayList<Float> moda(ArrayList<Float> numero){
        Collections.sort(numero);
        ArrayList<Float> moda = new ArrayList<>();

        int max = 1;
        int Actual = 1;

        for (int i = 1; i < numero.size(); i++) {
            if (numero.get(i) == numero.get(i - 1)) {
                Actual++;

                if (Actual > max) {
                    max = Actual;
                    moda.clear();
                    moda.add(numero.get(i));
                } else if (Actual == max) {
                    moda.add(numero.get(i));
                }
            } else {
                Actual = 1;
            }
        }

        return moda;
    }


    public static double desviacion(ArrayList<Float> numero){
        float media = promedio(numero);
        float suma_cuadrado = 0;
        for (float numeros : numero) {
            suma_cuadrado += Math.pow(numeros - media, 2);
        }

        double desvia = Math.sqrt(suma_cuadrado / (numero.size() - 1));
        return desvia;
    }




    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre de la sede: ").append(nombre).append("\n");
        for (estudiante estudiante : listestudiante) {
            sb.append(estudiante).append("\n");
        }
        return sb.toString();
    }

}