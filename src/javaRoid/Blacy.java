package javaRoid;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Blacy implements KeyListener {

    private Game game;
    BufferedImage blacyImage;
    BufferedImage blacyImage2;
    private boolean ali = true;

    public void setAli(boolean ali) {
        this.ali = ali;
    }


    private int[] blacyXLength = new int[750];
    private int[] blacyYLength = new int[750];

    public void setLengthOfBlacy() {
       lengthOfBlacy++;
    }

    private int lengthOfBlacy = 2;
    private int location = 0;

    private boolean up = false;
    private boolean down = false;
    private boolean right = true;
    private boolean left = false;

    public boolean collision(){

        return game.coinObject.getBounds().intersects(getBounds());

    }


    public Rectangle getBounds(){


        return new Rectangle(blacyXLength[0],blacyYLength[0],blacyImage.getWidth(),blacyImage.getHeight());
    }



    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        if (location == 0) {
            blacyXLength[0] = 200;
            blacyYLength[0] = 100;
            location++;
        }
        if (right == true && ali) {

            for (int r = lengthOfBlacy - 1; r >= 0; r--) {
                blacyYLength[r + 1] = blacyYLength[r];


            }
            for (int r = lengthOfBlacy; r >= 0; r--) {
                blacyYLength[r + 1] = blacyYLength[r];
                if (r == 0) {

                    blacyXLength[r] = blacyXLength[r] + 45;
                } else {


                    blacyXLength[r] = blacyXLength[r - 1];
                }
                if (blacyXLength[r] > 850) {
                    blacyXLength[r] = 25;
                }
            }


        }
        for (int i = 0; i < lengthOfBlacy; i++) {
            if (right && ali) {
                if (i == 0) {
                    g2.drawImage(blacyImage, null, blacyXLength[i], blacyYLength[i]);
                } else {
                    g2.drawImage(blacyImage2, null, blacyXLength[i], blacyYLength[i]);
                }
            }


        }
        if (right && !ali) {

            for (int r = lengthOfBlacy - 1; r >= 0; r--) {
                blacyYLength[r + 1] = blacyYLength[r];


            }
            for (int r = lengthOfBlacy; r >= 0; r--) {
                blacyYLength[r + 1] = blacyYLength[r];
                if (r == 0) {

                    blacyXLength[r] = blacyXLength[r] + 45;
                } else {


                    blacyXLength[r] = blacyXLength[r - 1];
                }
                if (blacyXLength[r] > 850) {
                    blacyXLength[r] = 25;
                }
            }


        }

        if (left  && !ali) {

            for (int r = lengthOfBlacy - 1; r >= 0; r--) {
                blacyYLength[r + 1] = blacyYLength[r];


            }
            for (int r = lengthOfBlacy; r >= 0; r--) {
                blacyYLength[r + 1] = blacyYLength[r];
                if (r == 0) {

                    blacyXLength[r] = blacyXLength[r] - 45;
                } else {


                    blacyXLength[r] = blacyXLength[r - 1];
                }
                if (blacyXLength[r] < -30) {
                    blacyXLength[r] = 850;
                }
            }


        }

        if (up && !ali) {

            for (int r = lengthOfBlacy - 1; r >= 0; r--) {
                blacyXLength[r + 1] = blacyXLength[r];


            }
            for (int r = lengthOfBlacy; r >= 0; r--) {
                if (r == 0) {

                    blacyYLength[r] = blacyYLength[r] - 45;
                } else {


                    blacyYLength[r] = blacyYLength[r - 1];
                }
                if (blacyYLength[r] < -20) {
                    blacyYLength[r] = 800;
                }
            }


        }

        if (down && !ali) {

            for (int r = lengthOfBlacy - 1; r >= 0; r--) {
                blacyXLength[r + 1] = blacyXLength[r];


            }
            for (int r = lengthOfBlacy; r >= 0; r--) {
                if (r == 0) {

                    blacyYLength[r] = blacyYLength[r] + 45;
                } else {


                    blacyYLength[r] = blacyYLength[r - 1];
                }
                if (blacyYLength[r] > 550) {
                    blacyYLength[r] = 75;
                }
            }


        }
        for (int i = 0; i < lengthOfBlacy; i++) {
            if (i == 0 && right && !ali) {
                g2.drawImage(blacyImage, null, blacyXLength[i], blacyYLength[i]);

            }
           if (i == 0 && left && !ali) {
                g2.drawImage(blacyImage, null, blacyXLength[i], blacyYLength[i]);

            }

            if (i == 0 && up && !ali) {
                g2.drawImage(blacyImage, null, blacyXLength[i], blacyYLength[i]);

            }

            if (i == 0 && down && !ali) {
                g2.drawImage(blacyImage, null, blacyXLength[i], blacyYLength[i]);

            }

            if (i != 0 && !ali) {
                g2.drawImage(blacyImage2, null, blacyXLength[i], blacyYLength[i]);

            }


        }

        for (int j=1; j<lengthOfBlacy;j++){

            if (blacyXLength[j]==blacyXLength[0]&&blacyYLength[j]==blacyYLength[0]){

            game.setGameOver(false);

            }





        }






    }

    public Blacy(Game game) {
        this.game = game;
        try {
            blacyImage = ImageIO.read(new File("blacyImage.png"));
            blacyImage2 = ImageIO.read(new File("blacyImage2.png"));
        } catch (Exception e) {
            System.err.println("File not found!");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !left) {
            down = false;
            up = false;
            right = true;

        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT && !right) {
            down = false;
            up = false;
            left = true;

        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN && !up) {
            down = true;
            left = false;
            right = false;

        }

        if (e.getKeyCode() == KeyEvent.VK_UP && !down) {
            up = true;
            left = false;
            right = false;

        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
