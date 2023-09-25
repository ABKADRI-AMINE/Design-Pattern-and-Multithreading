import java.util.Random;

public class Game {
    static Random random= new Random();
    public static void main(String[] args){
    int loop=5;
    while (loop>0){
        Enemy enemy=Enemyfactory.createEnemy(getRandom(1,2));
        enemy.showUp();
        loop--;
    }
    }
    public static int getRandom(int min, int max){
        return random.nextInt((max-min)+1)+min;
    }
}
