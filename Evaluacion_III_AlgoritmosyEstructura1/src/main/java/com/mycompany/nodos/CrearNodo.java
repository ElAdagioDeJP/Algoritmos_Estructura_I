
package com.mycompany.nodos;

public class CrearNodo {
    Object valor;
    CrearNodo siguiente;

    public CrearNodo(Object valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public Object obtValor() {
        return valor;
    }

    public void Entrelazarvalores(CrearNodo n) {
        siguiente = n;
    }

    public CrearNodo obtenerSiguiente() {
        return siguiente;
    }
    
}
