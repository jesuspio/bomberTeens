package prueba;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Dibujar extends JFrame {
	private static final long serialVersionUID = 1L;

	Mapa map = new Mapa(this);
	Menu men = new Menu(this);
	SecondMenu sm = new SecondMenu(this);
	private int[][] matriz = map.getMatriz();
	Bomba b = new Bomba();
        Bomba b1 = new Bomba();
	Bomba b2 = new Bomba();
        Bomba b3 = new Bomba();
	Personaje c = new Personaje(this, b,b1, 1, matriz);
	Personaje c2 = new Personaje(this, b2,b3, 2, matriz);
	BufferedImage bomb;
	BufferedImage exp;
	BufferedImage exp2;
	BufferedImage exp3;

	public Dibujar() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 50, 1200, 633);
		setTitle("Bomberman");

		// TECLADO
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				c.keyPressed(ke);
			}

			/**
			 * INICIO BOMBA PERSONAJE 1
			 */
			public void keyReleased(KeyEvent ke) {
				c.keyReleased(ke);
				if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
                                    
                                        
                                        
					if (b.isAlive()) {
                                            
						if(c.cantBombas==2){
                                                    if(b1.isAlive()){
                                                        
                                                    }else{
                                                    System.out.println(c.cantBombas);
                                                    b1 = new Bomba();
						int w = c.getX();
						int z = c.getY();
                                                c.getCantBombas();
						c.setW(w);
						c.setZ(z);
						bomb = c.getAuxB();
						exp = c.getE();
						exp2 = c.getE2();
						exp3 = c.getE3();
						b1.ponerBomba(bomb, exp, exp2, exp3, w, z, matriz);
						b1.start();
                                                }}
					} else {
                                            
						b = new Bomba();
						int w = c.getX();
						int z = c.getY();
                                                c.getCantBombas();
						c.setW(w);
						c.setZ(z);
						bomb = c.getAuxB();
						exp = c.getE();
						exp2 = c.getE2();
						exp3 = c.getE3();
						b.ponerBomba(bomb, exp, exp2, exp3, w, z, matriz);
						b.start();
					}

				
                                }
			}
		});
		/**
		 * FIN BOMBA PERSONAJE 2
		 */

		/**
		 * INICIO BOMBA PERSONAJE 2
		 */
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				c2.keyPressed2(ke);
			}

			public void keyReleased(KeyEvent ke) {
				c2.keyReleased2(ke);
				if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
					if (b2.isAlive()) {
						// CASO PARA QUE CUANDO EXISTA UNA BOMBA NO SE PUEDA
						// PONER OTRA
                                                if(c2.cantBombas==2){
                                                    if(b3.isAlive()){
                                                        
                                                    }else{
                                                    System.out.println(c2.cantBombas);
                                                    b3 = new Bomba();
						int w = c2.getX();
						int z = c2.getY();
                                                c2.getCantBombas();
						c2.setW(w);
						c2.setZ(z);
						bomb = c2.getAuxB();
						exp = c2.getE();
						exp2 = c2.getE2();
						exp3 = c2.getE3();
						b3.ponerBomba(bomb, exp, exp2, exp3, w, z, matriz);
						b3.start();
                                                }}
					} else {
						b2 = new Bomba();
						int w = c2.getX();
						int z = c2.getY();
						c2.setW(w);
						c2.setZ(z);
						bomb = c2.getAuxB();
						exp = c2.getE();
						exp2 = c2.getE2();
						exp3 = c2.getE3();
						b2.ponerBomba(bomb, exp, exp2, exp3, w, z, matriz);
						b2.start();
					}
				}
			}
		});
		/**
		 * FIN BOMBA PERSONAJE 2
		 */
		setFocusable(true);
		requestFocusInWindow();

		// MOUSE PARA MENU
		addMouseListener(new MouseEntrada(this));
	}

	public enum STATE {
		MENU, GAME, AFTERMATCH, SECONDMENU
	};

	public STATE State = STATE.MENU;

	public STATE getState2() { // CAMBIO DE NOMBRE PARA QUE NO INTERFIERA CON
								// NOMBRE THREAD
		return State;
	}

	public void setState(STATE state) {
		State = state;
	}

	private void mover() {
		c.move();
		c2.move();
	}

	public void reset() {
		map = new Mapa(this);
		this.matriz = map.getMatriz();
		c = new Personaje(this, b,b1, 1, matriz);
		c2 = new Personaje(this, b2,b3, 2, matriz);
		setFocusable(true);
		requestFocusInWindow();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g); // METODO QUE LIMPIA LA PANTALLA
		if (State == STATE.GAME) { // ESTADO DE JUEGO O MENU
			if (c.isBanderaMovimiento() == true)
				c.updateY();
			if (c.isBanderaMovimiento() == false)
				c.updateX();

			if (c2.isBanderaMovimiento() == true)
				c2.updateY();
			if (c2.isBanderaMovimiento() == false)
				c2.updateX();

			map.paint(g);
			c.paint(g);
			c2.paint(g);
			b.paint(g);
                        b1.paint(g);
			b2.paint(g);
                        b3.paint(g);
                        
			if (!b.isAlive()) {
				c.setW(1200);
				c.setZ(800);
			}
			if (!b2.isAlive()) {
				c2.setW(1200);
				c2.setZ(800);
			}
                        if(!b1.isAlive()){
                            c.setW(1200);
                            c.setZ(800);
                        }
                       if(!b3.isAlive()){
                           c2.setW(1200);
                           c2.setZ(800);
                       }

			// EVALUAR MUERTE 1
			if (b.isBanE() == true && c.getX() > b.getW() - 70 && c.getX() < b.getW() + 70 && c.getY() > b.getZ() - 150
					&& c.getY() < b.getZ() + 150
					|| b.isBanE() == true && c.getY() > b.getZ() - 70 && c.getY() < b.getZ() - 70
							&& c.getX() > b.getW() - 150 && c.getX() < b.getW() + 150) {
				System.out.println("Jugador 1 muerto");
				c.setMuerte();
				setFocusable(false); // APAGAR TECLADO POSIBLEMENTE AFECTE A
										// MOUSE
				setState(STATE.AFTERMATCH);
				sm.setMensaje("PLAYER 2 WINS !");
			}
                        if (b1.isBanE() == true && c.getX() > b1.getW() - 70 && c.getX() < b1.getW() + 70 && c.getY() > b1.getZ() - 150
					&& c.getY() < b1.getZ() + 150
					|| b1.isBanE() == true && c.getY() > b1.getZ() - 70 && c.getY() < b1.getZ() - 70
							&& c.getX() > b1.getW() - 150 && c.getX() < b1.getW() + 150) {
				System.out.println("Jugador 1 muerto");
				c.setMuerte();
				setFocusable(false); // APAGAR TECLADO POSIBLEMENTE AFECTE A
										// MOUSE
				setState(STATE.AFTERMATCH);
				sm.setMensaje("PLAYER 2 WINS !");
			}
			// JUGADOR 2 MATA A JUGADOR 1
			if (b2.isBanE() == true && c.getX() > b2.getW() - 70 && c.getX() < b2.getW() + 70
					&& c.getY() > b2.getZ() - 150 && c.getY() < b2.getZ() + 150
					|| b2.isBanE() == true && c.getY() > b2.getZ() - 70 && c.getY() < b2.getZ() + 70
							&& c.getX() > b2.getW() - 150 && c.getX() < b2.getW() + 150) {
				System.out.println("Jugador 1 muerto");
				c.setMuerte();
				setFocusable(false); // APAGAR TECLADO POSIBLEMENTE AFECTE A
										// MOUSE
				setState(STATE.AFTERMATCH);
				sm.setMensaje("PLAYER 2 WINS !");
			}
                        if (b3.isBanE() == true && c.getX() > b3.getW() - 70 && c.getX() < b3.getW() + 70
					&& c.getY() > b3.getZ() - 150 && c.getY() < b3.getZ() + 150
					|| b3.isBanE() == true && c.getY() > b3.getZ() - 70 && c.getY() < b3.getZ() + 70
							&& c.getX() > b3.getW() - 150 && c.getX() < b3.getW() + 150) {
				System.out.println("Jugador 1 muerto");
				c.setMuerte();
				setFocusable(false); // APAGAR TECLADO POSIBLEMENTE AFECTE A
										// MOUSE
				setState(STATE.AFTERMATCH);
				sm.setMensaje("PLAYER 2 WINS !");
			}

			// EVALUAR MUERTE 2
			if (b2.isBanE() == true && c2.getX() > b2.getW() - 70 && c2.getX() < b2.getW() + 70
					&& c2.getY() > b2.getZ() - 150 && c2.getY() < b2.getZ() + 150
					|| b2.isBanE() == true && c2.getY() > b2.getZ() - 70 && c2.getY() < b2.getZ() + 70
							&& c2.getX() > b2.getW() - 150 && c2.getX() < b2.getW() + 150) {
				System.out.println("Jugador 2 muerto");
				c2.setMuerte();
				setFocusable(false); // APAGAR TECLADO POSIBLEMENTE AFECTE A
										// MOUSE
				setState(STATE.AFTERMATCH);
				sm.setMensaje("PLAYER 1 WINS !");
			}
                        if (b3.isBanE() == true && c2.getX() > b3.getW() - 70 && c2.getX() < b3.getW() + 70
					&& c2.getY() > b3.getZ() - 150 && c2.getY() < b3.getZ() + 150
					|| b3.isBanE() == true && c2.getY() > b3.getZ() - 70 && c2.getY() < b3.getZ() + 70
							&& c2.getX() > b3.getW() - 150 && c2.getX() < b3.getW() + 150) {
				System.out.println("Jugador 2 muerto");
				c2.setMuerte();
				setFocusable(false); // APAGAR TECLADO POSIBLEMENTE AFECTE A
										// MOUSE
				setState(STATE.AFTERMATCH);
				sm.setMensaje("PLAYER 1 WINS !");
			}
			// JUGADOR 1 MATA A JUGADOR 2
			if (b.isBanE() == true && c2.getX() > b.getW() - 70 && c2.getX() < b.getW() + 70
					&& c2.getY() > b.getZ() - 150 && c2.getY() < b.getZ() + 150
					|| b.isBanE() == true && c2.getY() > b.getZ() - 70 && c2.getY() < b.getZ() + 70
							&& c2.getX() > b.getW() - 150 && c2.getX() < b.getW() + 150) {
				System.out.println("Jugador 2 muerto");
				c2.setMuerte();
				setFocusable(false); // APAGAR TECLADO POSIBLEMENTE AFECTE A
										// MOUSE
				setState(STATE.AFTERMATCH);
				sm.setMensaje("PLAYER 1 WINS !");
			}
                        if (b1.isBanE() == true && c2.getX() > b1.getW() - 70 && c2.getX() < b1.getW() + 70 && c2.getY() > b1.getZ() - 150
					&& c2.getY() < b1.getZ() + 150
					|| b1.isBanE() == true && c2.getY() > b1.getZ() - 70 && c2.getY() < b1.getZ() - 70
							&& c2.getX() > b1.getW() - 150 && c2.getX() < b1.getW() + 150) {
				System.out.println("Jugador 1 muerto");
				c.setMuerte();
				setFocusable(false); // APAGAR TECLADO POSIBLEMENTE AFECTE A
										// MOUSE
				setState(STATE.AFTERMATCH);
				sm.setMensaje("PLAYER 2 WINS !");
			}

		}

		if (State == STATE.MENU) { // CONDICION PARA MENU
			men.paint(g);
		}

		if (getState2() == STATE.AFTERMATCH) {
			map.paint(g);
			c.paint(g);
			c2.paint(g);
			b.paint(g);
                        b1.paint(g);
			b2.paint(g);
                        b3.paint(g);
		}
		if (getState2() == STATE.SECONDMENU) {
			map.paint(g);
			c.paint(g);
			c2.paint(g);
			b.paint(g);
                        b1.paint(g);
			b2.paint(g);
                        b3.paint(g);
			sm.paint(g);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Dibujar obj = new Dibujar();
		obj.setVisible(true);

		while (true) {
			Thread.sleep(500);
			if (obj.getState2() == STATE.GAME)
				break;
		}

		while (true) {
			obj.mover();
			obj.repaint(); // ACTUALIZAR PANTALLA
			if (obj.getState2() == STATE.AFTERMATCH) {
				Thread.sleep(1000);
				obj.repaint(); // PINTAR IMAGEN DE MUERTE SIN ACTUALIZAR
				obj.setState(STATE.SECONDMENU);
				while (true) {
					if (obj.getState2() == STATE.GAME)
						break;
					Thread.sleep(500);
				}
			}
			Thread.sleep(60);
		}

	}
}
