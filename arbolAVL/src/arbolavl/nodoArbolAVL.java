/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl;

/**
 *
 * @author Kevin
 */
public class nodoArbolAVL {
    int dato,fe;//DECLARAMOS EL DATO Y EL FACTOR DE EQUILIBRIO
    nodoArbolAVL hijoIzquierdo,hijoDerecho;
    public nodoArbolAVL(int d){
        this.dato=d;
        this.fe=0;
        this.hijoIzquierdo=null;
        this.hijoDerecho=null;
    }
}
