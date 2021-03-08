package javaRoid;

import javax.swing.*;

public class Main extends JFrame {

    public Main(){
        Game game = new Game();
        addKeyListener(game);
        add(game);
        setTitle("SNAKE");
        setSize(900,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }



    public static void main(String[] args) {

       new Main();

   }


}
