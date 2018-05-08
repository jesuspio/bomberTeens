package prueba;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Personaje {	
	//Bomb b;
	int velX = 0, velY = 0;
	private int x=500;
	private int y=200;
        private int w=500;
        private int z=200;
	private Dibujar obj;
        private Boolean bomba = false;
	BufferedImage aux;
        BufferedImage aux2;
	BufferedImage i0;
	BufferedImage i1;
	BufferedImage i2;
	BufferedImage i3;
    BufferedImage i4;
    BufferedImage i5;
    BufferedImage i6;
    BufferedImage i7;
    BufferedImage b1;
    Bomba b = new Bomba();
    private final int ANCHO=100;
	private final int ALTO=100;
	
	public Personaje(Dibujar obj){
		this.obj=obj;
		
		try {
			this.i0=ImageIO.read(new FileInputStream("resources/Mono1.png"));
			this.i1=ImageIO.read(new FileInputStream("resources/Mono2.png"));
			this.i2=ImageIO.read(new FileInputStream("resources/Mono1Izq.png"));
			this.i3=ImageIO.read(new FileInputStream("resources/Mono2Izq.png"));
            this.i4=ImageIO.read(new FileInputStream("resources/Mono1Ar.png"));
            this.i5=ImageIO.read(new FileInputStream("resources/Mono2Ar.png"));
            this.i6=ImageIO.read(new FileInputStream("resources/Mono1Ab.png"));
            this.i7=ImageIO.read(new FileInputStream("resources/Mono2Ab.png"));
            this.b1=ImageIO.read(new FileInputStream("resources/Bomb.png"));
            
			this.aux=ImageIO.read(new FileInputStream("resources/Mono1.png"));
                        this.aux2=ImageIO.read(new FileInputStream("resources/Bomb.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void move(){
		if(x>obj.getWidth()-ANCHO)
			x=obj.getWidth()-ANCHO;
		if(x<0)
			x=0;
		if(y>obj.getHeight()-ALTO)
			y=obj.getHeight()-ALTO;
		if(y<0)
			y=0;
                
                
	}	

	public void caminarDerecha(){
		if(aux==i0){
			aux=i1;			
		} else {
			aux=i0;
		}
	}
	
	public void caminarIzquierda(){
		if(aux==i2){
			aux=i3;			
		} else {
			aux=i2;
		}
	}
	
        public void caminarArriba(){
		if(aux==i4){
			aux=i5;			
		} else {
			aux=i4;
		}
	}
        
        public void caminarAbajo(){
		if(aux==i6){
			aux=i7;			
		} else {
			aux=i6;
		}
	}
        
        public void ponerBomba(Boolean bomba){
                aux2=b1;
               
        }
            
	public void paint(Graphics g){		
        g.drawImage(aux, x, y, 100, 100, null);
        if(bomba){
          //  b.ponerBomba(g,w,z);
           // g.drawImage(aux2,w+15,z+15,70,70,null);
            
        }
        
	}

    public BufferedImage getAux2() {
        return aux2;
    }

    public void setAux2(BufferedImage aux2) {
        this.aux2 = aux2;
    }
	
	
    

        
        public void update(){
            y += velY;
            x += velX; 
        }
            
	public void keyPressed(KeyEvent ke){
		if(ke.getKeyCode()==KeyEvent.VK_D){
			velX = 10;
			caminarDerecha();
                       
		}
		if(ke.getKeyCode()==KeyEvent.VK_A){
			velX = -10;
			caminarIzquierda();
		}
		if(ke.getKeyCode()==KeyEvent.VK_W){
			velY = -10;
            caminarArriba();
                }
		if(ke.getKeyCode()==KeyEvent.VK_S){
			velY = 10;
            caminarAbajo();
                }
		if(ke.getKeyCode()==KeyEvent.VK_SPACE){
			
		}               // System.out.println(velX + "   " + velY);

	}
        
        public void keyReleased(KeyEvent ke){
		if(ke.getKeyCode()==KeyEvent.VK_D){
			velX = 0;
                        
			caminarDerecha();
		}
		if(ke.getKeyCode()==KeyEvent.VK_A){
			velX = 0;
			caminarIzquierda();
		}
		if(ke.getKeyCode()==KeyEvent.VK_W){
			velY = 0;
            caminarArriba();
                }
		if(ke.getKeyCode()==KeyEvent.VK_S){
			velY =0;
            caminarAbajo();
                }
		if(ke.getKeyCode()==KeyEvent.VK_SPACE){
//                        bomba = true;
//                        w=x;
//                        z=y;
//			ponerBomba(bomba);
		}            //    System.out.println(velX + "   " + velY);

	}

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}
