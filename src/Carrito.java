
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesar
 */
public class Carrito extends Thread {

    private int x;
    private int y;
    private int orientacion;
    private Semaforo semaforo;
    private Lienzo lienzo;
    private int desplazamientoX = 10;

    /*
        1 --> horizontal
        2 --> vertical
     */
    public Carrito(int x, int y, int orientacion, Lienzo lienzo, Semaforo semaforo) {
        this.x = x;
        this.y = y;
        this.orientacion = orientacion;
        this.lienzo = lienzo;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.

        while (true) {
            try {
                desplazarCarrito();
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Carrito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void dibujarCarrito(Graphics g) {
        switch (orientacion) {
            case 1:
                dibujarHorizontalIzquierda(g);
                break;
            case 2:
                dibujarVerticalArriba(g);
                break;
            case 3:
                dibujarHorizontalDerecha(g);
                break;
            case 4:
                dibujarVerticalAbajo(g);
                break;
        }
    }

    private void dibujarHorizontalIzquierda(Graphics g) {
        Color a = new Color(132, 175, 187);
        Color b = new Color(108, 144, 152);

        g.setColor(a);
        g.fillRect(x, y, 100, 50);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x + 10, y + 50, 20, 5, 5, 5);
        g.fillRoundRect(x + 60, y + 50, 20, 5, 5, 5);
        g.fillRoundRect(x + 10, y - 5, 20, 5, 5, 5);
        g.fillRoundRect(x + 60, y - 5, 20, 5, 5, 5);
        g.setColor(Color.WHITE);
        g.fillRect(x + 25, y + 5, 60, 40);
        g.setColor(b);
        g.fillRect(x + 40, y + 5, 35, 40);
        g.setColor(Color.WHITE);
        g.fillRect(x + 9, y + 33, 7, 7);
        g.fillRect(x + 9, y + 10, 7, 7);
    }

    private void dibujarHorizontalDerecha(Graphics g) {
        Color a = new Color(132, 175, 187);
        Color b = new Color(108, 144, 152);

        g.setColor(a);
        g.fillRect(x, y, 100, 50);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x + 10, y + 50, 20, 5, 5, 5);
        g.fillRoundRect(x + 60, y + 50, 20, 5, 5, 5);
        g.fillRoundRect(x + 10, y - 5, 20, 5, 5, 5);
        g.fillRoundRect(x + 60, y - 5, 20, 5, 5, 5);
        g.setColor(Color.WHITE);
        g.fillRect(x + 10, y + 5, 60, 40);
        g.setColor(b);
        g.fillRect(x + 20, y + 5, 35, 40);
        g.setColor(Color.WHITE);
        g.fillRect(x + 80, y + 33, 7, 7);
        g.fillRect(x + 80, y + 10, 7, 7);
    }

    private void dibujarVerticalArriba(Graphics g) {
        Color a = new Color(132, 175, 187);
        Color b = new Color(108, 144, 152);

        g.setColor(a);
        g.fillRect(x, y, 50, 100);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x - 5, y + 60, 5, 20, 5, 5);
        g.fillRoundRect(x + 50, y + 60, 5, 20, 5, 5);
        g.fillRoundRect(x - 5, y + 10, 5, 20, 5, 5);
        g.fillRoundRect(x + 50, y + 10, 5, 20, 5, 5);
        g.setColor(Color.WHITE);
        g.fillRect(x + 5, y + 25, 40, 60);
        g.setColor(b);
        g.fillRect(x + 5, y + 40, 40, 35);
        g.setColor(Color.WHITE);
        g.fillRect(x + 33, y + 9, 7, 7);
        g.fillRect(x + 10, y + 9, 7, 7);
    }

    private void dibujarVerticalAbajo(Graphics g) {
        Color a = new Color(132, 175, 187);
        Color b = new Color(108, 144, 152);

        g.setColor(a);
        g.fillRect(x, y, 50, 100);
        g.setColor(Color.BLACK);
        g.fillRoundRect(x - 5, y + 60, 5, 20, 5, 5);
        g.fillRoundRect(x + 50, y + 60, 5, 20, 5, 5);
        g.fillRoundRect(x - 5, y + 10, 5, 20, 5, 5);
        g.fillRoundRect(x + 50, y + 10, 5, 20, 5, 5);
        g.setColor(Color.WHITE);
        g.fillRect(x + 5, y + 10, 40, 60);
        g.setColor(b);
        g.fillRect(x + 5, y + 20, 40, 35);
        g.setColor(Color.WHITE);
        g.fillRect(x + 33, y + 80, 7, 7);
        g.fillRect(x + 10, y + 80, 7, 7);
    }

    private void desplazarCarrito() {
        switch (orientacion) {
            case 1:
                if (x==480 && (this.semaforo.getEstadoSemaforo() == 1 || this.semaforo.getEstadoSemaforo() == 2 || this.semaforo.getEstadoSemaforo() == 4)) {
                    break;
                }
                x -= desplazamientoX;
                if (x <= -100) {
                    x = 800;
                }
                lienzo.repaint();
                break;
            case 2:
                if (y==400 && (this.semaforo.getEstadoSemaforo() == 1 || this.semaforo.getEstadoSemaforo() == 2 || this.semaforo.getEstadoSemaforo() == 4)) {
                    break;
                }
                y -= desplazamientoX;
                if (y <= -100) {
                    y = 650;
                }
                lienzo.repaint();
                break;
            case 3:
                if (x==130 && (this.semaforo.getEstadoSemaforo() == 1 || this.semaforo.getEstadoSemaforo() == 2 || this.semaforo.getEstadoSemaforo() == 4)) {
                    break;
                }
                x += desplazamientoX;
                if (x >= 800) {
                    x = -100;
                }
                lienzo.repaint();
                break;
            case 4:
                if (y==50 && (this.semaforo.getEstadoSemaforo() == 1 || this.semaforo.getEstadoSemaforo() == 2 || this.semaforo.getEstadoSemaforo() == 4)) {
                    break;
                }
                y += desplazamientoX;
                if (y >= 650) {
                    y = -100;
                }
                lienzo.repaint();
                break;
        }
    }

}
