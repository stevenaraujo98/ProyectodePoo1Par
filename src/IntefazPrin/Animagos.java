package IntefazPrin;

/**
  * Clase Animagos que implementa la interfaz Volador 
  * @author Araujo Steven
  * @author Banchon Melanie
  * @author Guerrero Darly
  * @version 03/12/17
  */

public class Animagos implements Volador{
    
    //Declaracion de atributos
    
    /**
     * variable privada: Almancenara el tipo de animal
     */
    private String animal;
    
    /**
     * variable privada: Almancenara el tipo de animal
     */
    private String hechizo;

    //Declaracion de constructores 
     
    /**
     * Constructor Animagos
     * @param animal
     * @param hechizo
     */
    
    public Animagos(String animal, String hechizo) {
        this.animal = animal;
        this.hechizo = hechizo;
    }

    /**
     * Constructor Animagos sin parametros 
     */
    
    public Animagos() {
    }

    //Declaracion de metodos 
     
    /**
     * Metodo getAnimal: devuelve el tipo de animal del mago
     * @return animal 
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Metodo setAnimal: establece el tipo de animal del mago a la variable 
     * del contructor
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }
    
    /**
     * Metodo getHechizo: devuelve el tipo de hechizo del mago
     * @return hechizo 
     */
    public String getHechizo() {
        return hechizo;
    }

    /**
     * Metodo setHechizo: establece el tipo de hechizo del mago a la variable 
     * del contructor
     */
    public void setHechizo(String hechizo) {
        this.hechizo = hechizo;
    }

    /**
     * Metodo volar: metodo sobrescrito encargado de imprimir un mensaje
     */
    @Override
    public String volar() {
        return("para volar necesita una varita");
    }

    /**
     * Metodo despegar: metodo sobrescrito 
     */
    @Override
    public void despegar() {
        //
    }
    
    /**
     * Metodo toString: metodo sobrescrito que retorna un mensaje 
     * @return mensaje 
     */
    @Override
    public String toString(){
        return ("Un animago es una bruja o mago con la capacidad de transformarse en un animal");
    }
}
