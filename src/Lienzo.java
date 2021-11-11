
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author cesar
 */
public class Lienzo extends Canvas{
    
    Semaforo semaforo1 = new Semaforo(150, 10,  this, 3);
    Semaforo semaforo2 = new Semaforo(500, 410, this, 1);
    
    Carrito carro1 = new Carrito(480, 180, 1, this, semaforo1);
    Carrito carro2 = new Carrito(400, 400, 2, this, semaforo2);
    Carrito carro3 = new Carrito(130, 310, 3, this, semaforo1);
    Carrito carro4 = new Carrito(265, 50, 4, this, semaforo2);
    
    public Lienzo(){
        semaforo1.start();
        semaforo2.start();
        
        carro1.start();
        carro2.start();
        carro3.start();
        carro4.start();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.WHITE);
        
        dibujarCalles(g);
        
        semaforo1.dibujarSemaforo(g);
        semaforo2.dibujarSemaforo(g);
        
        carro1.dibujarCarrito(g);
        carro2.dibujarCarrito(g);
        carro3.dibujarCarrito(g);
        carro4.dibujarCarrito(g);
        
    }
    
    public void dibujarCalles(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(0, 150, 700, 250);
        g.fillRect(230, 0, 250, 550);
        
        g.setColor(Color.WHITE);
        g.fillRect(350, 0, 10, 30);
        g.fillRect(350, 60, 10, 30);
        g.fillRect(350, 120, 10, 30);
        
        g.fillRect(350, 400, 10, 30);
        g.fillRect(350, 460, 10, 30);
        g.fillRect(350, 520, 10, 30);
        
        g.fillRect(0,   265, 30, 10);
        g.fillRect(65,  265, 30, 10);
        g.fillRect(130, 265, 30, 10);
        g.fillRect(200, 265, 30, 10);
        
        g.fillRect(480, 265, 30, 10);
        g.fillRect(550, 265, 30, 10);
        g.fillRect(620, 265, 30, 10);
        g.fillRect(690, 265, 30, 10);
        
        //g.setColor(Color.BLUE);
        //g.fillRect(180, 50, 50, 50);
    }
    
}
