package javaRoid;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class Coin {
    private  Game game;
    Random rand =new Random();
    private BufferedImage coinImage;
    private int  xPos;
    private int  yPos;

    public  void  XYRandom(){

        xPos= rand.nextInt(800);
        yPos=rand.nextInt(500);

    }

    public  void paint(Graphics g){

Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
g2.drawImage(coinImage,null,xPos,yPos);

    }

public Rectangle getBounds(){


    return new Rectangle(xPos,yPos,coinImage.getWidth(),coinImage.getHeight()) ;
}





    public Coin(){
        try {
            coinImage = ImageIO.read(new File("coin.png"));

        } catch (Exception e) {
            System.err.println("File not found!");
        }




    }










}
