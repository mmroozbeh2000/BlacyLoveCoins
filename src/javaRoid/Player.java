package javaRoid;

public class Player {
private Game game;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private  int score;

private int coinPos =0;




public void getCoin(){

if (game.blacyObject.collision()==true){

    game.coinObject.XYRandom();
    System.out.println("get coin");
    score+=10;
    game.blacyObject.setLengthOfBlacy();

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





