/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.grafo.exception;

/**
 *
 * @author Victor
 */
public class VerticeOfSizeException extends Exception{
   public VerticeOfSizeException(String msg){
        super(msg);
    }
    
    public VerticeOfSizeException(){
        super("No se pude sobrepasar el numero vertices");
    } 
}
