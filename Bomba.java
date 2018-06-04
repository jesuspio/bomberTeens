package prueba;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bomba extends Thread {

    boolean bandera = true;
    boolean banE = false;
    Thread thread2;
    private int initialsize = 20;
    private int matriz[][];
    int w;
    int z;
    BufferedImage b1;
    BufferedImage exp;
    BufferedImage exp2;
    BufferedImage exp3;
    BufferedImage exp4;
    BufferedImage exp5;

    boolean solido = true;

    public int getW() {
        return w;
    }

    public int getZ() {
        return z;
    }

    public void ponerBomba(BufferedImage aux2, BufferedImage exp, BufferedImage exp2, BufferedImage exp3, int w,
            int z, int matriz[][]) {
        this.matriz = matriz;
        this.b1 = aux2;
        this.w = w;
        this.z = z;
        this.exp = exp;
        this.exp2 = exp3;// verticales
        this.exp3 = exp3;
        this.exp4 = exp2;// horizontales
        this.exp5 = exp2;

        thread2 = new Thread();
    }

    public Boolean getBandera() {
        return bandera;
    }

    public void setBandera(Boolean bandera) {
        this.bandera = bandera;
    }

    public boolean isBanE() {
        return banE;
    }

    public void setBanE(boolean banE) {
        this.banE = banE;
    }

    public void collide() {
    	//COORDENADAS BOMBA
        int x = w;
        int y = z;
        for(int n=0;n<4;n++){
        	if(n==0){
        		//DERECHA
        		x = w+90;
                y = z;
        	} else if(n==1){
        		//IZQUIERDA
        		x = w-70;
                y = z;
        	} else if(n==2){
        		//ABAJO
        		x = w;
                y = z+70;
        	} else if(n==3){
        		//ARRIBA
        		x = w;
                y = z-70;
        	}
        	
	        for (int i = 0; i < 11; i++) {
	            for (int j = 0; j < 11; j++) {
	                if (matriz[i][j] == 2) {
	                    if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
	                            && i == 0 && y == 0) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
	                            && i == 0 && y == 0) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
	                            && i == 1 && y >= 10 && y <= 50) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
	                            && i == 1 && y >= 10 && y <= 50) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
	                            && i == 2 && y >= 65 && y <= 95) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
	                            && i == 2 && y >= 65 && y <= 95) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
	                            && i == 3 && y >= 115 && y <= 155) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
	                            && i == 3 && y >= 115 && y <= 155) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
	                            && i == 4 && y >= 150 && y <= 205) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
	                            && i == 4 && y >= 150 && y <= 205) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
	                            && i == 5 && y >= 225 && y <= 275) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
	                            && i == 5 && y >= 225 && y <= 275) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
	                            && i == 6 && y >= 280 && y <= 330) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
	                            && i == 6 && y >= 280 && y <= 330) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
	                            && i == 7 && y >= 335 && y <= 385) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
	                            && i == 7 && y >= 335 && y <= 385) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
	                            && i == 8 && y >= 390 && y <= 425) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
	                            && i == 8 && y >= 390 && y <= 425) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
	                            && i == 9 && y >= 435 && y <= 475) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
	                            && i == 9 && y >= 435 && y <= 475) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) - 110 && x < (initialsize + (110 * j + 1)) + 20 - 110
	                            && i == 10 && y >= 500 && y <= 570) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (x > (initialsize) + (110 * j + 1) + 60 && x < (initialsize + (110 * j + 1)) + 80
	                            && i == 10 && y >= 500 && y <= 570) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
	                            && j == 0 && x >= 0 && x <= 40) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
	                            && j == 1 && x >= 100 && x < 130) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
	                            && j == 2 && x >= 210 && x < 250) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
	                            && j == 3 && x >= 290 && x < 370) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
	                            && j == 4 && x >= 390 && x < 480) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
	                            && j == 5 && x >= 510 && x < 600) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
	                            && j == 6 && x >= 610 && x < 710) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
	                            && j == 7 && x >= 720 && x < 820) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
	                            && j == 8 && x >= 830 && x < 930) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
	                            && j == 9 && x >= 930 && x < 1030) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 55 && y < (initialsize + (55 * i + 1)) + 50 - 55
	                            && j == 10 && x >= 1030 && x < 1130) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
	                            && j == 0 && x >= 0 && x <= 40) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
	                            && j == 1 && x >= 100 && x < 130) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
	                            && j == 2 && x >= 210 && x < 250) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
	                            && j == 3 && x >= 290 && x < 370) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
	                            && j == 4 && x >= 390 && x < 480) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
	                            && j == 5 && x >= 510 && x < 600) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
	                            && j == 6 && x >= 610 && x < 710) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
	                            && j == 7 && x >= 720 && x < 820) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
	                            && j == 8 && x >= 830 && x < 930) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
	                            && j == 9 && x >= 930 && x < 1030) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    } else if (y > (initialsize) + (55 * i + 1) - 100 && y < (initialsize + (55 * i + 1)) + 50 - 100
	                            && j == 10 && x >= 1030 && x < 1130) {
	                        System.out.println("EXPLOTA BLOQUE");
	                        matriz[i][j] = 0;
	                        if (Math.floor(Math.random() * 3 + 1) == 3) {
	                        	matriz[i][j] = 3;
	                        }
	                    }
	                }
	            }
	        }
        }
    }

    public void paint(Graphics g) {
        if (bandera == true) {
            g.drawImage(b1, w + 15, z + 20, 70, 70, null);
        } else {
            g.drawImage(null, w + 15, z + 15, 70, 70, null);
        }
        if (banE == true) {
            g.drawImage(exp2, w + 15, z + 15 + 70, 70, 70, null);
            g.drawImage(exp3, w + 15, z + 15 - 70, 70, 70, null);
            g.drawImage(exp4, w + 15 + 60, z + 25, 130, 50, null);
            g.drawImage(exp5, w + 15 - 120, z + 25, 130, 50, null);
            g.drawImage(exp, w + 15, z + 15, 70, 70, null);
            collide();
        } else {
            g.drawImage(null, w + 15, z + 15, 70, 70, null);
        }
    }

    public void run() {
        try {
            Thread.sleep(2000);
            bandera = false;
            banE = true;
            Thread.sleep(1000);
            banE = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}