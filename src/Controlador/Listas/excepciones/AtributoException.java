package controlador.Listas.excepciones;

/**
 *
 * @author Victor
 */
public class AtributoException extends Exception{
    
    public AtributoException(String msg){
        super(msg);
    }
    
    public AtributoException(){
        super("No se puede encontrar el atributo");
    }
}
