package prueba;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import prueba.Dibujar.STATE;

public class MouseEntrada implements MouseListener{
	Dibujar obj;	

	public MouseEntrada(Dibujar obj){
		this.obj=obj;
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
			public Rectangle botonJugar=new Rectangle(350, 200, 500, 50); //X, Y, WIDTH, HEIGHT
			public Rectangle botonSalir=new Rectangle(350, 300, 500, 50); //X, Y, WIDTH, HEIGHT
		**/
		int mx=me.getX();
		int my=me.getY();
		//CASO PARA BOTON JUGAR
		if(mx>350&&mx<850){
			if(my>200&&my<250){
				obj.State=STATE.GAME;
			}
		}
		
		//CASO BOTON SALIR
		if(mx>350&&mx<850){
			if(my>300&&my<350){
				System.exit(0);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		
	}
	


}
