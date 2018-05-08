package prueba;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class Mapa {
	private Dibujar obj;
	
	public Mapa(Dibujar obj){
		this.obj=obj;		
	}
	
	public void paint(Graphics g){
		g.setColor(new Color(25, 111, 61));
		g.fillRect(0, 0, obj.getWidth(), obj.getHeight());
	}
        
        
}
