import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle{
    int id;

    //la vittese de la raquette quand on appuie sur les flesh hauut-bas
    int yVelocity;

    int speed=10;
    ICommand moveUpCommand;
    ICommand moveDownCommand;
    //Constructor


    Paddle(int x,int y,int PADDLE_WIDTH, int PADDLE_HEIGHT,int id){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id=id;
        moveUpCommand = new MoveCommand(this, -speed);
        moveDownCommand = new MoveCommand(this, speed);
    }

    public void keyPressed(KeyEvent e){
        switch (id){
            //si on click sur w la raquette 1 va vers le haut
            case 1:
                if (e.getKeyCode()==KeyEvent.VK_W){
                    moveUpCommand.execute();
                }
                //si on click sur s la raquette 1 va vers le bas
                if (e.getKeyCode()== KeyEvent.VK_S){
                    moveDownCommand.execute();
                }
                break;
            case 2:
                //si on click sur flesh haut la raquette 1 va vers le haut
                if (e.getKeyCode()==KeyEvent.VK_UP){
                    moveUpCommand.execute();
                }
                //si on click sur flesh bas la raquette 1 va vers le bas
                if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    moveDownCommand.execute();
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        switch (id){
            case 1:
                //on a met 0 bash fash n7ydo ydna 3la button tw9f
                if (e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_S){
                    ICommand stopCommand = new MoveCommand(this, 0);
                    stopCommand.execute();
                }
                break;
            case 2:
                if (e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_DOWN){
                    ICommand stopCommand = new MoveCommand(this, 0);
                    stopCommand.execute();
                }
                break;
        }
    }

    public void setYDirection(int yDirection){
        yVelocity=yDirection;
    }

    public void move(){
        y=y+yVelocity;
    }

    public void draw(Graphics g){
        if(id==1)
            // Si l'identifiant de la raquette est 1, utiliser la couleur bleue
            g.setColor(Color.green);
        else
            // Sinon, utiliser la couleur rouge
            g.setColor(Color.red);
        // Dessiner un rectangle rempli avec la couleur choisie, aux coordonnées et dimensions données par les propriétés "x", "y", "width" et "height" de l'objet "Rectangle" associé à la raquette

        g.fillRect(x,y,width,height);
    }
}
