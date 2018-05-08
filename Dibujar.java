package prueba;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Dibujar extends JFrame{
	private static final long serialVersionUID = 1L;
	Personaje c=new Personaje(this);
	Mapa map=new Mapa(this);
	Menu men=new Menu(this);
        Bomba b = new Bomba();
        BufferedImage bomb;
	public Dibujar() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 50, 1200, 600);
		setTitle("Bomberman");
		
		//TECLADO
		addKeyListener(new KeyAdapter( ){
			public void keyPressed(KeyEvent ke){
                            c.keyPressed(ke);
			}
                        public void keyReleased(KeyEvent ke){
                            c.keyReleased(ke);
                            if(ke.getKeyCode()==KeyEvent.VK_SPACE){
                                int w = c.getX();
                                int z = c.getY();
                                bomb = c.getAux2();
                                b.ponerBomba(bomb, w, z);
		} 
                        }
		});
		setFocusable(true);
		requestFocusInWindow();
		//MOUSE PARA MEN�
		addMouseListener(new MouseEntrada(this));		
	}
	
	public enum STATE{
		MENU,
		GAME
	};
	
	public STATE State=STATE.MENU;			
	
	public STATE getState2() { //CAMBIO DE NOMBRE PARA QUE NO INTERFIERA CON NOMBRE THREAD
		return State;
	}

	public void setState(STATE state) {
		State = state;
	}

	private void mover(){
		c.move();
	}
	
	public void paint(Graphics g){
		super.paint(g); //METODO QUE LIMPIA LA PANTALLA	
                
		if(State==STATE.GAME){ //ESTADO DE JUEGO O MENU
			map.paint(g);
                        c.update();
			c.paint(g);
                        b.paint(g);
                        
		} else {
			men.paint(g);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Dibujar obj=new Dibujar();
		obj.setVisible(true);
		
		while(true){ //SUSTITUIR CON UN VERDADERO CONTADOR DE FRAMES
			Thread.sleep(500);
			if(obj.getState2()==STATE.GAME)
				break;
		}
		
		while(true){
			obj.mover();
			obj.repaint(); //ACTUALIZAR PANTALLA
			Thread.sleep(60);
		}

	}
}
