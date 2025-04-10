package actividad_02;

import java.awt.*;
import javax.swing.*;

public class PythagorasTree extends JPanel {
    private int profundidad;
    public PythagorasTree(int profundidad) {
        this.profundidad = profundidad;
        setPreferredSize(new Dimension(800, 800));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        trazaArbol(g2d, 400, 700, 100, -90, profundidad);
    }
    private void trazaArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel) {
        if (nivel == 0 || lado < 2) return;
        int x2 = x + (int) (lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));
        g.setColor(Color.getHSBColor((float) nivel / profundidad, 1.0f, 1.0f));
        g.drawLine(x, y, x2, y2);
        int nuevoLado = (int) (lado * 0.7);
        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1);
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1);
    }
    public static void main(String[] args) {
        crearVentana(6);
        crearVentana(8);
        crearVentana(10);
    }
    private static void crearVentana(int nivel) {
        JFrame ventana = new JFrame("Árbol de Pitágoras - Nivel " + nivel);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().add(new PythagorasTree(nivel));
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}