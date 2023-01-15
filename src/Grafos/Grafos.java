/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

import Controlador.grafo.GrafoDirigidoEtiquetado;
import Controlador.grafo.GrafoNoDirigidoEtiquetado;
import Vista.frmPrincipal;

/**
 *
 * @author Victor
 */
public class Grafos {
    public static void main(String[] args) {
        
/*        GrafoDirigido gd = new GrafoDirigido(4);
        System.out.println(gd);
        System.out.println("-----------------");
        System.out.println("Grafo dirigido");
        
        try {
            gd.insertarArista(4, 2);
            gd.insertarArista(4, 1);
            gd.insertarArista(4, 3);
            gd.insertarArista(2, 3);
            System.out.println(gd);
        } 
        catch (Exception e) {
            
        }

        GrafoNoDirigido gnd = new GrafoNoDirigido(4);
        System.out.println(gnd);
        System.out.println("-----------------");
        System.out.println("Grafo no dirigido");
        
        try {
            
            gnd.insertarArista(4, 2);
            gnd.insertarArista(4, 1);
            gnd.insertarArista(4, 3);
            new frmPrincipal(null, true, gnd).setVisible(true);
            gnd.insertarArista(2, 3);
            System.out.println(gnd);
        } 
        catch (Exception e) {

        }*/

//        GrafoDirigidoEtiquetado gde = new GrafoDirigidoEtiquetado(3, String.class);
        
//        gde.etiquetarVertice(1, "Intriago");
//        gde.etiquetarVertice(2, "Nivelo");
//        gde.etiquetarVertice(3, "Peter");
//        gde.etiquetarVertice(4, "GreenField");
//        gde.etiquetarVertice(5, "parker");

        GrafoNoDirigidoEtiquetado gnde = new GrafoNoDirigidoEtiquetado(4, String.class);
        System.out.println(gnde.toString());
        gnde.etiquetarVertice(1, "campoverde");
        gnde.etiquetarVertice(2, "intriago");
        gnde.etiquetarVertice(3, "piter");
        gnde.etiquetarVertice(4, "parquer");
        try {
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(1), gnde.obtenerEtiqueta(3), 10.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(2), gnde.obtenerEtiqueta(3), 100.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(3), gnde.obtenerEtiqueta(4), 15.0);
//            gnde.insertarAristaE(gnde.obtenerEtiqueta(2), gnde.obtenerEtiqueta(1), 20.0);
//            gnde.insertarAristaE(gnde.obtenerEtiqueta(2), gnde.obtenerEtiqueta(3), 25.0);
//            gnde.insertarAristaE(gnde.obtenerEtiqueta(2), gnde.obtenerEtiqueta(4), 35.0);
//            gnde.insertarAristaE(gnde.obtenerEtiqueta(3), gnde.obtenerEtiqueta(4), 20.0);

            new frmPrincipal(null, true, gnde).setVisible(true);
//            System.out.println(gnde.toString());
        } catch (Exception e) {
            System.out.println("Error en grafo etiquetado " + e);
        }
//        try {
//            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(1), gde.obtenerEtiqueta(2), 10.0);
//            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(1), gde.obtenerEtiqueta(3), 20.0);
//            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(2), gde.obtenerEtiqueta(1), 30.0);
//            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(2), gde.obtenerEtiqueta(3), 40.0);
//            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(1), 50.0);
//            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(2), 60.0);
//
//            
////            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(1), gde.obtenerEtiqueta(4), 100.0);
////            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(1), gde.obtenerEtiqueta(5), 0.0);
////            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(2), gde.obtenerEtiqueta(3), 20.0);
////            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(2), gde.obtenerEtiqueta(5), 50.0);
////            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(3), 60.0);
////            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(4), 0.0);
////            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(4), gde.obtenerEtiqueta(3), 70.0);
////            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(5), gde.obtenerEtiqueta(3), 80.0);
////            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(5), gde.obtenerEtiqueta(2), 90.0);
//            
//            
//
////
////            gde.insertarAristaEtiquetada("Intriago", "GreenField");
////            gde.insertarAristaEtiquetada("Nivelo", "Peter");
////            gde.insertarAristaEtiquetada("Peter", "Chimbo");
////            gde.insertarAristaEtiquetada("Nivelo", "Nivelo", 10.0);
////            gde.insertarAristaEtiquetada("Peter", "GreenField", 20.0);
////            gde.insertarAristaEtiquetada("GreenField", "Nivelo", 20.0);
////            gde.insertarAristaEtiquetada("Nivelo", "GreenField", 20.0);
////            gde.insertarAristaEtiquetada("GreenField", "Intriago", 20.0);
////            gde.insertarAristaEtiquetada("Intriago", "GreenField", 30.0);
//
//            
//            new frmPrincipal(null, true, gde).setVisible(true);
//            
//            System.out.println(gde.toString());
//        } 
//        catch (Exception e) {
//
//        }
    }
}
