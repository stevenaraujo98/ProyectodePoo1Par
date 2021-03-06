
package OpcPlanificador;

import IntefazPrin.*;
import java.util.ArrayList;
import java.util.Scanner;
import proyectodepoo1par.Estudiante;
import proyectodepoo1par.Principal;
import proyectodepoo1par.ReadWriter;


//Declaracion de la clase

/**
 * Clase EstudianteRegistro
 * @author Araujo Steven
 * @author Banchon Melanie
 * @author Guerrero Darly
 * @version 03/12/17
 */
public class EstudianteRegistro {
    
    //Declaracion de atributos
    
    /**
     * variable default estatica: Almancenara la entrada 
     */
    Scanner t = new Scanner(System.in);
    
    
    /**
     * variable default: Almancenara la informacion si el usuario desea continuar
     * con el registro
     */
    String op_crear = "";
    
    
    /**
     * objeto Estudiante: Inicializacion del objeto de tipo estudiante como vacio 
     * para su posterior implementacion
     */
    Estudiante estudiante =null;
    
    /**
     * objeto tipo: inicializacion del objeto de tipo object como vacio 
     * para su posterior implementacion
     */
    Object tipo = null;
    
    
//Declaracion de metodos
    
    /**
     * Metodo crearLista: Permite crear el curso con los datos proporcionados por el usuario
     * gracias a la entrada, ademas almacena la informacion en el arraylist llamado datos, 
     * el cual luego es guardo en el archivo "curso.txt"
     * @param nombre Indica el nombre del usuario
     * @param apellido Indica el apellido del usuario
     * @param edad Indica la edad del usuario
     * @param varita Indica el tipo de varita que usa el mago
     * @param casa Indica la casa a la que pertenece el mago
     * @param tipo Indica el tipo de mago
     */
    public void crearLista(String nombre,String apellido,String edad, String varita,String casa,String tipo){
        ReadWriter archivo = new ReadWriter();
        
        ArrayList<String> listaDatos = new ArrayList<>();
        listaDatos.add(nombre);
        listaDatos.add(apellido);
        listaDatos.add(edad);
        listaDatos.add(varita);
        listaDatos.add(casa);
        listaDatos.add(tipo);
        
        archivo.AgregarAlArchivo(listaDatos, "estudiantes.txt");
        listaDatos.clear(); //Limpiamos memoria
    }   
    
    
    /**
     * Metodo pedirDatos: Permite almacenar los datos proporcionados por el usuario
     * en el array datos, ademas instancia el objeto de tipo estudiante y envia los
     * datos al contructor 
     */
    public void pedirDatos(){
        System.out.println("CREAR ESTUDIANTE");
        System.out.print("Ingrese nombre: ");
        String nombre = t.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = t.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = 0;
        while(edad == 0){
            String n1 = t.nextLine();
            edad = Integer.parseInt(new Principal().validarNumero(n1));
            if(edad == 0){System.out.print("Intente de nuevo!\n\nIngrese edad: ");}
        }
        System.out.print("Varita: ");
        String varita = t.nextLine();
        System.out.print("Casa: ");
        String casa = t.nextLine();
        
        estudiante = new Estudiante(edad, casa, varita, nombre, apellido);
    }
    
    //Pricipal
    
    /**
     * Metodo crear: Define el tipo de mago con ayuda del objeto estudiante, lo crea
     * de acuerdo a la opcion seleccionada por el usuario y guada los datos dependiendo
     * del tipo de mago que sea 
     */
    public void crear(){   
        pedirDatos();
        //definimos el tipo de mago con el objeto de estudainte
        tipo = estudiante.TipoMago();
        
        //crear
        System.out.print("\n¿Desea guardar los datos? (S/N) ");
        op_crear = t.nextLine();
        System.out.println();
        
        //Guardar dependiendo del tipo de mago
        if(op_crear.equals("S")){
            if(tipo instanceof Animagos){
                crearLista(estudiante.getNombre(), estudiante.getApellido(),String.valueOf(estudiante.getEdad()), estudiante.getVarita(), estudiante.getCasa(),"A");
            }else if(tipo instanceof Metamorfomago){
                crearLista(estudiante.getNombre(), estudiante.getApellido(),String.valueOf(estudiante.getEdad()), estudiante.getVarita(), estudiante.getCasa(),"M");
            }else if(tipo instanceof Normal){
                crearLista(estudiante.getNombre(), estudiante.getApellido(),String.valueOf(estudiante.getEdad()), estudiante.getVarita(), estudiante.getCasa(),"N");
            }
        }
    }
    
    
    /**
     * Metodo toString: muestra el mensaje de acuerdo al valor del contador op
     * @return "Sus datos se han guardado correctamente" si el usuario ingreso "S"
     * o "No se han gurdado sus datos" ssi el usuario ingreso "N"
     */
    @Override
    public String toString() {
        if(op_crear.equals("S")){
            return("Sus datos se han guardado correctamente.\n");
        }else {
            return("No se han gurdado sus datos.\n");
        }
    }
    
    
}
