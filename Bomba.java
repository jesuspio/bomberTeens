/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus Pio
 */
public class Bomba extends Thread {

    Boolean bandera = true;
    int w;
    int z;
    BufferedImage aux2;

    public void ponerBomba(BufferedImage aux2, int w, int z) {
        Bomba thread = new Bomba();
        this.aux2 = aux2;
        this.w = w;
        this.z = z;
        System.out.println(bandera);
        if (bandera) {
            bandera = false;
            System.out.println(bandera);
            thread.start();
        }

    }

    

    public void paint(Graphics g) {

        g.drawImage(aux2, w + 15, z + 15, 70, 70, null);

    }

    public void run() {
        // while(true){

        for (int x = 0; x < 4; x++) {
            try {
                Thread.sleep(1000);
                System.out.println(x);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bomba.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        bandera = true;
        System.out.println(bandera);
        // }
    }
}
