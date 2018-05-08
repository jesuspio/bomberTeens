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
	BufferedImage i1;
	BufferedImage i2;
	Font fnt0=new Font("arial", Font.BOLD, 90);
	Font fnt1=new Font("arial", Font.BOLD, 30);
	
	public Menu(Dibujar obj){
		this.obj=obj;
		try {
			this.i0=ImageIO.read(new FileInputStream("resources/Menu/Fondo.png"));
			this.i1=ImageIO.read(new FileInputStream("resources/Menu/Bomberman1.png"));
			this.i2=ImageIO.read(new FileInputStream("resources/Menu/Bomberman2.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public Rectangle botonJugar=new Rectangle(350, 200, 500, 50); //X, Y, WIDTH, HEIGHT
	public Rectangle botonSalir=new Rectangle(350, 300, 500, 50); //X, Y, WIDTH, HEIGHT
	
	public void paint(Graphics g){
		//IMAGENES
		g.drawImage(i0, 0, 0, i0.getWidth(), i0.getHeight(), null); //FONDO
		g.drawImage(i1, 70, 100, 300, 400, null); //PRIMER BOMBERMAN
		g.drawImage(i2, 890, 150, 250, 250, null); //SEGUNDO BOMBERMAN	
				
		Graphics2D g2d=(Graphics2D) g;
				
		g.setFont(fnt0);
		g.setColor(Color.black);
		g.drawString("BOMBERMAN", 310, 120);
				
		g.setFont(fnt1);
				
		g2d.setColor(new Color(24, 165, 255)); //PRIMERO FILL, LUEGO DIBUJAR, SE TIENE QUE RESPETAR EL ORDEN
		g2d.fill(botonJugar);				
		g2d.setColor(Color.black);
		g2d.draw(botonJugar);
		g.drawString("Jugar", botonJugar.x+210, botonJugar.y+35);		
		
		g2d.setColor(new Color(24, 165, 255));
		g2d.fill(botonSalir);		
		g2d.setColor(Color.black);
		g2d.draw(botonSalir);
		g.drawString("Salir", botonSalir.x+210, botonSalir.y+35);							
		
	}

	
}
