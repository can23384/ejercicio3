/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Ejercicio #3
Eliazar Canastuj
carnet: 23384
*/

import java.util.*;


public class main{

    public static void main (String[] args){
        Scanner teclado = new Scanner(System.in);

        //crear unas listas vacias para poder anadirlas a las sedes
        ArrayList<estudiante> estudiantes1 = new ArrayList<estudiante>();
        ArrayList<estudiante> estudiantes2 = new ArrayList<estudiante>();
        ArrayList<estudiante> estudiantes3 = new ArrayList<estudiante>();

        //se crean las 3 sedes
        sede sede1 = new sede("central", estudiantes1);
        sede sede2 = new sede("sur", estudiantes2);
        sede sede3 = new sede("norte", estudiantes3);

        boolean hola = true;
        boolean si = true;
        boolean nose = true;

        System.out.println("========================");
        System.out.println("     Bienvenido");

        //menu principal para elejir una sede
        while(hola){
            System.out.println("========================");
            System.out.println("Elija una sede: ");
            System.out.println("1. central");
            System.out.println("2. sur");
            System.out.println("3. norte");
            System.out.println("4. salir");
            int opcion = teclado.nextInt();
            teclado.nextLine();
            System.out.println("========================");

            switch(opcion){
                //opcio 1 sede CENTRAL
                case 1:
                     System.out.println("CENTRAL");
                     si = true;
                    while(si){
                        //sub menu para ver las opciones de esta sede
                        System.out.println("========================");
                        System.out.println("Elija una opcion: ");
                        System.out.println("1. agregar estudiante");
                        System.out.println("2. ver lista de estudiante");
                        System.out.println("3. mostrar datos analíticos");
                        System.out.println("4. volver a las sedes");
                        int option = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("========================");

                        switch(option){
                            case 1:
                                System.out.println("Ingrese el nombre: ");
                                String name = teclado.nextLine();

                                System.out.println("Ingrese el apellido: "); 
                                String apellido = teclado.nextLine();

                                System.out.println("Ingrese el codigo unico: ");
                                int code = teclado.nextInt();
                                teclado.nextLine();

                                System.out.println("Ingrese la fecha de nacimiento: ");
                                String fecha = teclado.nextLine();

                                System.out.println("Ingrese el correo: ");
                                String correo = teclado.nextLine();

                                ArrayList<examen> examenes = new ArrayList<examen>();

                                //examenes
                                nose = true;
                                while(nose){
                                    System.out.println("Ingrese el nombre del examen: ");
                                    String name_examen = teclado.nextLine();

                                    System.out.println("Ingrese la nota: ");
                                    float nota = teclado.nextFloat();
                                    teclado.nextLine();

                                    examen examen = new examen(name_examen, nota);

                                    examenes.add(examen);

                                    System.out.println("Desea agregar otro examen: ");
                                    System.out.println("1. si");
                                    System.out.println("2. no");
                                    int a = teclado.nextInt();
                                    teclado.nextLine();

                                    if (a == 2){
                                        nose = false;
                                    }
                                }

                                sede1.getListaEstudiantes().add(new estudiante(name, apellido, code, fecha, correo, examenes));

                                break;

                            case 2:
                                System.out.println(sede1);
                                break;

                            case 3:
                                //crear listas para guardar cada tipo de examen
                                ArrayList<Float> notasMate = new ArrayList<>();
                                ArrayList<Float> notasLengua = new ArrayList<>();
                                ArrayList<Float> notasQuimica = new ArrayList<>();
                                ArrayList<Float> notasFisica = new ArrayList<>();
                                ArrayList<Float> notasLectura = new ArrayList<>();
                                ArrayList<Float> notasEstadistica = new ArrayList<>();

                                ArrayList<estudiante> lista_Estudiantes = sede1.getListaEstudiantes();

                                for(estudiante estudiante : lista_Estudiantes) {
                                    ArrayList<examen> lista_Examenes = estudiante.getListaExamen();

                                    for (examen examen : lista_Examenes) {
                                        if(examen.getNameE().equals("Matemática")){  
                                            notasMate.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Lenguaje")){
                                            notasLengua.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Química")){
                                            notasQuimica.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Física")){
                                            notasFisica.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Comprensión Lectora")){
                                            notasLectura.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Estadística")){
                                            notasEstadistica.add(examen.getNota());
                                        }
                                    }
                                }

                                System.out.println("-----------------");
                                System.out.println("PROMEDIO");
                                System.out.println("Matemática: "+sede1.promedio(notasMate));
                                System.out.println("Lenguaje: "+sede1.promedio(notasLengua));
                                System.out.println("Química: "+sede1.promedio(notasQuimica));
                                System.out.println("Física: "+sede1.promedio(notasFisica));
                                System.out.println("Lenguaje: "+sede1.promedio(notasLectura));
                                System.out.println("Estadística: "+sede1.promedio(notasEstadistica));
                                System.out.println("-----------------");
                                System.out.println("mediana");
                                try{
                                    System.out.println("Matemática: "+sede1.mediana(notasMate));
                                    System.out.println("Lenguaje: "+sede1.mediana(notasLengua));
                                    System.out.println("Química: "+sede1.promedio(notasQuimica));
                                    System.out.println("Física: "+sede1.promedio(notasFisica));
                                    System.out.println("Comprensión Lectora: "+sede1.promedio(notasLectura));
                                    System.out.println("Estadística: "+sede1.promedio(notasEstadistica));
                                }catch(Exception e) {
                                    System.out.println("HUBO UN ERROR:" + e);
                                }
                                System.out.println("-----------------");
                                System.out.println("MODA");
                                System.out.println("Matemática: "+sede1.moda(notasMate));
                                System.out.println("Lenguaje: "+sede1.moda(notasLengua));
                                System.out.println("Química: "+sede1.promedio(notasQuimica));
                                System.out.println("Física: "+sede1.promedio(notasFisica));
                                System.out.println("Comprensión Lectora: "+sede1.promedio(notasLectura));
                                System.out.println("Estadística: "+sede1.promedio(notasEstadistica));
                                System.out.println("-----------------");
                                System.out.println("Desviación estánda");
                                System.out.println("Matemática: "+sede1.desviacion(notasMate));
                                System.out.println("Lenguaje: "+sede1.desviacion(notasLengua));
                                System.out.println("Química: "+sede1.promedio(notasQuimica));
                                System.out.println("Física: "+sede1.promedio(notasFisica));
                                System.out.println("Comprensión Lectora: "+sede1.promedio(notasLectura));
                                System.out.println("Estadística: "+sede1.promedio(notasEstadistica));
                                System.out.println("-----------------");

                                break;

                            case 4:
                                si = false;
                                break;

                            
                         }
                    }
                    break;

                case 2:
                     System.out.println("SUR");
                     si = true;
                    while(si){
                        //sub menu para ver las opciones de esta sede
                        System.out.println("========================");
                        System.out.println("Elija una opcion: ");
                        System.out.println("1. agregar estudiante");
                        System.out.println("2. ver lista de estudiante");
                        System.out.println("3. mostrar datos analíticos");
                        System.out.println("4. volver a las sedes");
                        int option = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("========================");

                        switch(option){
                            case 1:
                                System.out.println("Ingrese el nombre: ");
                                String name = teclado.nextLine();

                                System.out.println("Ingrese el apellido: "); 
                                String apellido = teclado.nextLine();

                                System.out.println("Ingrese el codigo unico: ");
                                int code = teclado.nextInt();
                                teclado.nextLine();

                                System.out.println("Ingrese la fecha de nacimiento: ");
                                String fecha = teclado.nextLine();

                                System.out.println("Ingrese el correo: ");
                                String correo = teclado.nextLine();

                                ArrayList<examen> examenes = new ArrayList<examen>();

                                //examenes
                                nose = true;
                                while(nose){
                                    System.out.println("Ingrese el nombre del examen: ");
                                    String name_examen = teclado.nextLine();

                                    System.out.println("Ingrese la nota: ");
                                    float nota = teclado.nextFloat();
                                    teclado.nextLine();

                                    examen examen = new examen(name_examen, nota);

                                    examenes.add(examen);

                                    System.out.println("Desea agregar otro examen: ");
                                    System.out.println("1. si");
                                    System.out.println("2. no");
                                    int a = teclado.nextInt();
                                    teclado.nextLine();

                                    if (a == 2){
                                        nose = false;
                                    }
                                }

                                sede2.getListaEstudiantes().add(new estudiante(name, apellido, code, fecha, correo, examenes));

                                break;

                            case 2:
                                System.out.println(sede2);
                                break;

                            case 3:
                                //crear listas para guardar cada tipo de examen
                                ArrayList<Float> notasMate = new ArrayList<>();
                                ArrayList<Float> notasLengua = new ArrayList<>();
                                ArrayList<Float> notasQuimica = new ArrayList<>();
                                ArrayList<Float> notasFisica = new ArrayList<>();
                                ArrayList<Float> notasLectura = new ArrayList<>();
                                ArrayList<Float> notasEstadistica = new ArrayList<>();

                                ArrayList<estudiante> lista_Estudiantes = sede2.getListaEstudiantes();

                                for(estudiante estudiante : lista_Estudiantes) {
                                    ArrayList<examen> lista_Examenes = estudiante.getListaExamen();

                                    for (examen examen : lista_Examenes) {
                                        if(examen.getNameE().equals("Matemática")){  
                                            notasMate.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Lenguaje")){
                                            notasLengua.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Química")){
                                            notasQuimica.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Física")){
                                            notasFisica.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Comprensión Lectora")){
                                            notasLectura.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Estadística")){
                                            notasEstadistica.add(examen.getNota());
                                        }
                                    }
                                }

                                System.out.println("-----------------");
                                System.out.println("PROMEDIO");
                                System.out.println("Matemática: "+sede2.promedio(notasMate));
                                System.out.println("Lenguaje: "+sede2.promedio(notasLengua));
                                System.out.println("Química: "+sede2.promedio(notasQuimica));
                                System.out.println("Física: "+sede2.promedio(notasFisica));
                                System.out.println("Lenguaje: "+sede2.promedio(notasLectura));
                                System.out.println("Estadística: "+sede2.promedio(notasEstadistica));
                                System.out.println("-----------------");
                                System.out.println("mediana");
                                try{
                                    System.out.println("Matemática: "+sede2.mediana(notasMate));
                                    System.out.println("Lenguaje: "+sede2.mediana(notasLengua));
                                    System.out.println("Química: "+sede2.promedio(notasQuimica));
                                    System.out.println("Física: "+sede2.promedio(notasFisica));
                                    System.out.println("Comprensión Lectora: "+sede2.promedio(notasLectura));
                                    System.out.println("Estadística: "+sede2.promedio(notasEstadistica));
                                }catch(Exception e) {
                                    System.out.println("HUBO UN ERROR:" + e);
                                }
                                System.out.println("-----------------");
                                System.out.println("MODA");
                                System.out.println("Matemática: "+sede2.moda(notasMate));
                                System.out.println("Lenguaje: "+sede2.moda(notasLengua));
                                System.out.println("Química: "+sede2.promedio(notasQuimica));
                                System.out.println("Física: "+sede2.promedio(notasFisica));
                                System.out.println("Comprensión Lectora: "+sede2.promedio(notasLectura));
                                System.out.println("Estadística: "+sede2.promedio(notasEstadistica));
                                System.out.println("-----------------");
                                System.out.println("Desviación estánda");
                                System.out.println("Matemática: "+sede2.desviacion(notasMate));
                                System.out.println("Lenguaje: "+sede2.desviacion(notasLengua));
                                System.out.println("Química: "+sede2.promedio(notasQuimica));
                                System.out.println("Física: "+sede2.promedio(notasFisica));
                                System.out.println("Comprensión Lectora: "+sede2.promedio(notasLectura));
                                System.out.println("Estadística: "+sede2.promedio(notasEstadistica));
                                System.out.println("-----------------");

                                break;

                            case 4:
                                si = false;
                                break;

                            
                         }
                    }
                    break;

                case 3:
                     System.out.println("NORTe");
                     si = true;
                    while(si){
                        //sub menu para ver las opciones de esta sede
                        System.out.println("========================");
                        System.out.println("Elija una opcion: ");
                        System.out.println("1. agregar estudiante");
                        System.out.println("2. ver lista de estudiante");
                        System.out.println("3. mostrar datos analíticos");
                        System.out.println("4. volver a las sedes");
                        int option = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("========================");

                        switch(option){
                            case 1:
                                System.out.println("Ingrese el nombre: ");
                                String name = teclado.nextLine();

                                System.out.println("Ingrese el apellido: "); 
                                String apellido = teclado.nextLine();

                                System.out.println("Ingrese el codigo unico: ");
                                int code = teclado.nextInt();
                                teclado.nextLine();

                                System.out.println("Ingrese la fecha de nacimiento: ");
                                String fecha = teclado.nextLine();

                                System.out.println("Ingrese el correo: ");
                                String correo = teclado.nextLine();

                                ArrayList<examen> examenes = new ArrayList<examen>();

                                //examenes
                                nose = true;
                                while(nose){
                                    System.out.println("Ingrese el nombre del examen: ");
                                    String name_examen = teclado.nextLine();

                                    System.out.println("Ingrese la nota: ");
                                    float nota = teclado.nextFloat();
                                    teclado.nextLine();

                                    examen examen = new examen(name_examen, nota);

                                    examenes.add(examen);

                                    System.out.println("Desea agregar otro examen: ");
                                    System.out.println("1. si");
                                    System.out.println("2. no");
                                    int a = teclado.nextInt();
                                    teclado.nextLine();

                                    if (a == 2){
                                        nose = false;
                                    }
                                }

                                sede3.getListaEstudiantes().add(new estudiante(name, apellido, code, fecha, correo, examenes));

                                break;

                            case 2:
                                System.out.println(sede3);
                                break;

                            case 3:
                                //crear listas para guardar cada tipo de examen
                                ArrayList<Float> notasMate = new ArrayList<>();
                                ArrayList<Float> notasLengua = new ArrayList<>();
                                ArrayList<Float> notasQuimica = new ArrayList<>();
                                ArrayList<Float> notasFisica = new ArrayList<>();
                                ArrayList<Float> notasLectura = new ArrayList<>();
                                ArrayList<Float> notasEstadistica = new ArrayList<>();

                                ArrayList<estudiante> lista_Estudiantes = sede3.getListaEstudiantes();

                                for(estudiante estudiante : lista_Estudiantes) {
                                    ArrayList<examen> lista_Examenes = estudiante.getListaExamen();

                                    for (examen examen : lista_Examenes) {
                                        if(examen.getNameE().equals("Matemática")){  
                                            notasMate.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Lenguaje")){
                                            notasLengua.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Química")){
                                            notasQuimica.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Física")){
                                            notasFisica.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Comprensión Lectora")){
                                            notasLectura.add(examen.getNota());
                                        }

                                        else if(examen.getNameE().equals("Estadística")){
                                            notasEstadistica.add(examen.getNota());
                                        }
                                    }
                                }

                                System.out.println("-----------------");
                                System.out.println("PROMEDIO");
                                System.out.println("Matemática: "+sede3.promedio(notasMate));
                                System.out.println("Lenguaje: "+sede3.promedio(notasLengua));
                                System.out.println("Química: "+sede3.promedio(notasQuimica));
                                System.out.println("Física: "+sede3.promedio(notasFisica));
                                System.out.println("Lenguaje: "+sede3.promedio(notasLectura));
                                System.out.println("Estadística: "+sede3.promedio(notasEstadistica));
                                System.out.println("-----------------");
                                System.out.println("mediana");
                                try{
                                    System.out.println("Matemática: "+sede3.mediana(notasMate));
                                    System.out.println("Lenguaje: "+sede3.mediana(notasLengua));
                                    System.out.println("Química: "+sede3.promedio(notasQuimica));
                                    System.out.println("Física: "+sede3.promedio(notasFisica));
                                    System.out.println("Comprensión Lectora: "+sede3.promedio(notasLectura));
                                    System.out.println("Estadística: "+sede3.promedio(notasEstadistica));
                                }catch(Exception e) {
                                    System.out.println("HUBO UN ERROR:" + e);
                                }

                                System.out.println("-----------------");
                                System.out.println("MODA");
                                System.out.println("Matemática: "+sede3.moda(notasMate));
                                System.out.println("Lenguaje: "+sede3.moda(notasLengua));
                                System.out.println("Química: "+sede3.promedio(notasQuimica));
                                System.out.println("Física: "+sede3.promedio(notasFisica));
                                System.out.println("Comprensión Lectora: "+sede3.promedio(notasLectura));
                                System.out.println("Estadística: "+sede3.promedio(notasEstadistica));
                                System.out.println("-----------------");
                                System.out.println("Desviación estánda");
                                System.out.println("Matemática: "+sede3.desviacion(notasMate));
                                System.out.println("Lenguaje: "+sede3.desviacion(notasLengua));
                                System.out.println("Química: "+sede3.promedio(notasQuimica));
                                System.out.println("Física: "+sede3.promedio(notasFisica));
                                System.out.println("Comprensión Lectora: "+sede3.promedio(notasLectura));
                                System.out.println("Estadística: "+sede3.promedio(notasEstadistica));
                                System.out.println("-----------------");

                                break;

                            case 4:
                                si = false;
                                break;

                            
                         }
                    }
                    break;



                case 4:
                    hola = false;
                    break;
            }
        }
        


    }
}