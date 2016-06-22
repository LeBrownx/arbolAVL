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
public class AVL {
    private nodoArbolAVL raiz;
    //CREAMOS CONSTRUCTOR
    public AVL(){
        raiz=null;
    }
    public nodoArbolAVL obtenerRaiz(){
        return raiz;
    }
    //BUSCAR NODO EN EL ARBOL
    public nodoArbolAVL buscar(int d, nodoArbolAVL r){
       if(raiz==null){//VERIFICAMOS QUE NUESTRO ARBOL TENGA ALGUN CONTENIDO
           return null;//SI NO ES ASI RETORNAMOS UN VALOR NULO
       }else if(r.dato==d){
           return r; //CUANDO ENCONTREMOS EL VALOR RETORNAMOS EL NODO
       }else if(r.dato<d){
           //SI NUESTRO VALOR DEL NODO ES MENOR QUE NUESTRO DATO RETORNAMOS NUESTRO NODO DERECHO
           return buscar(d,r.hijoDerecho);
       }
       else{
           //SI NO RETORNAMOS NUESTRO NODO IZQUIERDO
           return buscar(d,r.hijoIzquierdo);
       }
       
    }
    //METODO PARA OBTENER EL FACTOR DE EQUILIBRIO
    public int obtenerFE(nodoArbolAVL x){
        if(x==null){
            return -1;
        }else{
        return x.fe;
        }
    }
    //ROTACION SIMPLE IZQUIERDA
    public nodoArbolAVL rotacionIzquierda(nodoArbolAVL c){
        nodoArbolAVL auxiliar=c.hijoIzquierdo;
        c.hijoIzquierdo=auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }
    //ROTACION SIMPLE DERECHA
    public nodoArbolAVL rotacionDerecha(nodoArbolAVL c){
        nodoArbolAVL auxiliar=c.hijoDerecho;
        c.hijoDerecho=auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }
    //ROTACION DOBLE A LA IZQUIERDA
    public nodoArbolAVL rotacionDobleIzquierda(nodoArbolAVL c){
        nodoArbolAVL temporal;
        c.hijoIzquierdo=rotacionDerecha(c.hijoIzquierdo);
        temporal=rotacionIzquierda(c);
        return temporal;
    }
    //ROTACION DOBLE A LA DERECHA
    public nodoArbolAVL rotacionDobleDerecha(nodoArbolAVL c){
        nodoArbolAVL temporal;
        c.hijoDerecho=rotacionIzquierda(c.hijoDerecho);
        temporal=rotacionDerecha(c);
        return temporal;
    }
    //METODO PARA INSERTAR AVL
    public nodoArbolAVL insertarAVL(nodoArbolAVL nuevo,nodoArbolAVL subAr){
        nodoArbolAVL nuevoPadre=subAr;
        if(nuevo.dato<subAr.dato){
            if(subAr.hijoIzquierdo==null){
                subAr.hijoIzquierdo=nuevo;
            }else{
                subAr.hijoIzquierdo=insertarAVL(nuevo,subAr.hijoIzquierdo);
                if((obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho)==2)){
                    if(nuevo.dato<subAr.hijoIzquierdo.dato){
                        nuevoPadre=rotacionIzquierda(subAr);
                    }else{
                        nuevoPadre=rotacionDobleIzquierda(subAr);
                } 
              }
            }
        }else if(nuevo.dato>subAr.dato){
            if(subAr.hijoDerecho==null){
                subAr.hijoDerecho=nuevo;
            }else{
                subAr.hijoDerecho=insertarAVL(nuevo,subAr.hijoDerecho);
                if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2)){
                    if(nuevo.dato>subAr.hijoDerecho.dato){
                        nuevoPadre=rotacionDerecha(subAr);
                    }else{
                        nuevoPadre=rotacionDobleDerecha(subAr);
                    }
                }
            }
        }else{
            System.out.println("Nodo Duplicado");
        }
        //ACTUALIZAR ALTURA
        if((subAr.hijoIzquierdo==null) && (subAr.hijoDerecho!=null)){
            subAr.fe=subAr.hijoDerecho.fe+1;
        }else if((subAr.hijoDerecho==null) && (subAr.hijoIzquierdo!=null)){
            subAr.fe=subAr.hijoIzquierdo.fe+1;
        }else{
            subAr.fe=Math.max(obtenerFE(subAr.hijoIzquierdo),obtenerFE(subAr.hijoDerecho))+1;
        }
        return nuevoPadre;
    }

    public void insertar(int d){
        nodoArbolAVL nuevo=new nodoArbolAVL(d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo,raiz);
        }
    }
    
    
    //RECORRIDOS
    public void inOrder(nodoArbolAVL r){
        if(r!=null){
            inOrder(r.hijoIzquierdo);
            System.out.print(r.dato+", ");
            inOrder(r.hijoDerecho);
        }
    }
    
    public void preOrder(nodoArbolAVL r){
        if(r!=null){
            System.out.print(r.dato+", ");
            preOrder(r.hijoIzquierdo);
            preOrder(r.hijoDerecho);
        }
    }
    
    public void postOrder(nodoArbolAVL r){
        if(r!=null){
            postOrder(r.hijoIzquierdo);
            postOrder(r.hijoDerecho);
            System.out.print(r.dato+", ");
        }
    }





}

