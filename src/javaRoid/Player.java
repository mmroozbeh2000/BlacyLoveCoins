package javaRoid;

public class Player {
private Game game;
private int coinPos =0;




public void getCoin(){

if (game.blacyObject.collision()==true){

    game.coinObject.XYRandom();
    System.out.println("get coin");
}

}

public void getCoinPos() {
    if (coinPos == 0) {
game.coinObject.XYRandom();
coinPos++;



    }


}

public Player(Game game){

    this.game=game;
}



}





