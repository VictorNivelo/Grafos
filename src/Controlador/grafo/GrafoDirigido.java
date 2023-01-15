/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.grafo;

import Controlador.grafo.exception.VerticeOfSizeException;
import controlador.Listas.ListaEnlazada;
import java.awt.List;

/**
 *
 * @author Victor
 */
public class GrafoDirigido extends Grafo{
    
    private Integer origen;
    protected Integer numVertices;
    protected Integer numAristas;
    
//    List<Adycencia> listaAdycente = new List()instanceof ;
    protected ListaEnlazada<Adycencia>[] listaAdycente;
//    protected ListaEnlazada<Adycencia>[] listaAdycente;

    public GrafoDirigido(Integer numVertices) {
        
        this.numVertices = numVertices;
        numAristas = 0;
        listaAdycente = new ListaEnlazada[numVertices + 1];
        
        for (int i = 0; i <= this.numVertices; i++) {
            listaAdycente[i] = new ListaEnlazada<>();
        }
    }

    @Override
    public Integer numAristas() {
        return numAristas;
    }

    @Override
    public Integer numVertcies() {
        return numVertices;
    }

    @Override
    public Boolean existeArista(Integer o, Integer d) throws Exception {
        Boolean existe = false;
        
        if (o <= numVertices && d <= numVertices) {
            ListaEnlazada<Adycencia> lista = listaAdycente[o];
            
            for (int i = 0; i < lista.getSize(); i++) {
                Adycencia a = lista.obtener(i);
                
                if (a.getDestino().intValue() == d.intValue()) {
                    existe = true;
                    break;
                }
            }
        } 
        else {
            //TODO Excepcion VerticeOfSize
            throw new VerticeOfSizeException();
        }
        return existe;
    }

    @Override
    public Double pesoArista(Integer o, Integer d) {
        //Nan es: no es un valor numerico, Not a Number
        Double peso = Double.NaN;
        try {
            
            if (existeArista(o, d)) {
//                List<Adycencia>  adyacentes = List[0];
                ListaEnlazada<Adycencia> adyacentes = listaAdycente[o];
                
                for (int i = 0; i < adyacentes.getSize(); i++) {
                    Adycencia a = adyacentes.obtener(i);
                    
                    if (a.getDestino().intValue() == d.intValue()) {
                        peso = a.getPeso();
                        break;
                    }
                }
            }
        } 
        catch (Exception e) {
            
        }
        return peso;
    }

    @Override
    public void insertarArista(Integer o, Integer d) throws Exception {
        insertarArista(o, d, Double.NaN);
    }

    @Override
    public void insertarArista(Integer o, Integer d, Double peso) throws Exception {
        
        try {
            if (d.intValue() <= numVertices && o >= 0 && d <= numVertices) {

                if (!existeArista(o, d)) {
                    numAristas++;
                    listaAdycente[o].insertar(new Adycencia(d, peso));
                    if (origen == null) {
                        origen = o;
                    } 
                    else if (origen == o) {
                        numAristas++;
                        listaAdycente[o].insertar(new Adycencia(d, peso));
                        origen = o;
                    } 
                    else {
                        numAristas++;
                        listaAdycente[origen].insertar(new Adycencia(d, peso));
                    }
                }
            } 
            else {
                throw new VerticeOfSizeException();
            }
        } 
        catch (Exception e) {
            System.out.println("Error en insertarArista: " + e);
        }

//        if (o <= numVertices && d <= numVertices) {
//            if (!existeArista(o, d)) {
//                numAristas++;
//                listaAdycente[o].insertar(new Adycencia(d, peso));
//            }
//        } 
//        else {
//            throw new VerticeOfSizeException();
//        }
    }

    @Override
    public ListaEnlazada<Adycencia> adyacentes(Integer v) {
        return listaAdycente[v];
    }

}
