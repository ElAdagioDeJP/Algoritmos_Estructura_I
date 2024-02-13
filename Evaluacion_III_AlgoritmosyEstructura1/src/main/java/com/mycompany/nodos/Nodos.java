package com.mycompany.nodos;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
import javax.swing.event.*;
import javax.swing.*;

public class Nodos extends JFrame implements ActionListener{
    
    JTextField agregarNodo,index,ltr;
    JButton operacion,eliminar,agregarB,limpiar;
    JTextArea ordenar,tamaño,mayus,eliminarltr,among;
    JLabel agregarN,indexx,letra,lordenar,ltamaño,lmayus,leliminarltr,nodosLabel;
    JScrollPane scroll;
    String nodo,n = " ",len;
    int indice;
    
    public Nodos(){
        
        //Creo la Interfaz Raiz
        setLayout(null);
        setSize(550,795);
        setResizable(false);
        setTitle("NODIFICADOR 777");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //Creo los inputs para cada cuestion
        agregarNodo = new JTextField("");
        agregarNodo.setBounds(20, 40, 330, 23);
        add(agregarNodo);
        
        ltr = new JTextField("");
        ltr.setBounds(20, 95, 140, 23);
        add(ltr);
        
        index = new JTextField("");
        index.setBounds(20, 145, 140, 23);
        add(index);
        
        //Creo los botones para la gestion de Activaciones
        agregarB = new JButton("Agregar");
        agregarB.addActionListener(this);
        agregarB.setBounds(410, 30, 100, 40);
        add(agregarB);
        
        operacion = new JButton("Operar");
        operacion.addActionListener(this);
        operacion.setBounds(180, 100, 100, 40);
        add(operacion);
        
        eliminar = new JButton("Eliminar");
        eliminar.addActionListener(this);
        eliminar.setBounds(295, 100, 100, 40);
        add(eliminar);
        
        limpiar = new JButton("Limpiar");
        limpiar.addActionListener(this);
        limpiar.setBounds(410, 100, 100, 40);
        add(limpiar);
        
        //Creo los Area para mostrar lo que pide
        ordenar = new JTextArea("");
        ordenar.setEditable(false);
        scroll = new JScrollPane(ordenar);
        scroll.setBounds(20, 220, 250, 25);
        add(scroll);
        
        tamaño = new JTextArea("");
        tamaño.setEditable(false);
        scroll = new JScrollPane(tamaño);
        scroll.setBounds(20, 280, 250, 25);
        add(scroll);
        
        mayus = new JTextArea("");
        mayus.setEditable(false);
        scroll = new JScrollPane(mayus);
        scroll.setBounds(20, 340, 250, 25);
        add(scroll);
        
        eliminarltr = new JTextArea("");
        eliminarltr.setEditable(false);
        scroll = new JScrollPane(ordenar);
        scroll.setBounds(20, 400, 250, 25);
        add(scroll);
        
        among = new JTextArea("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
"⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⠛⠛⢻⡻⠿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
"⣿⣿⣿⣿⣿⣿⣟⣫⡾⠛⠛⠛⠛⠛⠛⠿⣾⣽⡻⣿⣿⣿⣿⣿\n" +
"⣿⣿⣿⣿⣿⡟⣼⠏⠄⠄⠄⠄⠄⠄⣀⣀⡀⣙⣿⣎⢿⣿⣿⣿\n" +
"⣿⣿⣿⣿⣿⢹⡟⠄⠄⠄⣰⡾⠟⠛⠛⠛⠛⠛⠛⠿⣮⡻⣿⣿\n" +
"⣿⡿⢟⣻⣟⣽⠇⠄⠄⠄⣿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⢿⡹⣿\n" +
"⡟⣼⡟⠉⠉⣿⠄⠄⠄⠄⢿⡄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣼⢟⣿\n" +
"⣇⣿⠁⠄⠄⣿⠄⠄⠄⠄⠘⢿⣦⣄⣀⣀⣀⣀⣤⡴⣾⣏⣾⣿\n" +
"⡇⣿⠄⠄⠄⣿⠄⠄⠄⠄⠄⠄⠈⠉⠛⠋⠉⠉⠄⠄⢻⣿⣿⣿\n" +
"⢃⣿⠄⠄⠄⣿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸⣧⣿⣿\n" +
"⡻⣿⠄⠄⠄⣿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣸⣧⣿⣿\n" +
"⡇⣿⠄⠄⠄⣿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣿⢹⣿⣿\n" +
"⣿⡸⢷⣤⣤⣿⡀⠄⠄⠄⠄⢠⣤⣄⣀⣀⣀⠄⠄⢠⣿⣿⣿⣿\n" +
"⣿⣿⣷⣿⣷⣿⡇⠄⠄⠄⠄⢸⡏⡍⣿⡏⠄⠄⠄⢸⡏⣿⣿⣿\n" +
"⣿⣿⣿⣿⣿⢼⡇⠄⠄⠄⠄⣸⡇⣷⣻⣆⣀⣀⣀⣼⣻⣿⣿⣿\n" +
"⣿⣿⣿⣿⣿⣜⠿⢦⣤⣤⡾⢟⣰⣿⣷⣭⣯⣭⣯⣥⣿⣿⣿⣿\n" +
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
        among.setEnabled(false);
        among.setBackground(Color.black);
        among.setBounds(285, 165, 225, 275);
        add(among);
        
        //Creo los labels
        
        agregarN = new JLabel("Agregar nuevo nodo");
        agregarN.setBounds(20,10,200,30);
        add(agregarN);
        
        letra = new JLabel("Letra");
        letra.setBounds(23,70,100,30);
        add(letra);
        
        indexx = new JLabel("Index");
        indexx.setBounds(20,120,100,30);
        add(indexx);
        
        lordenar = new JLabel("Ordenar Alfabeticamente");
        lordenar.setBounds(20,190,150,30);
        add(lordenar);
        
        ltamaño = new JLabel("Tamaño de la cadena");
        ltamaño.setBounds(20,250,150,30);
        add(ltamaño);
        
        lmayus = new JLabel("Cambiar todo a mayuscula");
        lmayus.setBounds(20,310,200,30);
        add(lmayus);
        
        leliminarltr = new JLabel("Eliminar Letra");
        leliminarltr.setBounds(20,370,150,30);
        add(leliminarltr);
        
        nodosLabel = new JLabel("");
        nodosLabel.setBounds(10,500,300,20);
        add(nodosLabel);
    }    
    public class Nodificacion {

    Object valor;
    Nodificacion siguiente;

    public Nodificacion(Object valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public Object obtValor() {
        return valor;
    }

    public void Entrelazarvalores(Nodificacion n) {
        siguiente = n;
    }

    public Nodificacion obtenerSiguiente() {
        return siguiente;
    }
    
    }
    public class listaEnlazada {

        Nodificacion cabeza;
        int size;

        public listaEnlazada() {
            cabeza = null;
            size = 0;

        }

        public void agregarValor(Object obj) {
            if (cabeza == null) {
                cabeza = new Nodificacion(obj);

            } else {
                Nodificacion temp = cabeza;
                Nodificacion nuevo = new Nodificacion(obj);
                nuevo.Entrelazarvalores(temp);
                cabeza = nuevo;
            }
            size++;

        }

        public int size() {
            return size;
        }

        public boolean estaVacio() {
            return (cabeza == null) ? true : false;
        }
}
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == limpiar){
            agregarNodo.setText("");
            ltr.setText("");
            index.setText("");
            ordenar.setText("");
            tamaño.setText("");
            mayus.setText("");
            eliminarltr.setText("");
            
        }
        if (e.getSource() == agregarB){
            String nodo = agregarNodo.getText();
            agregarNodo.setText("");
            listaEnlazada lista = new listaEnlazada();
            lista.agregarValor(nodo);
            
            actualizarNodosLabel(lista);
        }
        if(e.getSource() == operacion){
            indice = Integer.parseInt(index.getText());
            listaEnlazada lista = new listaEnlazada();
            Object valorNodo = obtenerValorEnPosicion(lista, indice);
            len = valorNodo.toString();
            tamaño.setText(len);
        }
    }
    private Object obtenerValorEnPosicion(listaEnlazada lista, int indice) {
    Nodificacion nodoActual = lista.cabeza;
    int contador = 0;

    while (nodoActual != null) {
        if (contador == indice) {
            return nodoActual.obtValor();
        }
        nodoActual = nodoActual.obtenerSiguiente();
        contador++;
    }

    // Si el índice está fuera de rango, se devuelve null o se lanza una excepción según tu preferencia
    return null;
}

private int obtenerTamanoValorEnPosicion(listaEnlazada lista, int indice) {
    Nodificacion nodoActual = lista.cabeza;
    int contador = 0;

    while (nodoActual != null) {
        if (contador == indice) {
            Object valor = nodoActual.obtValor();
            if (valor instanceof String) {
                return ((String) valor).length();
            } else if (valor instanceof Integer) {
                return String.valueOf(valor).length();
            }
            // Ajusta el tipo de dato del valor según tus necesidades
        }
        nodoActual = nodoActual.obtenerSiguiente();
        contador++;
    }

    // Si el índice está fuera de rango, se devuelve -1 o se lanza una excepción según tu preferencia
    return -1;
}
    private void actualizarNodosLabel(listaEnlazada lista) {
        StringBuilder sb = new StringBuilder();
        Nodificacion nodoActual = lista.cabeza;
        while (nodoActual != null) {
            sb.append(nodoActual.obtValor()).append(", ");
            nodoActual = nodoActual.obtenerSiguiente();
        }
        String nodosTexto = sb.toString();

        if (nodosTexto.length() > 2) {
            nodosTexto = nodosTexto.substring(0, nodosTexto.length() - 2);
        }
        n = (n + " " + nodosTexto);
        nodosLabel.setText(n);
    }

    public static void main(String[] args) {
        Nodos nodito = new Nodos();
        nodito.setVisible(true);
    }
}
