/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.grafo;

import controlador.Listas.ListaEnlazada;

/**
 *
 * @author Victor
 */
public abstract class Grafo {
    public abstract Integer numVertcies();
    
    public abstract Integer numAristas();
    
    public abstract Boolean existeArista(Integer o, Integer d) throws Exception;
    
    public abstract Double pesoArista(Integer o, Integer d);
    
    public abstract void insertarArista(Integer o, Integer d) throws Exception;
    
    public abstract void insertarArista(Integer o, Integer d, Double peso) throws Exception;
    
    public abstract ListaEnlazada<Adycencia> adyacentes(Integer v);

    @Override
    public String toString() {
        StringBuffer grafo = new StringBuffer("");
        try {
            for(int i = 1; i <= numVertcies(); i++){
            grafo.append("Vertice " + String.valueOf(i));
            ListaEnlazada<Adycencia> lista = adyacentes(i);
            for(int j = 0; j < lista.getSize(); j++){
                Adycencia a = lista.obtener(j);
                if(a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))){
                    grafo.append("-- Vertice destino "+a.getDestino()+" -- SP");
                } else {
                    grafo.append("-- Vertice destino "+a.getDestino()+" -- Peso"+a.getPeso());
                }
            }
            grafo.append("\n");
        }
        } catch (Exception e) {
            grafo.append(e.getMessage());
        }
        return grafo.toString();
    }
}
