/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.grafo;

/**
 *
 * @author Victor
 */
public class Adycencia {
//    private String Etiqueta;
//    private Integer origen;
    private Integer destino;
    private Double peso;
    //en la prueba va a ser object

    public Adycencia(Integer destino, Double peso) {

        this.destino = destino;
        this.peso = peso;
    }

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

//    public Integer getOrigen() {
//        return origen;
//    }
//
//    public void setOrigen(Integer origen) {
//        this.origen = origen;
//    }
//
//    public String getEtiqueta() {
//        return Etiqueta;
//    }
//
//    public void setEtiqueta(String Etiqueta) {
//        this.Etiqueta = Etiqueta;
//    }
    
    @Override
    public String toString() {
        return " destino=" + destino + " peso=" + peso;
    }

    
}
