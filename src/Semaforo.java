
import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesar
 */
public class Semaforo extends Thread {
    
    private final int x;
    private final int y;
    private int estadoSemaforo;
    private final Lienzo lienzo;

    public Semaforo(int x, int y, Lienzo lienzo, int estadoSemaforo) {
        this.x = x;
        this.y = y;
        this.lienzo = lienzo;
        this.estadoSemaforo = estadoSemaforo;
    }

    @Override
    public void run() {
        super.run();
        
        while (true) {
            try {
                switch (estadoSemaforo) {
                    case 1:
                        lienzo.repaint();
                        sleep(7000);
                        estadoSemaforo = 2;
                        break;
                    case 2:
                        lienzo.repaint();
                        sleep(4000);
                        estadoSemaforo = 3;
                        break;
                    case 3:
                        lienzo.repaint();
                        sleep(7000);
                        estadoSemaforo = 1;
                        break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public void dibujarSemaforo(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, 70, 170);
        
        dibujarOscuro(g);
        dibujarBrillante(g);
    }
    
    private void dibujarOscuro(Graphics g){
        g.setColor(new Color(160,0,0));
        g.fillOval(x + 15, y + 15, 40, 40);

        g.setColor(new Color(160,155,0));
        g.fillOval(x + 15, y + 65, 40, 40);

        g.setColor(new Color(0,160,0));
        g.fillOval(x + 15, y + 115, 40, 40);
    }

    private void dibujarBrillante(Graphics g){
        switch (estadoSemaforo) {
            case 1:
                //rojo brillante
                g.setColor(Color.RED);
                g.fillOval(x + 15, y + 15, 40, 40);
                break;
            case 2:
                //amarillo brillante
                g.setColor(Color.YELLOW);
                g.fillOval(x + 15, y + 65, 40, 40);
                break;
            case 3:
                //verde brillante
                g.setColor(Color.GREEN);
                g.fillOval(x + 15, y + 115, 40, 40);
                break;
        }
    }
    
}
