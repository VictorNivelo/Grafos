package controlador.Listas.excepciones;

/**
 *
 * @author Victor
 */
public class ListaNullException extends Exception{
    public ListaNullException(String msg){
        super(msg);
    }
    
    public ListaNullException(){
        super("La lista está vaćia");
    }
}
