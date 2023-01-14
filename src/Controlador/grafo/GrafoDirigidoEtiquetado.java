/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.grafo;

import controlador.Listas.ListaEnlazada;
import java.lang.reflect.Array;
import java.util.HashMap;

/**
 *
 * @author Victor
 */
public class GrafoDirigidoEtiquetado<E> extends GrafoDirigido {
    
    protected E etiquetas[];
    protected HashMap<E, Integer> dicVertices;
    private Class<E> clazz;
    
    public GrafoDirigidoEtiquetado(Integer numVert, Class clazz){
        super(numVert);
        this.clazz = clazz;
        etiquetas = (E[]) Array.newInstance(clazz, numVert + 1);
        dicVertices = new HashMap(numVert);
    }
    
    public Boolean existeAristaEtiquetada(E origen, E destino) throws Exception{
        return this.existeArista(obtenerCodigoEtiquetado(origen), obtenerCodigoEtiquetado(destino));
    }
    
    public void insertarAristaEtiquetada(E origen, E destino, Double peso) throws Exception{
        insertarArista(obtenerCodigoEtiquetado(origen), obtenerCodigoEtiquetado(destino), peso);
    }
    
    public void insertarAristaEtiquetada(E origen, E destino) throws Exception{
        insertarArista(obtenerCodigoEtiquetado(origen), obtenerCodigoEtiquetado(destino));
    }
    
    private Integer obtenerCodigoEtiquetado(E etiqueta){
        return dicVertices.get(etiqueta);
    }
    
    public ListaEnlazada<Adycencia> adyacentesEtiquetada(E o){
        return adyacentes(obtenerCodigoEtiquetado(o));
    } 

    public E obtenerEtiqueta(Integer codigo){
        return etiquetas[codigo];
    }
    
    public void etiquetarVertice(Integer codigo, E etiqueta){
        etiquetas[codigo] = etiqueta;
        dicVertices.put(etiqueta, codigo);
    }
    
    @Override
    public String toString() {
        StringBuffer grafo = new StringBuffer("");
        try {
            for (int i = 1; i <= numVertcies(); i++) {
                grafo.append("Vertice " + String.valueOf(i) + " [" + obtenerEtiqueta(i) + "]");
                ListaEnlazada<Adycencia> lista = adyacentes(i);
                
                for (int j = 0; j < lista.getSize(); j++) {
                    Adycencia a = lista.obtener(j);
                    
                    if (a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                        grafo.append(" -- Vertice destino " + a.getDestino() + " -- SP ");
                    } 
                    else {
                        grafo.append(" -- Vertice destino " + obtenerEtiqueta(a.getDestino()) + " -- Peso " + a.getPeso());
                    }
                }
                grafo.append("\n");
            }
        } 
        catch (Exception e) {
            grafo.append(e.getMessage());
        }
//        return null;
        return grafo.toString();
    }
}
