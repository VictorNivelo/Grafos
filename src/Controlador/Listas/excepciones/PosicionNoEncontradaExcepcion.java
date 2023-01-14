package controlador.Listas.excepciones;

/**
 *
 * @author Victor
 */
public class PosicionNoEncontradaExcepcion extends Exception{
     public PosicionNoEncontradaExcepcion(String msg){
         super(msg);
     }
     
     public PosicionNoEncontradaExcepcion(){
         super("La posicion dada está fuera de los límites de la lista");
     }
}
