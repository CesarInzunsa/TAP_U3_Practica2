
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author cesar
 */
public class Lienzo extends Canvas{
    
    Semaforo semaforo1 = new Semaforo(180, 20,  this, 1);
    Semaforo semaforo2 = new Semaforo(560, 460, this, 2);
    
    Carrito carro1 = new Carrito(800, 230, 1, this, semaforo1);
    Carrito carro2 = new Carrito(450, 650, 2, this, semaforo2);
    
    public Lienzo(){
        semaforo1.start();
        semaforo2.start();
        
        carro1.start();
        carro2.start();
    }

    @Override
    public BufferStrategy getBufferStrategy() {
        return super.getBufferStrategy(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createBufferStrategy(int numBuffers) {
        super.createBufferStrategy(numBuffers); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        createBufferStrategy(2);
        this.setBackground(Color.WHITE);
        
        dibujarCalles(g);
        
        semaforo1.dibujarSemaforo(g);
        semaforo2.dibujarSemaforo(g);
        
        carro1.dibujarCarrito(g);
        carro2.dibujarCarrito(g);
        
    }
    
    public void dibujarCalles(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(0, 200, 800, 250);
        g.fillRect(280, 0, 250, 800);
        
        g.setColor(Color.WHITE);
        g.fillRect(400, 0, 10, 30);
        g.fillRect(400, 70, 10, 30);
        g.fillRect(400, 140, 10, 30);
        g.fillRect(400, 470, 10, 30);
        g.fillRect(400, 540, 10, 30);
        g.fillRect(400, 610, 10, 30);
        
        g.fillRect(0, 310, 30, 10);
        g.fillRect(70, 310, 30, 10);
        g.fillRect(140, 310, 30, 10);
        g.fillRect(210, 310, 30, 10);
        g.fillRect(550, 310, 30, 10);
        g.fillRect(630, 310, 30, 10);
        g.fillRect(700, 310, 30, 10);
        g.fillRect(770, 310, 30, 10);
    }
    
}
