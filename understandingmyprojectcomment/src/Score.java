import java.awt.*;

public class Score extends Rectangle{
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    //LE SCORE DU PLAYER 1 ET 2
    int player1;
    int player2;
    //constructor
    Score(int GAME_WIDTH, int GAME_HEIGHT){
     Score.GAME_WIDTH=GAME_WIDTH;
     Score.GAME_HEIGHT=GAME_HEIGHT;
    }
    //dessiner le score
    public void draw(Graphics g){
     g.setColor(Color.white);
     g.setFont(new Font("Consolas",Font.PLAIN,60));
     //dessiner la ligne du milieu
        g.drawLine(GAME_WIDTH/2,0,GAME_WIDTH/2,GAME_HEIGHT);
        //dessiner le resultat du score
        g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10),(GAME_WIDTH/2)-85,50);
        g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10),(GAME_WIDTH/2)+20,50);
    }
}
