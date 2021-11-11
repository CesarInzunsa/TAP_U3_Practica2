
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
                    case 1://rojo
                        lienzo.repaint();
                        sleep(7000);
                        estadoSemaforo = 2;
                        break;
                    case 2://amarillo que va a verde
                        lienzo.repaint();
                        sleep(2000);
                        estadoSemaforo = 3;
                        break;
                    case 3://verde
                        lienzo.repaint();
                        sleep(7000);
                        estadoSemaforo = 4;
                        break;
                    case 4://amarillo que va a rojo
                        lienzo.repaint();
                        sleep(2000);
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
        g.fillRect(x, y, 50, 130);
        
        dibujarOscuro(g);
        dibujarBrillante(g);
    }
    
    private void dibujarOscuro(Graphics g){
        g.setColor(new Color(160,0,0));
        g.fillOval(x + 10, y + 10, 30, 30);

        g.setColor(new Color(160,155,0));
        g.fillOval(x + 10, y + 50, 30, 30);

        g.setColor(new Color(0,160,0));
        g.fillOval(x + 10, y + 90, 30, 30);
    }

    private void dibujarBrillante(Graphics g){
        switch (estadoSemaforo) {
            case 1:
                //rojo brillante
                g.setColor(Color.RED);
                g.fillOval(x + 10, y + 10, 30, 30);
                break;
            case 2:
                //amarillo brillante
                g.setColor(Color.YELLOW);
                g.fillOval(x + 10, y + 50, 30, 30);
                break;
            case 3:
                //verde brillante
                g.setColor(Color.GREEN);
                g.fillOval(x + 10, y + 90, 30, 30);
                break;
            case 4:
                //amarillo brillante
                g.setColor(Color.YELLOW);
                g.fillOval(x + 10, y + 50, 30, 30);
                break;
        }
    }

    public int getEstadoSemaforo() {
        return estadoSemaforo;
    }
    
}
