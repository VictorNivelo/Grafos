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
public class GrafoNoDirigidoEtiquetado<E> extends GrafoNoDirigido{
    protected E etiquetas[];
    protected HashMap<E, Integer> dirVertices;
    private Class<E> clazz;
    
    public GrafoNoDirigidoEtiquetado(Integer numVert, Class clazz ){
        super(numVert);
        this.clazz = clazz;
        etiquetas = (E[]) Array.newInstance(clazz, numVert + 1);
        dirVertices = new HashMap(numVert);
    }
    
    public Boolean existeAristaEtiquetada(E o, E d) throws  Exception{
        return this.existeArista(obtenerCodigoEtiquetada(o), obtenerCodigoEtiquetada(d));
    }
    
    public void insertarAristaEtiquetada(E o, E d, Double peso) throws Exception {
        insertarArista(obtenerCodigoEtiquetada(o), obtenerCodigoEtiquetada(d), peso);
    }

    public void insertarAristaEtiquetada(E o, E d) throws Exception {
        insertarArista(obtenerCodigoEtiquetada(o), obtenerCodigoEtiquetada(d));
    }

    public ListaEnlazada<Adycencia> adyacentesEtiquetada(E o) { ///VERIFICAR 
        return adyacentesEtiquetada((E) obtenerCodigoEtiquetada(o));
    }
    
    public Integer obtenerCodigoEtiquetada(E etiqueta){
        return  dirVertices.get(etiqueta);
    }
    
    public E obtenerEtiqueta(Integer codigo) {
        return etiquetas[codigo];
    }

    public void etiquetarVertice(Integer codigo, E etiqueta) {
        etiquetas[codigo] = etiqueta;
        dirVertices.put(etiqueta, codigo);
    }
    
    @Override
    public String toString() {
        StringBuffer grafo = new StringBuffer("");

        try {
            for (int i = 1; i <= numVertcies(); i++) {
                grafo.append("Vertice " + String.valueOf(i)+"  ");
                
                ListaEnlazada<Adycencia> adyacenciaList = adyacentes(i);

                for (int j = 0; j < adyacenciaList.getSize(); j++) {
                    Adycencia a = adyacenciaList.obtener(j);
                    
                    if (a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                        grafo.append("-- Vertice destino "+a.getDestino()).append(" -- SP");
//                        grafo.append("-- Grafo etiqueta --- " ).append(etiquetas[j]);
                    } 
                    else {
                        grafo.append("-- Vertice destino "+a.getDestino()).append(" -- Peso ").append(a.getPeso());
                    }
                    grafo.append("\n");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return grafo.toString();
    }
}
