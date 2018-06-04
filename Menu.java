package prueba;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Menu{
	Dibujar obj;
	int o=0;
	BufferedImage i0;
	Font fnt1=new Font("arial", Font.BOLD, 20);
	
	public Menu(Dibujar obj){
		this.obj=obj;
		try {
			this.i0=ImageIO.read(new FileInputStream("resources/Menu/Fondo.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public Rectangle botonJugar=new Rectangle(550, 400, 150, 25); //X, Y, WIDTH, HEIGHT
	public Rectangle botonSalir=new Rectangle(550, 450, 150, 25); //X, Y, WIDTH, HEIGHT
	
	public void paint(Graphics g){
		//IMAGENES
		g.drawImage(i0, 0, 20, 1200, 605, null); //FONDO
				
		Graphics2D g2d=(Graphics2D) g;

		g.setColor(Color.black);
				
		g.setFont(fnt1);
				
		g2d.setColor(new Color(24, 165, 255)); //PRIMERO FILL, LUEGO DIBUJAR, SE TIENE QUE RESPETAR EL ORDEN
		g2d.fill(botonJugar);				
		g2d.setColor(Color.black);
		g2d.draw(botonJugar);
		g.drawString("Jugar", botonJugar.x+45, botonJugar.y+20);		
		
		g2d.setColor(new Color(24, 165, 255));
		g2d.fill(botonSalir);		
		g2d.setColor(Color.black);
		g2d.draw(botonSalir);
		g.drawString("Salir", botonSalir.x+45, botonSalir.y+20);							
		
	}

	
}
