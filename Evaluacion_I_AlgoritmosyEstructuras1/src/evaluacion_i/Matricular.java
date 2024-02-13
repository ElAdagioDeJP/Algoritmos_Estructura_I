package evaluacion_i;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
import java.math.BigInteger;

public class Matricular extends JFrame implements ActionListener {

    private JButton ejecutar, borrar;
    private JTextField barra1;
    private JTextArea areatext, shrek, amonguss, mult, prom, factorial, fibonacci;
    private JScrollPane scroll;
    private JLabel label1, label2, label3, label4, label5;
    int n, max, promsuc, sumapos, cont, propos, a, b, c;
    long dprincipal = 1;
    String t;

    public Matricular() {
        setLayout(null);
        setSize(800, 680);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MATRICULUM MAXTERNEARIO GRAFIKEITOR B)");
        setLocationRelativeTo(null);

        label1 = new JLabel("Ingrese un numero del [3,10], para determinar el tamaño de la matriz");
        label1.setBounds(20, 13, 400, 43);
        add(label1);

        label2 = new JLabel("Multiplicacion de la Diagonal principal");
        label2.setBounds(20, 325, 300, 30);
        add(label2);

        label3 = new JLabel("Promedio de la ultima columna");
        label3.setBounds(20, 400, 300, 30);
        add(label3);

        label4 = new JLabel("Factorial del numero mas grande");
        label4.setBounds(20, 475, 300, 30);
        add(label4);

        label5 = new JLabel("Serie Fibonacci hasta el promedio de la suma de todos los positivos");
        label5.setBounds(20, 550, 400, 30);
        add(label5);

        mult = new JTextArea("");
        mult.setEditable(false);
        scroll = new JScrollPane(mult);
        scroll.setBounds(20, 350, 420, 40);
        add(scroll);

        prom = new JTextArea("");
        prom.setEditable(false);
        scroll = new JScrollPane(prom);
        scroll.setBounds(20, 425, 420, 40);
        add(scroll);

        factorial = new JTextArea("");
        factorial.setEditable(false);
        scroll = new JScrollPane(factorial);
        scroll.setBounds(20, 500, 420, 40);
        add(scroll);

        fibonacci = new JTextArea("");
        fibonacci.setEditable(false);
        scroll = new JScrollPane(fibonacci);
        scroll.setBounds(20, 575, 420, 40);
        add(scroll);

        areatext = new JTextArea("");
        areatext.setEditable(false);
        scroll = new JScrollPane(areatext);
        scroll.setBounds(20, 110, 420, 210);
        add(scroll);

        shrek = new JTextArea("⢀⡴⠑⡄⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n"
                + "⠸⡇⠀⠿⡀⠀⠀⠀⣀⡴⢿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n"
                + "⠀⠀⠀⠀⠑⢄⣠⠾⠁⣀⣄⡈⠙⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀ \n"
                + "⠀⠀⠀⠀⢀⡀⠁⠀⠀⠈⠙⠛⠂⠈⣿⣿⣿⣿⣿⠿⡿⢿⣆⠀⠀⠀⠀⠀⠀⠀ \n"
                + "⠀⠀⠀⢀⡾⣁⣀⠀⠴⠂⠙⣗⡀⠀⢻⣿⣿⠭⢤⣴⣦⣤⣹⠀⠀⠀⢀⢴⣶⣆ \n"
                + "⠀⠀⢀⣾⣿⣿⣿⣷⣮⣽⣾⣿⣥⣴⣿⣿⡿⢂⠔⢚⡿⢿⣿⣦⣴⣾⠁⠸⣼⡿ \n"
                + "⠀⢀⡞⠁⠙⠻⠿⠟⠉⠀⠛⢹⣿⣿⣿⣿⣿⣌⢤⣼⣿⣾⣿⡟⠉⠀⠀⠀⠀⠀ \n"
                + "⠀⣾⣷⣶⠇⠀⠀⣤⣄⣀⡀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ \n"
                + "⠀⠉⠈⠉⠀⠀⢦⡈⢻⣿⣿⣿⣶⣶⣶⣶⣤⣽⡹⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ \n"
                + "⠀⠀⠀⠀⠀⠀⠀⠉⠲⣽⡻⢿⣿⣿⣿⣿⣿⣿⣷⣜⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ \n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣷⣶⣮⣭⣽⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀ \n"
                + "⠀⠀⠀⠀⠀⠀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀ \n"
                + "⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀ \n"
                + "⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀ \n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠻⠿⠿⠿⠿⠛⠉");
        shrek.setBounds(485, 35, 270, 245);
        shrek.setEnabled(false);
        shrek.setBackground(Color.black);
        add(shrek);

        amonguss = new JTextArea("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣤⣤⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⠟⠉⠉⠉⠉⠉⠉⠉⠙⠻⢶⣄⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠙⣷⡀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⡟⠀⣠⣶⠛⠛⠛⠛⠛⠛⠳⣦⡀⠀⠘⣿⡄⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⠁⠀⢹⣿⣦⣀⣀⣀⣀⣀⣠⣼⡇⠀⠀⠸⣷⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡏⠀⠀⠀⠉⠛⠿⠿⠿⠿⠛⠋⠁⠀⠀⠀⠀⣿\n"
                + "⠀⠀           ⠀⠀⢠⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡇⠀\n"
                + "                 ⠀⠀⣸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣧⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⢸⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⣾⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⣿⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⣿⠀\n"
                + "⠀⠀⠀⠀⠀⠀⢰⣿⠀⠀⠀⠀⣠⡶⠶⠿⠿⠿⠿⢷⣦⠀⠀⠀⠀⠀    ⣿⠀\n"
                + "⠀⠀⣀⣀⣀⠀⣸⡇⠀⠀⠀⠀⣿⡀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⣿⠀\n"
                + "⣠⡿⠛⠛⠛⠛⠻⠀⠀⠀⠀⠀⢸⣇⠀⠀⠀⠀⠀⠀⣿⠇⠀⠀⠀⠀⠀ ⠀⣿⠀\n"
                + "⢻⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⡟⠀⠀⢀⣤⣤⣴⣿⠀⠀⠀⠀⠀⠀  ⠀⣿⠀\n"
                + "⠈⠙⢷⣶⣦⣤⣤⣤⣴⣶⣾⠿⠛⠁⢀⣶⡟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡟⠀\n"
                + "                               ⠀⠀⠀⠀⠈⣿⣆⡀⠀⠀⠀⠀⠀⠀⢀⣠⣴⡾⠃⠀\n"
                + "⠀                        ⠀⠀⠀⠀⠀⠀⠈⠛⠻⢿⣿⣾⣿⡿⠿⠟⠋⠁⠀⠀⠀");
        amonguss.setBounds(485, 310, 265, 310);
        amonguss.setEnabled(false);
        amonguss.setBackground(Color.black);
        add(amonguss);

        ejecutar = new JButton("Ejecutar");
        ejecutar.setBounds(340, 50, 100, 40);
        ejecutar.addActionListener(this);
        add(ejecutar);

        borrar = new JButton("Borrar");
        borrar.setBounds(250, 50, 75, 40);
        borrar.addActionListener(this);
        add(borrar);

        barra1 = new JTextField("");
        barra1.setBounds(20, 60, 200, 25);
        barra1.setFocusable(true);
        add(barra1);
        ((AbstractDocument) barra1.getDocument()).setDocumentFilter(new DocumentFilter() {
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if (string.matches("\\d+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == borrar) {
            barra1.setText("");
            areatext.setText("");
            mult.setText("");
            prom.setText("");
            factorial.setText("");
            fibonacci.setText("");
            barra1.setEnabled(true);
            barra1.setEditable(true);
            ejecutar.setVisible(true);
        }
        if (e.getSource() == ejecutar) {
            ejecutar.setVisible(false);
            barra1.setEnabled(false);
            t = barra1.getText();
            n = Integer.parseInt(t);
            if (n >= 3 && n <= 10) {
                Recursividad r = new Recursividad();
                int[][] matriz = new int[n][n];
                r.Matriz(matriz, 0,0);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        areatext.append("[" + matriz[i][j] + "]" + "\t");
                        if (i == j) {
                            dprincipal *= matriz[i][j];
                        }
                        if (j == n - 1) {
                            promsuc += matriz[i][j];
                        }
                        if (max < matriz[i][j]) {
                            max = matriz[i][j];
                        }
                        if (matriz[i][j] > 0) {
                            sumapos += matriz[i][j];
                            cont += 1;

                        }
                    }
                    areatext.append("\n");

                }
                propos = sumapos / cont;
                a = 0;
                b = 1;
                c = a + b;
                fibonacci.setText("1,");
                while (c <= propos) {
                    fibonacci.append(c + ",");
                    a = b;
                    b = c;
                    c = a + b;
                }
                
                BigInteger factorialMax = BigInteger.valueOf(max);
                factorialMax = Recursividad.factoRecur(factorialMax);
                /*for (int i = 1; i <= max; i++) {
                    factorialMax = factorialMax.multiply(BigInteger.valueOf(i));

                }*/
                factorial.setText(max + "! = " + factorialMax.toString());
                promsuc = promsuc / n;

            } else {
                barra1.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Error: Coloque un valor valido", "Error", JOptionPane.ERROR_MESSAGE);;
            }

            mult.setText("" + dprincipal);
            prom.setText("" + promsuc);

        }

    }

}
