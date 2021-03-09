package javaRoid;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Blacy implements KeyListener {

   private Game game;

   private int[] blacyXLength= new int[750];
    private int[] blacyYLength= new int[750];
    private int lengthOfBlacy= 3;


   private boolean up = false;
    private boolean down = false;
    private boolean right = true;
    private boolean left = false;
public void paint(Graphics g) {
  Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);


}



    public Blacy(Game game){
        this.game= game;


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
