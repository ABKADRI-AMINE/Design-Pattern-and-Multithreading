import java.awt.*;
import java.awt.event.KeyEvent;
//Le code ci-dessus définit une classe appelée "Paddle" qui représente une raquette de ping-pong. La classe étend la classe "Rectangle", ce qui signifie qu'elle a les propriétés et les méthodes de cette classe, ainsi que ses propres propriétés et méthodes.
//
//La classe "Paddle" a les propriétés suivantes :
//
//"id" : un entier qui représente l'identifiant de la raquette (1 ou 2)
//"yVelocity" : un entier qui représente la vitesse de déplacement de la raquette lorsqu'elle est déplacée vers le haut ou le bas.
//Le constructeur de la classe "Paddle" prend les paramètres suivants :
//
//"x" : un entier qui représente la position horizontale de la raquette.
//"y" : un entier qui représente la position verticale de la raquette.
//"PADDLE_WIDTH" : un entier qui représente la largeur de la raquette.
//"PADDLE_HEIGHT" : un entier qui représente la hauteur de la raquette.
//"id" : un entier qui représente l'identifiant de la raquette.
//Le constructeur utilise le mot-clé "super" pour appeler le constructeur de la classe "Rectangle" avec les paramètres "x", "y", "PADDLE_WIDTH" et "PADDLE_HEIGHT", ce qui crée un objet "Rectangle" qui représente la forme de la raquette. La propriété "id" de l'objet "Paddle" est ensuite initialisée avec la valeur "id".
//
//En résumé, la classe "Paddle" est utilisée pour créer des objets qui représentent des raquettes de ping-pong, avec des propriétés pour identifier la raquette et contrôler sa vitesse de déplacement. Le constructeur est utilisé pour initialiser ces propriétés lorsqu'un objet "Paddle" est créé
public class Paddle extends Rectangle{

    int id;
    //la vittese de la raquette quand on appuie sur les flesh hauut-bas
    int yVelocity;
    int speed=10;
    //Constructor
    Paddle(int x,int y,int PADDLE_WIDTH, int PADDLE_HEIGHT,int id){
    super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
    this.id=id;
    }
    public void keyPressed(KeyEvent e){
    switch (id){
        case 1:
            //si on click sur w la raquette 1 va vers le haut
            if (e.getKeyCode()==KeyEvent.VK_W){
                setYDirection(-speed);
                move();
            }
            //si on click sur s la raquette 1 va vers le bas
            if (e.getKeyCode()==KeyEvent.VK_S){
                setYDirection(speed);
                move();
            }
            break;
        case 2:
            //si on click sur flesh haut la raquette 1 va vers le haut
            if (e.getKeyCode()==KeyEvent.VK_UP){
                setYDirection(-speed);
                move();
            }
            //si on click sur flesh bas la raquette 1 va vers le bas
            if (e.getKeyCode()==KeyEvent.VK_DOWN){
                setYDirection(speed);
                move();
            }
            break;
    }
    }
    public void keyReleased(KeyEvent e){
        switch (id){
        case 1:
        //si on click sur w la raquette 1 va vers le haut
        if (e.getKeyCode()==KeyEvent.VK_W){
            //on a met 0 bash fash n7ydo ydna 3la button tw9f
            setYDirection(0);
            move();
        }
        //si on click sur s la raquette 1 va vers le bas
        if (e.getKeyCode()==KeyEvent.VK_S){
            setYDirection(0);
            move();
        }
        break;
        case 2:
        //si on click sur flesh haut la raquette 1 va vers le haut
        if (e.getKeyCode()==KeyEvent.VK_UP){
            setYDirection(0);
            move();
        }
        //si on click sur flesh bas la raquette 1 va vers le bas
        if (e.getKeyCode()==KeyEvent.VK_DOWN){
            setYDirection(0);
            move();
        }
        break;
    }}
    public void setYDirection(int yDirection){
    yVelocity=yDirection;
    }
    public void move(){
y=y+yVelocity;
    }
    public void draw(Graphics g){
        // Si l'identifiant de la raquette est 1, utiliser la couleur bleue
        if(id==1)
            g.setColor(Color.blue);
            // Sinon, utiliser la couleur rouge
        else
            g.setColor(Color.red);
        // Dessiner un rectangle rempli avec la couleur choisie, aux coordonnées et dimensions données par les propriétés "x", "y", "width" et "height" de l'objet "Rectangle" associé à la raquette
        g.fillRect(x,y,width,height);
    }

}
