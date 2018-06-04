package prueba;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import prueba.Dibujar.STATE;

public class MouseEntrada implements MouseListener {
	Dibujar obj;

	public MouseEntrada(Dibujar obj) {
		this.obj = obj;
	}

	@Override
	public void mouseClicked(MouseEvent me) {

	}

	@Override
	public void mouseEntered(MouseEvent me) {

	}

	@Override
	public void mouseExited(MouseEvent me) {

	}

	@Override
	public void mousePressed(MouseEvent me) {
		/**
		 * public Rectangle botonJugar=new Rectangle(550, 400, 150, 25); //X, Y, WIDTH, HEIGHT 
		 * public Rectangle botonSalir=new Rectangle(550, 450, 150, 25); //X, Y, WIDTH, HEIGHT
		 **/
		int mx = me.getX();
		int my = me.getY();
		// CASO PARA BOTON JUGAR
		if (mx > 550 && mx < 700) {
			if (my > 400 && my < 425) {
				obj.reset();
				obj.State = STATE.GAME;
			}
		}

		// CASO BOTON SALIR
		if (mx > 350 && mx < 700) {
			if (my > 450 && my < 475) {
				System.exit(0);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent me) {

	}

}
