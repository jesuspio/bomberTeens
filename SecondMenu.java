package prueba;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SecondMenu {
	Dibujar obj;
	int o=0;
	BufferedImage i0;
	Font fnt1=new Font("arial", Font.BOLD, 20);
	Font fnt2=new Font("arial", Font.BOLD, 60);
	private String mensaje="";
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public SecondMenu(Dibujar obj){
		this.obj=obj;
	}
	
	public Rectangle botonJugar=new Rectangle(550, 400, 150, 25); //X, Y, WIDTH, HEIGHT
	public Rectangle botonSalir=new Rectangle(550, 450, 150, 25); //X, Y, WIDTH, HEIGHT
	public Rectangle aviso=new Rectangle(250, 60, 680, 180); //X, Y, WIDTH, HEIGHT
        public Rectangle marco=new Rectangle(240, 50, 700, 200); //X, Y, WIDTH, HEIGHT
	
	public void paint(Graphics g){				
		Graphics2D g2d=(Graphics2D) g;

		g.setColor(Color.black);
				
		g.setFont(fnt1);
				
		g2d.setColor(new Color(24, 165, 255)); //PRIMERO FILL, LUEGO DIBUJAR, SE TIENE QUE RESPETAR EL ORDEN
		g2d.fill(botonJugar);				
		g2d.setColor(Color.black);
		g2d.draw(botonJugar);
		g.drawString("Nueva Partida", botonJugar.x+10, botonJugar.y+20);		
		
		g2d.setColor(new Color(24, 165, 255));
		g2d.fill(botonSalir);		
		g2d.setColor(Color.black);
		g2d.draw(botonSalir);
		g.drawString("Salir", botonSalir.x+45, botonSalir.y+20);
		
                g2d.setColor(new Color(24, 165, 255));
		g2d.fill(marco);	
		g2d.setColor(Color.black);
		g2d.draw(marco);
                
		g.setFont(fnt2);
		g2d.setColor(Color.white);
		g2d.fill(aviso);	
		g2d.setColor(Color.black);
		g2d.draw(aviso);
		g.drawString(mensaje, aviso.x+100, aviso.y+105);
		
	}
	

}
