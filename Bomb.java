/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bomb extends Applet implements Runnable{
    
    int x =0;
    int y=0;
    int dx=2;
    int dy=2;
    int radius=10;
    @Override
    public void init(){
        
    }
    
    @Override
    public void start(){
        Thread thread = new Thread(this);
        thread.start();
        
    }
    
    @Override
    public void run(){
        while(true){
            repaint();
            try {
                Thread.sleep(17);
                System.out.println("Frame");
            } catch (InterruptedException ex) {
                Logger.getLogger(Bomb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillOval(x, y, radius, radius);
    }
}
