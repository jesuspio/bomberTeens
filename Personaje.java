package prueba;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Personaje {
	boolean banderaMovimiento = false;

	final int TAMANOCOLISIONALTO = 60;
	final int TAMANOCOLISIONANCHO = 40;

	int velX = 0;
	int velY = 0;

	int bloquesAlto;
	int bloquesBajo;
        
	int cantBombas = 1;
	int power = 1;
	private int caso;
	int initialsize = 20;
	int initialsizeVertical = 20;

	int bloqueVertical;
	int bloqueVertical2;

	// COORDENADAS PLAYER
	private int x;
	private int y;
	private int w = 1200; // COLISION POR DEFECTO
	private int z = 800; // COLISION POR DEFECTO
	// FIN COORDENADAS PLAYER

	private Dibujar obj;
	Bomba b = new Bomba();
        Bomba b2 = new Bomba();
	BufferedImage aux;
	BufferedImage auxB;
	BufferedImage i0;
	BufferedImage i1;
	BufferedImage i2;
	BufferedImage i3;
	BufferedImage i4;
	BufferedImage i5;
	BufferedImage i6;
	BufferedImage i7;
	BufferedImage muerte;
	BufferedImage b1;
	BufferedImage e;
	BufferedImage e2;
	BufferedImage e3;
	private int[][] matriz = new int[11][11];

	private final int ANCHO = 100;
	private final int ALTO = 100;

	public Personaje(Dibujar obj, Bomba b,Bomba b2,  int caso, int matriz[][]) {
		this.obj = obj;
		this.b = b;
                this.b2 = b2;
		try {
			if (caso == 1) {
				this.x = 10;
				this.y = 25;
				this.caso = caso;
				this.i0 = ImageIO.read(new FileInputStream("resources/Mono1.png"));
				this.i1 = ImageIO.read(new FileInputStream("resources/Mono2.png"));
				this.i2 = ImageIO.read(new FileInputStream("resources/Mono1Izq.png"));
				this.i3 = ImageIO.read(new FileInputStream("resources/Mono2Izq.png"));
				this.i4 = ImageIO.read(new FileInputStream("resources/Mono1Ar.png"));
				this.i5 = ImageIO.read(new FileInputStream("resources/Mono2Ar.png"));
				this.i6 = ImageIO.read(new FileInputStream("resources/Mono1Ab.png"));
				this.i7 = ImageIO.read(new FileInputStream("resources/Mono2Ab.png"));
				this.muerte = ImageIO.read(new FileInputStream("resources/MonoMuerte.png"));
				this.aux = ImageIO.read(new FileInputStream("resources/Mono1.png"));// IMG
																					// INICIAL
																					// DEL
																					// BLANCO
			} else {
				this.x = 1100;
				this.y = 520;
				this.caso = caso;
				this.i0 = ImageIO.read(new FileInputStream("resources/Negro1.png"));
				this.i1 = ImageIO.read(new FileInputStream("resources/Negro2.png"));
				this.i2 = ImageIO.read(new FileInputStream("resources/Negro1Izq.png"));
				this.i3 = ImageIO.read(new FileInputStream("resources/Negro2Izq.png"));
				this.i4 = ImageIO.read(new FileInputStream("resources/Negro1Ar.png"));
				this.i5 = ImageIO.read(new FileInputStream("resources/Negro2Ar.png"));
				this.i6 = ImageIO.read(new FileInputStream("resources/Negro1Ab.png"));
				this.i7 = ImageIO.read(new FileInputStream("resources/Negro2Ab.png"));
				this.muerte = ImageIO.read(new FileInputStream("resources/NegroMuerte.png"));
				this.aux = ImageIO.read(new FileInputStream("resources/Negro1Izq.png"));// IMG
				// INICIAL
				// DE
				// NEGRO
			}
			///////////////////////// BOMBA//////////////////////////////////
			this.b1 = ImageIO.read(new FileInputStream("resources/Bomb.png"));
			this.auxB = ImageIO.read(new FileInputStream("resources/Bomb.png"));
			this.e = ImageIO.read(new FileInputStream("resources/exp1.png"));
			this.e2 = ImageIO.read(new FileInputStream("resources/exp2.png"));
			this.e3 = ImageIO.read(new FileInputStream("resources/exp3.png"));

			this.matriz = matriz;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void move() {
		if (x > obj.getWidth() - ANCHO)
			x = obj.getWidth() - ANCHO;
		if (x < 0)
			x = 0;
		if (y > obj.getHeight() - ALTO)
			y = obj.getHeight() - ALTO;
		if (y < 0)
			y = 0;
		bloquesHorizontal();
		bloquesVertical();
		bloquesRandom();
	}

	public void bloquesRandom() {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (matriz[i][j] == 2) {
					if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 0 && y == 0) {
						x = (initialsize) + (110 * j + 1) - 110;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 0 && y == 0) {
						x = (initialsize) + (110 * j + 1) + 80;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 1 && y >= 10 && y <= 50) {
						x = (initialsize) + (110 * j + 1) - 110;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 1 && y >= 10 && y <= 50) {
						x = (initialsize) + (110 * j + 1) + 80;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 2 && y >= 65 && y <= 95) {
						x = (initialsize) + (110 * j + 1) - 110;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 2 && y >= 65 && y <= 95) {
						x = (initialsize) + (110 * j + 1) + 80;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 3 && y >= 115 && y <= 155) {
						x = (initialsize) + (110 * j + 1) - 110;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 3 && y >= 115 && y <= 155) {
						x = (initialsize) + (110 * j + 1) + 80;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 4 && y >= 150 && y <= 205) {
						x = (initialsize) + (110 * j + 1) - 110;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 4 && y >= 150 && y <= 205) {
						x = (initialsize) + (110 * j + 1) + 80;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 5 && y >= 225 && y <= 275) {
						x = (initialsize) + (110 * j + 1) - 110;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 5 && y >= 225 && y <= 275) {
						x = (initialsize) + (110 * j + 1) + 80;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 6 && y >= 280 && y <= 330) {
						x = (initialsize) + (110 * j + 1) - 110;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 6 && y >= 280 && y <= 330) {
						x = (initialsize) + (110 * j + 1) + 80;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 7 && y >= 335 && y <= 385) {
						x = (initialsize) + (110 * j + 1) - 110;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 7 && y >= 335 && y <= 385) {
						x = (initialsize) + (110 * j + 1) + 80;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 8 && y >= 390 && y <= 425) {
						x = (initialsize) + (110 * j + 1) - 110;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 8 && y >= 390 && y <= 425) {
						x = (initialsize) + (110 * j + 1) + 80;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 9 && y >= 435 && y <= 475) {
						x = (initialsize) + (110 * j + 1) - 110;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 9 && y >= 435 && y <= 475) {
						x = (initialsize) + (110 * j + 1) + 80;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 10 && y >= 500 && y <= 570) {
						x = (initialsize) + (110 * j + 1) - 110;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 10 && y >= 500 && y <= 570) {
						x = (initialsize) + (110 * j + 1) + 80;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 0 && x >= 0 && x<=40) {
						y = (initialsize) + (55 * i + 1) + 50 - 55;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 1 && x >=100 && x<130) {
						y = (initialsize) + (55 * i + 1) + 50 - 55;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 2 && x >=210 && x<250) {
						y = (initialsize) + (55 * i + 1) + 50 - 55;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 3 && x >=290 && x<370) {
						y = (initialsize) + (55 * i + 1) + 50 - 55;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 4 && x >=390 && x<480) {
						y = (initialsize) + (55 * i + 1) + 50 - 55;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 5 && x >=510 && x<600) {
						y = (initialsize) + (55 * i + 1) + 50 - 55;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 6 && x >=610 && x<710) {
						y = (initialsize) + (55 * i + 1) + 50 - 55;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 7 && x >= 720 && x<820) {
						y = (initialsize) + (55 * i + 1) + 50 - 55;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 8 && x >=830 && x<930) {
						y = (initialsize) + (55 * i + 1) + 50 - 55;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 9 && x >=930 && x<1030) {
						y = (initialsize) + (55 * i + 1) + 50 - 55;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 10 && x >=1030 && x<1130) {
						y = (initialsize) + (55 * i + 1) + 50 - 55;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 0 &&  x >= 0 && x<=40) {
						y = (initialsize) + (55 * i + 1) - 100;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 1 &&  x >=100 && x<130) {
						y = (initialsize) + (55 * i + 1) - 100;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 2 &&  x >=210 && x<250) {
						y = (initialsize) + (55 * i + 1) - 100;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 3 &&  x >=290 && x<370) {
						y = (initialsize) + (55 * i + 1) - 100;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 4 &&  x >=390 && x<480) {
						y = (initialsize) + (55 * i + 1) - 100;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 5 &&  x >=510 && x<600) {
						y = (initialsize) + (55 * i + 1) - 100;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 6 &&  x >=610 && x<710) {
						y = (initialsize) + (55 * i + 1) - 100;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 7 &&  x >= 720 && x<820) {
						y = (initialsize) + (55 * i + 1) - 100;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 8 &&  x >=830 && x<930) {
						y = (initialsize) + (55 * i + 1) - 100;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 9 &&  x >=930 && x<1030) {
						y = (initialsize) + (55 * i + 1) - 100;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 10 &&   x >=1030 && x<1130) {
						y = (initialsize) + (55 * i + 1) - 100;
					}
				}
				
				if (matriz[i][j] == 3) {
					if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 0 && y == 0) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 0 && y == 0) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 1 && y >= 10 && y <= 50) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 1 && y >= 10 && y <= 50) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 2 && y >= 65 && y <= 95) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 2 && y >= 65 && y <= 95) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 3 && y >= 115 && y <= 155) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 3 && y >= 115 && y <= 155) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 4 && y >= 150 && y <= 205) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 4 && y >= 150 && y <= 205) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 5 && y >= 225 && y <= 275) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 5 && y >= 225 && y <= 275) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 6 && y >= 280 && y <= 330) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 6 && y >= 280 && y <= 330) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 7 && y >= 335 && y <= 385) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 7 && y >= 335 && y <= 385) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 8 && y >= 390 && y <= 425) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 8 && y >= 390 && y <= 425) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 9 && y >= 435 && y <= 475) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 9 && y >= 435 && y <= 475) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
							&& i == 10 && y >= 500 && y <= 570) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
							&& i == 10 && y >= 500 && y <= 570) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 0 && x >= 0 && x<=40) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 1 && x >=100 && x<130) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 2 && x >=210 && x<250) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 3 && x >=290 && x<370) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 4 && x >=390 && x<480) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 5 && x >=510 && x<600) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 6 && x >=610 && x<710) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 7 && x >= 720 && x<820) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 8 && x >=830 && x<930) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 9 && x >=930 && x<1030) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
							&& j == 10 && x >=1030 && x<1130) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 0 &&  x >= 0 && x<=40) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 1 &&  x >=100 && x<130) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 2 &&  x >=210 && x<250) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 3 &&  x >=290 && x<370) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 4 &&  x >=390 && x<480) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 5 &&  x >=510 && x<600) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 6 &&  x >=610 && x<710) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 7 &&  x >= 720 && x<820) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 8 &&  x >=830 && x<930) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 9 &&  x >=930 && x<1030) {
						matriz[i][j]=0;
						this.cantBombas=2;
					} else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
							&& j == 10 &&   x >=1030 && x<1130) {
						matriz[i][j]=0;
						this.cantBombas=2;
					}
				}
				
			}
		}
	}

	public void bloquesVertical() {
		// System.out.println("X: " + x + " Caso: " + caso);
		// System.out.println("Y: " + y + " Caso: " + caso);

		// INICIO PRIMER RENGLON
		// BLOQUE 1
		bloqueVertical = 36;
		bloqueVertical2 = 180;
		if (y > 0 && y < 15 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 0;
		if (y < 65 && y > 50 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 65;
		// BLOQUE 2
		bloqueVertical = 251;
		bloqueVertical2 = 391;

		if (y > 0 && y < 15 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 0;
		if (y < 65 && y > 50 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 65;

		// BLOQUE 3
		bloqueVertical = 471;
		bloqueVertical2 = 611;

		if (y > 0 && y < 15 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 0;
		if (y < 65 && y > 50 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 65;

		// BLOQUE 4
		bloqueVertical = 681;
		bloqueVertical2 = 831;

		if (y > 0 && y < 15 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 0;
		if (y < 65 && y > 50 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 65;

		// BLOQUE 5
		bloqueVertical = 901;
		bloqueVertical2 = 1056;

		if (y > 0 && y < 15 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 0;
		if (y < 65 && y > 50 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 65;
		// FIN PRIMER RENGLON

		// INICIO SEGUNDO RENGLON
		// BLOQUE 1
		bloqueVertical = 36;
		bloqueVertical2 = 180;
		if (y >= 95 && y <= 105 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 95;
		if (y <= 175 && y > 160 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 175;
		// BLOQUE 2
		bloqueVertical = 251;
		bloqueVertical2 = 391;

		if (y >= 95 && y <= 105 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 95;
		if (y <= 175 && y > 160 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 175;

		// BLOQUE 3
		bloqueVertical = 471;
		bloqueVertical2 = 611;

		if (y >= 95 && y <= 105 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 95;
		if (y <= 175 && y > 160 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 175;

		// BLOQUE 4
		bloqueVertical = 681;
		bloqueVertical2 = 831;

		if (y >= 95 && y <= 105 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 95;
		if (y <= 175 && y > 160 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 175;

		// BLOQUE 5
		bloqueVertical = 901;
		bloqueVertical2 = 1056;

		if (y >= 95 && y <= 105 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 95;
		if (y <= 175 && y > 160 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 175;
		// FIN SEGUNDO RENGLON

		// INICIO TERCER RENGLON
		// BLOQUE 1
		bloqueVertical = 36;
		bloqueVertical2 = 180;
		if (y >= 205 && y <= 220 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 205;
		if (y <= 285 && y > 270 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 285;
		// BLOQUE 2
		bloqueVertical = 251;
		bloqueVertical2 = 391;

		if (y >= 205 && y <= 220 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 205;
		if (y <= 285 && y > 270 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 285;

		// BLOQUE 3
		bloqueVertical = 471;
		bloqueVertical2 = 611;

		if (y >= 205 && y <= 220 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 205;
		if (y <= 285 && y > 270 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 285;

		// BLOQUE 4
		bloqueVertical = 681;
		bloqueVertical2 = 831;

		if (y >= 205 && y <= 220 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 205;
		if (y <= 285 && y > 270 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 285;

		// BLOQUE 5
		bloqueVertical = 901;
		bloqueVertical2 = 1056;

		if (y >= 205 && y <= 220 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 205;
		if (y <= 285 && y > 270 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 285;
		// FIN TERCER RENGLON

		// INICIO CUARTO RENGLON
		// BLOQUE 1
		bloqueVertical = 36;
		bloqueVertical2 = 180;
		if (y >= 305 && y <= 320 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 305;
		if (y <= 395 && y > 380 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 395;
		// BLOQUE 2
		bloqueVertical = 251;
		bloqueVertical2 = 391;

		if (y >= 305 && y <= 320 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 305;
		if (y <= 395 && y > 380 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 395;

		// BLOQUE 3
		bloqueVertical = 471;
		bloqueVertical2 = 611;

		if (y >= 305 && y <= 320 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 305;
		if (y <= 395 && y > 380 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 395;

		// BLOQUE 4
		bloqueVertical = 681;
		bloqueVertical2 = 831;

		if (y >= 305 && y <= 320 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 305;
		if (y <= 395 && y > 380 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 395;

		// BLOQUE 5
		bloqueVertical = 901;
		bloqueVertical2 = 1056;

		if (y >= 305 && y <= 320 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 305;
		if (y <= 395 && y > 380 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 395;
		// FIN CUARTO RENGLON

		// INICIO QUINTO RENGLON
		// BLOQUE 1
		bloqueVertical = 36;
		bloqueVertical2 = 180;
		if (y >= 425 && y <= 440 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 425;
		if (y <= 505 && y > 490 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 505;
		// BLOQUE 2
		bloqueVertical = 251;
		bloqueVertical2 = 391;

		if (y >= 425 && y <= 440 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 425;
		if (y <= 505 && y > 490 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 505;

		// BLOQUE 3
		bloqueVertical = 471;
		bloqueVertical2 = 611;

		if (y >= 425 && y <= 440 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 425;
		if (y <= 505 && y > 490 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 505;

		// BLOQUE 4
		bloqueVertical = 681;
		bloqueVertical2 = 831;

		if (y >= 425 && y <= 440 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 425;
		if (y <= 505 && y > 490 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 505;

		// BLOQUE 5
		bloqueVertical = 901;
		bloqueVertical2 = 1056;

		if (y >= 425 && y <= 440 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 425;
		if (y <= 505 && y > 490 && x >= bloqueVertical && x <= bloqueVertical2)
			y = 505;
		// FIN QUINTO RENGLON
	}

	// SE TIENE QUE UTILIZAR UN RADIO DE 10-15 PARA LAS X
	public void bloquesHorizontal() {
		bloquesAlto = 1;
		bloquesBajo = 70;
		// INICIO PRIMER RENGLON
		// BLOQUE 1
		if (x >= 21 && x <= 36 && y > bloquesAlto && y < bloquesBajo)
			x = 21;
		if (x >= 190 && x <= 205 && y > bloquesAlto && y < bloquesBajo)
			x = 205;
		// BLOQUE 2
		if (x >= 241 && x <= 256 && y > bloquesAlto && y < bloquesBajo)
			x = 241;
		if (x >= 410 && x <= 425 && y > bloquesAlto && y < bloquesBajo)
			x = 425;
		// BLOQUE 3
		if (x >= 455 && x <= 470 && y > bloquesAlto && y < bloquesBajo)
			x = 455;
		if (x >= 626 && x <= 641 && y > bloquesAlto && y < bloquesBajo)
			x = 641;
		// BLOQUE 4
		if (x >= 671 && x <= 686 && y > bloquesAlto && y < bloquesBajo)
			x = 671;
		if (x >= 846 && x <= 861 && y > bloquesAlto && y < bloquesBajo)
			x = 861;
		// BLOQUE 5
		if (x >= 891 && x <= 906 && y > bloquesAlto && y < bloquesBajo)
			x = 891;
		if (x >= 1065 && x <= 1080 && y > bloquesAlto && y < bloquesBajo)
			x = 1081;
		// FIN PRIMERA RENGLON

		bloquesAlto = 95;
		bloquesBajo = 175;

		// INICIO SEGUNDO RENGLON
		// BLOQUE 1
		if (x >= 21 && x <= 36 && y > bloquesAlto && y < bloquesBajo)
			x = 21;
		if (x >= 190 && x <= 205 && y > bloquesAlto && y < bloquesBajo)
			x = 205;
		// BLOQUE 2
		if (x >= 241 && x <= 255 && y > bloquesAlto && y < bloquesBajo)
			x = 241;
		if (x >= 410 && x <= 425 && y > bloquesAlto && y < bloquesBajo)
			x = 425;
		// BLOQUE 3
		if (x >= 455 && x <= 470 && y > bloquesAlto && y < bloquesBajo)
			x = 455;
		if (x >= 626 && x <= 641 && y > bloquesAlto && y < bloquesBajo)
			x = 641;
		// BLOQUE 4
		if (x >= 671 && x <= 686 && y > bloquesAlto && y < bloquesBajo)
			x = 671;
		if (x >= 846 && x <= 861 && y > bloquesAlto && y < bloquesBajo)
			x = 861;
		// BLOQUE 5
		if (x >= 891 && x <= 906 && y > bloquesAlto && y < bloquesBajo)
			x = 891;
		if (x >= 1065 && x <= 1081 && y > bloquesAlto && y < bloquesBajo)
			x = 1081;
		// FIN SEGUNDO RENGLON

		bloquesAlto = 205;
		bloquesBajo = 285;

		// INICIO TERCER RENGLON
		// BLOQUE 1
		if (x >= 21 && x <= 35 && y > bloquesAlto && y < bloquesBajo)
			x = 21;
		if (x >= 190 && x <= 205 && y > bloquesAlto && y < bloquesBajo)
			x = 205;
		// BLOQUE 2
		if (x >= 241 && x <= 255 && y > bloquesAlto && y < bloquesBajo)
			x = 241;
		if (x >= 410 && x <= 425 && y > bloquesAlto && y < bloquesBajo)
			x = 425;
		// BLOQUE 3
		if (x >= 455 && x <= 470 && y > bloquesAlto && y < bloquesBajo)
			x = 455;
		if (x >= 626 && x <= 641 && y > bloquesAlto && y < bloquesBajo)
			x = 641;
		// BLOQUE 4
		if (x >= 671 && x <= 686 && y > bloquesAlto && y < bloquesBajo)
			x = 671;
		if (x >= 846 && x <= 861 && y > bloquesAlto && y < bloquesBajo)
			x = 861;
		// BLOQUE 5
		if (x >= 891 && x <= 906 && y > bloquesAlto && y < bloquesBajo)
			x = 891;
		if (x >= 1065 && x <= 1081 && y > bloquesAlto && y < bloquesBajo)
			x = 1081;
		// FIN TERCER RENGLON

		bloquesAlto = 305;
		bloquesBajo = 395;

		// INICIO CUARTO RENGLON
		// BLOQUE 1
		if (x >= 21 && x <= 35 && y > bloquesAlto && y < bloquesBajo)
			x = 21;
		if (x >= 190 && x <= 205 && y > bloquesAlto && y < bloquesBajo)
			x = 205;
		// BLOQUE 2
		if (x >= 241 && x <= 255 && y > bloquesAlto && y < bloquesBajo)
			x = 241;
		if (x >= 410 && x <= 425 && y > bloquesAlto && y < bloquesBajo)
			x = 425;
		// BLOQUE 3
		if (x >= 455 && x <= 470 && y > bloquesAlto && y < bloquesBajo)
			x = 455;
		if (x >= 626 && x <= 641 && y > bloquesAlto && y < bloquesBajo)
			x = 641;
		// BLOQUE 4
		if (x >= 671 && x <= 686 && y > bloquesAlto && y < bloquesBajo)
			x = 671;
		if (x >= 846 && x <= 861 && y > bloquesAlto && y < bloquesBajo)
			x = 861;
		// BLOQUE 5
		if (x >= 891 && x <= 906 && y > bloquesAlto && y < bloquesBajo)
			x = 891;
		if (x >= 1065 && x <= 1081 && y > bloquesAlto && y < bloquesBajo)
			x = 1081;
		// FIN CUARTO RENGLON

		bloquesAlto = 415;
		bloquesBajo = 505;

		// INICIO QUINTO RENGLON
		// BLOQUE 1
		if (x >= 21 && x <= 35 && y > bloquesAlto && y < bloquesBajo)
			x = 21;
		if (x >= 190 && x <= 205 && y > bloquesAlto && y < bloquesBajo)
			x = 205;
		// BLOQUE 2
		if (x >= 241 && x <= 255 && y > bloquesAlto && y < bloquesBajo)
			x = 241;
		if (x >= 410 && x <= 425 && y > bloquesAlto && y < bloquesBajo)
			x = 425;
		// BLOQUE 3
		if (x >= 455 && x <= 470 && y > bloquesAlto && y < bloquesBajo)
			x = 455;
		if (x >= 626 && x <= 641 && y > bloquesAlto && y < bloquesBajo)
			x = 641;
		// BLOQUE 4
		if (x >= 671 && x <= 686 && y > bloquesAlto && y < bloquesBajo)
			x = 671;
		if (x >= 846 && x <= 861 && y > bloquesAlto && y < bloquesBajo)
			x = 861;
		// BLOQUE 5
		if (x >= 891 && x <= 906 && y > bloquesAlto && y < bloquesBajo)
			x = 891;
		if (x >= 1065 && x <= 1081 && y > bloquesAlto && y < bloquesBajo)
			x = 1081;
		// FIN QUINTO RENGLON

	}

	public void caminarDerecha() {
		if (aux == i0) {
			aux = i1;
		} else {
			aux = i0;
		}
	}

	public void caminarIzquierda() {
		if (aux == i2) {
			aux = i3;
		} else {
			aux = i2;
		}
	}

	public void caminarArriba() {
		if (aux == i4) {
			aux = i5;
		} else {
			aux = i4;
		}
	}

	public void caminarAbajo() {
		if (aux == i6) {
			aux = i7;
		} else {
			aux = i6;
		}
	}

	public void setMuerte() {
		aux = muerte;
	}

	public void ponerBomba(Boolean bomba) {
		auxB = b1;
	}

	public void paint(Graphics g) {
		g.drawImage(aux, x, y, 100, 100, null);
	}

	public BufferedImage getAuxB() {
		return auxB;
	}

	public void setAuxB(BufferedImage auxB) {
		this.auxB = auxB;
	}

	public void updateX() {
		x += velX;
	}

	public void updateY() {
		y += velY;
	}
	////////////////////////////////////////// CONTROLES DEL PRIMER
	////////////////////////////////////////// PLAYER/////////////////////////////////////////////

	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_D) {
			if (!colision(1)) {
				velX = 10;
				caminarDerecha();
				banderaMovimiento = false;
			} else {
				velX = 0;
			}
		}
		if (ke.getKeyCode() == KeyEvent.VK_A) {
			if (!colision(2)) {
				velX = -10;
				caminarIzquierda();
				banderaMovimiento = false;
			} else {
				velX = 0;
			}
		}
		if (ke.getKeyCode() == KeyEvent.VK_W) {
			if (!colision(4)) {
				velY = -10;
				caminarArriba();
				banderaMovimiento = true;
			} else {
				velY = 0;
			}

		}
		if (ke.getKeyCode() == KeyEvent.VK_S) {
			if (!colision(3)) {
				velY = 10;
				caminarAbajo();
				banderaMovimiento = true;
			} else {
				velY = 0;
			}
		}
	}

	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_D) {
			velX = 0;
			caminarDerecha();
			banderaMovimiento = true;
		}
		if (ke.getKeyCode() == KeyEvent.VK_A) {
			velX = 0;
			caminarIzquierda();
			banderaMovimiento = true;
		}
		if (ke.getKeyCode() == KeyEvent.VK_W) {
			velY = 0;
			caminarArriba();
			banderaMovimiento = false;
		}
		if (ke.getKeyCode() == KeyEvent.VK_S) {
			velY = 0;
			caminarAbajo();
			banderaMovimiento = false;
		}

	}

	////////////////////////////////////////// CONTROLES DEL SEGUNDO
	////////////////////////////////////////// PLAYER/////////////////////////////////////////////
	public void keyPressed2(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (!colision(1)) {
				velX = 10;
				caminarDerecha();
				banderaMovimiento = false;
			} else {
				velX = 0;
			}
		}
		if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			if (!colision(2)) {
				velX = -10;
				caminarIzquierda();
				banderaMovimiento = false;
			} else {
				velX = 0;
			}
		}
		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			if (!colision(4)) {
				velY = -10;
				caminarArriba();
				banderaMovimiento = true;
			} else {
				velY = 0;
			}
		}
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			if (!colision(3)) {
				velY = 10;
				caminarAbajo();
				banderaMovimiento = true;
			} else {
				velY = 0;
			}
		}
	}

    public int getCantBombas() {
        return cantBombas;
    }

    public void setCantBombas(int cantBombas) {
        this.cantBombas = cantBombas;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

	public void keyReleased2(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			velX = 0;
			caminarDerecha();
			banderaMovimiento = true;
		}
		if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			velX = 0;
			caminarIzquierda();
			banderaMovimiento = true;
		}
		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			velY = 0;
			caminarArriba();
			banderaMovimiento = false;
		}
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			velY = 0;
			caminarAbajo();
			banderaMovimiento = false;
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////

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

	public int getW() {
		return w;
	}

	public int getZ() {
		return z;
	}

	public void setW(int w) {
		this.w = w;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public boolean isBanderaMovimiento() {
		return banderaMovimiento;
	}

	public void setBanderaMovimiento(boolean banderaMovimiento) {
		this.banderaMovimiento = banderaMovimiento;
	}

	public BufferedImage getE() {
		return e;
	}

	public void setE(BufferedImage e) {
		this.e = e;
	}

	public BufferedImage getE2() {
		return e2;
	}

	public void setE2(BufferedImage e2) {
		this.e2 = e2;
	}

	public BufferedImage getE3() {
		return e3;
	}

	public void setE3(BufferedImage e3) {
		this.e3 = e3;
	}

	public boolean colision(int caso) {
		boolean collide = false;

		/**
		 * CASE 1 = COLISION LADO IZQUIERDO CASE 2 = COLISION LADO DERECHO CASE
		 * 3 = COLISION ARRIBA CASE 4 = COLISION ABAJO
		 */

		switch (caso) {
		case 1:
			if (x < w && x > w - 110 && y < z + TAMANOCOLISIONALTO && y > z - TAMANOCOLISIONALTO) {
				collide = true;
			}
			break;

		case 2:
			if (x < w + 110 && x > w && y < z + TAMANOCOLISIONALTO && y > z - TAMANOCOLISIONALTO) {
				collide = true;
			}
			break;

		case 3:
			if (y > z - 110 && y < z && x < w + TAMANOCOLISIONANCHO && x > w - TAMANOCOLISIONANCHO) {
				collide = true;
			}
			break;

		case 4:
			if (y < z + 110 && y > z && x < w + TAMANOCOLISIONANCHO && x > w - TAMANOCOLISIONANCHO) {
				collide = true;
			}
			break;
		}
		return collide;
	}

}