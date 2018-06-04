package prueba;

import java.awt.Color;
import java.awt.Graphics;

public class Mapa {

	Dibujar obj;
	private int[][] matriz = new int[11][11];

	public Mapa(Dibujar obj) {
		this.obj = obj;
		// DETERMINAR BLOQUES DE COLISIONES
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (i % 2 == 0) { // EVALUA BLOQUES LIBRES, POR ESO FUNCIONA AL
									// PONER LA CONDICION EN SEGUIDA
					if (Math.floor(Math.random() * 3 + 1) > 1) {
						matriz[i][j] = 2;
					} else {
						matriz[i][j] = 0;
					}
				} else if (!(j % 2 == 0)) {
					matriz[i][j] = 1; // BLOQUE SOLIDO, NO SE PONE EN EL RANDOM
										// PORQUE NUNCA DEJA DE SER SOLIDO
				} else if (Math.floor(Math.random() * 3 + 1) > 1) { // DETERMINAR
																	// RANDOM
																	// DE
																	// LOS
																	// BLOQUES
																	// LIBRES
																	// 0
					matriz[i][j] = 2;
				} else {
					matriz[i][j] = 0;
				}
			}
		}
		
		/// SE LIMPIAN ESQUINAS DE AMBOS JUGADORES //
		matriz[0][0] = 0;
		matriz[1][0] = 0;
		matriz[2][0] = 0;
		matriz[0][1] = 0;
		matriz[0][2] = 0;

		matriz[10][10] = 0;
		matriz[10][9] = 0;
		matriz[10][8] = 0;
		matriz[9][10] = 0;
		matriz[8][10] = 0;

		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	final int HORIZONTAL = 1200 / 11;
	final int VERTICAL = 600 / 11;
	private int x = 0;
	private int y = 0;

	public void paint(Graphics g) {
		for (int i = 0; i < 1200; i += HORIZONTAL) {
			for (int j = 30; j < 600; j += VERTICAL) {
				if (matriz[y][x] == 0 || matriz[y][x] == 2 || matriz[y][x]==3) { /// BLOQUES LIBRES
					g.setColor(new Color(25, 161, 45));
					g.fillRect(i, j, 109, 54);
					if (matriz[y][x] == 2) { /// BLOQUES DESTRUIBLES
						g.setColor(new Color(118, 60, 40)); // dark
						g.fillRect(i, j, 109, 54);
						g.setColor(new Color(166, 94, 46)); // light
						g.fillRect(i, j, 105, 50);
						g.setColor(new Color(117, 92, 72)); // normal
						g.fillRect(i + 4, j + 4, 101, 46);

						g.setColor(new Color(118, 60, 40)); // DIVISION 1
						g.fillRect(i + 4, j + 16, 101, 4);
						g.setColor(new Color(118, 60, 40)); // DIVISION 2
						g.fillRect(i + 4, j + 36, 101, 4);
						g.setColor(new Color(118, 60, 40)); // MINI DIVISION 1
															// EN BARRA 1
						g.fillRect(i + 54, j + 4, 4, 16);
						g.setColor(new Color(118, 60, 40)); // MINI DIVISION 1
															// EN BARRA 2
						g.fillRect(i + 25, j + 20, 4, 16);
						g.setColor(new Color(118, 60, 40)); // MINI DIVISION 2
															// EN BARRA 2
						g.fillRect(i + 80, j + 20, 4, 16);
						g.setColor(new Color(118, 60, 40)); // MINI DIVISION 1
															// EN BARRA 3
						g.fillRect(i + 54, j + 36, 4, 16);

					}
					if(matriz[y][x]==3){
						g.setColor(Color.PINK);
						g.fillRect(i, j, 109, 54);
						g.setColor(Color.PINK);
						g.fillRect(i, j, 104, 49);
						g.setColor(Color.PINK);
						g.fillRect(i + 4, j + 4, 100, 45);
					}
				} else { /// BLOQUES SOLIDOS
					g.setColor(Color.BLACK);
					g.fillRect(i, j, 109, 54);
					g.setColor(Color.LIGHT_GRAY);
					g.fillRect(i, j, 104, 49);
					g.setColor(Color.GRAY);
					g.fillRect(i + 4, j + 4, 100, 45);
				}
				y++;
			}
			x++;
			if (x == 11) {
				x = 0;
			}
			if (y == 11) {
				y = 0;
			}
		}
		x = 0;
	}
}
