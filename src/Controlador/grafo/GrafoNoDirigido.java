/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.grafo;

import Controlador.grafo.exception.VerticeOfSizeException;

/**
 *
 * @author Victor
 */
public class GrafoNoDirigido extends GrafoDirigido{
    public GrafoNoDirigido(Integer numV){
        super(numV);
    }

    @Override
    public void insertarArista(Integer o, Integer d, Double peso) throws Exception {
        try {
            if (o <= numVertices && d <= numVertices) {

                if (!existeArista(o, d)) {
//                    setNumAristas(getNumAristas());
                    numAristas++;
                    listaAdycente[o].insertar(new Adycencia(d, peso));
                    listaAdycente[d].insertar(new Adycencia(o, peso));
                }
            } 
            else {
                throw new VerticeOfSizeException();
            }
        } catch (Exception e) {

        }
    }
}
