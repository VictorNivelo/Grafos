/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

import Controlador.grafo.GrafoDirigido;
import Controlador.grafo.GrafoDirigidoEtiquetado;
import Controlador.grafo.GrafoNoDirigido;
import Vista.frmPrincipal;

/**
 *
 * @author Victor
 */
public class Grafos {
    public static void main(String[] args) {
//        GrafoDirigido gd = new GrafoDirigido(4);
//        System.out.println(gd);
//        System.out.println("-----------------");
//        System.out.println("Grafo dirigido");
//        try {
//            gd.insertarArista(4, 2);
//            gd.insertarArista(4, 1);
//            gd.insertarArista(4, 3);
//            gd.insertarArista(2, 3);
//            System.out.println(gd);
//        } catch (Exception e) {
//        }
//
//        GrafoNoDirigido gnd = new GrafoNoDirigido(4);
//        System.out.println(gnd);
//        System.out.println("-----------------");
//        System.out.println("Grafo no dirigido");
//        try {
//            gnd.insertarArista(4, 2);
//            gnd.insertarArista(4, 1);
//            gnd.insertarArista(4, 3);
//            new frmPrincipal(null, true, gnd).setVisible(true);
//            gnd.insertarArista(2, 3);
//            System.out.println(gnd);
//        } catch (Exception e) {
//
//        }

        GrafoDirigidoEtiquetado gde = new GrafoDirigidoEtiquetado(5, String.class);
        
        gde.etiquetarVertice(1, "Intriago");
        gde.etiquetarVertice(2, "Nivelo");
        gde.etiquetarVertice(3, "Peter");
        gde.etiquetarVertice(4, "GreenField");
        gde.etiquetarVertice(5, "parker");

        try {
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(1), gde.obtenerEtiqueta(2), 10.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(1), gde.obtenerEtiqueta(4), 1000.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(2), gde.obtenerEtiqueta(5), 0.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(2), gde.obtenerEtiqueta(2), 10.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(5), 5000.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(3), 6000.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(4), gde.obtenerEtiqueta(5), 0.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(4), gde.obtenerEtiqueta(3), 8000.0);

//
//            gde.insertarAristaEtiquetada("Intriago", "GreenField");
//            gde.insertarAristaEtiquetada("Nivelo", "Peter");
//            gde.insertarAristaEtiquetada("Peter", "Chimbo");
//            gde.insertarAristaEtiquetada("Nivelo", "Nivelo", 10.0);
//            gde.insertarAristaEtiquetada("Peter", "GreenField", 20.0);
//            gde.insertarAristaEtiquetada("GreenField", "Nivelo", 20.0);
//            gde.insertarAristaEtiquetada("Nivelo", "GreenField", 20.0);
//            gde.insertarAristaEtiquetada("GreenField", "Intriago", 20.0);
//            gde.insertarAristaEtiquetada("Intriago", "GreenField", 30.0);
            
            
            
            new frmPrincipal(null, true, gde).setVisible(true);
            
            System.out.println(gde.toString());
        } 
        catch (Exception e) {

        }
    }
}
