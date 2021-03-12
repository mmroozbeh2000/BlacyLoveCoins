package javaRoid;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends JPanel implements  Runnable, KeyListener {

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    private Boolean gameOver=true;
    private BufferedImage backImage;
    private  BufferedImage gameOverImage;
    Blacy blacyObject = new Blacy(this);
    Coin coinObject=new Coin();
    Player playerObject=new Player(this);
    Thread BlacyThread;


    public void addNotify() {
        super.addNotify();
        BlacyThread = new Thread(this);
        BlacyThread.start();

    }


    public Game() {
        try {

            backImage = ImageIO.read(new File("backImage.png"));
            gameOverImage=ImageIO.read(new File("gameOver.png"));


        } catch(IOException e ) {
            System.out.println(" file not found!");
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        setBackground(Color.BLACK);
        g2.drawImage(backImage,null,0,0);
        blacyObject.paint(g2);
        coinObject.paint(g2);

        g2.setColor(Color.white);
        Font font =new Font("arial",Font.BOLD,40);
        g2.setFont(font);
        g2.drawString("Score : ",30,650);
        g2.drawString("" + playerObject.getScore(), 180,650);
        if (!gameOver){
            g2.drawImage(gameOverImage,null,0,0);

        }

    }


    public  void move(){
        playerObject.getCoinPos();
playerObject.getCoin();



    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        blacyObject.setAli(false);
        blacyObject.keyPressed(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (gameOver) {
            repaint();
            move();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        }
    }

