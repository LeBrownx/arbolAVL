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
public class ArbolAVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AVL arbol= new AVL();
       
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(13);
        arbol.insertar(17);
        arbol.insertar(16);
        
        arbol.preOrder(arbol.obtenerRaiz());
        
    }
    
}
