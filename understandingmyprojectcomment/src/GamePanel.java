import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable{
    static  final int GAME_WIDTH = 1000;
    static  final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    //player 1
    Paddle paddle1;
    //player 2
    Paddle paddle2;
    Ball ball;
    Score score;
    //constructor
    GamePanel(){
        //quand on demarre notre gamePanel logiquemnt faut creer de nouveau balle et paddle
        newPaddles();
        newBall();
        //quand on cree une nouvelle instanciation du score faut passer les parametre du score dedans cad :Score(int GAME_WIDTH, int GAME_HEIGHT)
        // Création d'une nouvelle instance de la classe Score et affectation à la variable score
        // Les paramètres passés sont GAME_WIDTH et GAME_HEIGHT
        score = new Score(GAME_WIDTH, GAME_HEIGHT);

        // Définit l'objet GamePanel en tant qu'objet pouvant recevoir le focus (focusable),
        // ce qui signifie qu'il peut capturer les entrées clavier
        //Cela signifie que lorsque l'utilisateur utilise le clavier, l'objet GamePanel sera capable de recevoir et de traiter les entrées clavier.
        this.setFocusable(true);

        // Ajoute un KeyListener à l'objet GamePanel qui réagira aux entrées clavier
        // Le KeyListener est un nouvel objet de la classe AL (qui doit être définie ailleurs dans le code)
        this.addKeyListener(new AL());

        // Définit la taille préférée (preferred size) de l'objet GamePanel
        // SCREEN_SIZE est une constante qui représente les dimensions de l'écran
        this.setPreferredSize(SCREEN_SIZE);

        // Création d'un nouveau thread pour le GamePanel, qui sera exécuté en parallèle du thread principal
        // Le thread est démarré en appelant la méthode start()
        // La classe GamePanel implémente l'interface Runnable, donc elle peut être utilisée comme argument pour le constructeur de Thread
        gameThread = new Thread(this);
        gameThread.start();
    }
    //a chaque fois que nous appelons cette methode on creera une nouvelle ball sur l'ecran
    public void newBall(){
        random=new Random();

//pour qu au debut du jeu la ball commence au centre de notre cadre du jeu
        ball=new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
    }
    //a chaque fois que nous appelons cette methode on creera une nouvelle Paddle sur l'ecran
    public void newPaddles(){
        //on creer les 2 paddles en passant en argument la position de chaque paddle
        paddle1= new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddle2= new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);


    }
    //pour que nous puission peindre des choses sur l'ecran
    public void paint(Graphics g){
// Définition d'une méthode publique "paint" prenant un objet "Graphics" en argument

        image=createImage(getWidth(),getHeight());
        // Création d'une nouvelle image à partir de la taille de l'élément graphique

        graphics=image.getGraphics();
        // Récupération d'un objet "Graphics" associé à l'image nouvellement créée

        draw(graphics);
        // Appel de la méthode "draw" pour dessiner sur l'image en utilisant l'objet "Graphics"

        g.drawImage(image,0,0,this);
       //Finalement, l'image est dessinée sur l'élément graphique en utilisant la méthode "drawImage" de l'objet Graphics "g". Les coordonnées de l'image sont spécifiées (0,0) et "this" est utilisé pour indiquer que l'élément graphique actuel doit être utilisé comme observateur de l'événement de dessin. Cela permet de mettre à jour l'élément graphique à chaque fois que l'image est redessinée.
    }

    public void draw(Graphics g){
    //pour dessiner les 2 raquette et la ball
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }
    //pour rendre le deplacement de la raquette/ball un peu souple et rapide
    public void move(){
paddle1.move();
paddle2.move();
ball.move();
    }
    public void checkCollision(){
        //empecher la ball de depasser le cadre du jeu (haut + bas)
        if(ball.y<=0){
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.y>=GAME_HEIGHT-BALL_DIAMETER){
            ball.setYDirection(-ball.yVelocity);
        }

        //empecher la balle de depasser le cadre du jeu (gauche+droit) quand il conffronte la raquette
        if(ball.intersects(paddle1)) {
            //renverser la vitesse de la ball pour quand il intersecte avec la raquette il prend une direction opposee
       ball.xVelocity = Math.abs(ball.xVelocity);
       //quand la ball heurte la raquette il change sa direction et sa vitesse augmente
            ball.xVelocity++;

            if(ball.yVelocity>0)
                ball.yVelocity++;//de meme augemntez la vitesse pour rendre le jeu plus difficile
                else
                    ball.yVelocity--;
                ball.setXDirection(ball.xVelocity);
                ball.setYDirection(ball.yVelocity);

        }

        if(ball.intersects(paddle2)) {
            //renverser la vitesse de la ball pour quand il intersecte avec la raquette il prend une direction opposee
            ball.xVelocity = Math.abs(ball.xVelocity);
            //quand la ball heurte la raquette il change sa direction et sa vitesse augmente
            ball.xVelocity++;

            if(ball.yVelocity>0)
                ball.yVelocity++;//de meme augemntez la vitesse pour rendre le jeu plus difficile
            else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);

        }

//empecher les raquettes de depasser le cadre du jeu
        //pour le cote haut de la raquette1
        if(paddle1.y<=0)
            paddle1.y=0;
        //pour le cote bas de la raquette1
        if(paddle1.y>=(GAME_HEIGHT-PADDLE_HEIGHT))
            paddle1.y=GAME_HEIGHT-PADDLE_HEIGHT;
        //pour le cote haut de la raquette2
        if(paddle2.y<=0)
            paddle2.y=0;
        //pour le cote bas de la raquette2
        if(paddle2.y>=(GAME_HEIGHT-PADDLE_HEIGHT))
            paddle2.y=GAME_HEIGHT-PADDLE_HEIGHT;

        //give a player 1 point and creates new paddles and ball
//        si le player 2 marque
        if(ball.x<=0){
        score.player2++;
        newPaddles();
        newBall();
        System.out.println("Player 2:"+score.player2);
        }
//si le player 1 marque
        if(ball.x>=GAME_WIDTH-BALL_DIAMETER){
            score.player1++;
            newPaddles();
            newBall();
            System.out.println("Player 1:"+score.player1);

        }
    }
    //La fonction "run" est une méthode clé pour le jeu de ping-pong car elle gère la boucle de jeu. Cette boucle est utilisée pour mettre à jour le jeu à intervalles réguliers et pour dessiner les éléments du jeu à l'écran.
    //
    //La boucle de jeu est conçue pour exécuter à une vitesse de 60 mises à jour par seconde, ce qui signifie que chaque image doit être mise à jour toutes les 16,6 millisecondes. Cette vitesse est définie par la variable "amountOfTicks" qui est initialisée à 60 dans le code.
    //
    //La fonction "run" calcule la durée entre chaque mise à jour en utilisant la fonction "System.nanoTime()" qui fournit un temps précis en nanosecondes. Cette durée est ensuite utilisée pour mettre à jour les positions des éléments du jeu, vérifier les collisions et dessiner les éléments à l'écran.
    //
    //Le temps entre chaque mise à jour est stocké dans la variable "delta". Si le temps écoulé depuis la dernière mise à jour est supérieur ou égal à la durée d'une mise à jour, la fonction "move" est appelée pour déplacer les éléments du jeu, la fonction "checkCollision" est appelée pour vérifier les collisions entre les éléments du jeu, la fonction "repaint" est appelée pour dessiner les éléments du jeu à l'écran, et la variable "delta" est mise à jour en soustrayant la durée d'une mise à jour.
    //
    //Le fait d'utiliser une boucle de jeu est important pour maintenir une cadence constante et fluide pour le jeu de ping-pong. Cela garantit que le jeu est exécuté de manière cohérente sur toutes les machines, quel que soit leur taux de rafraîchissement ou leur puissance de traitement.
    public void run(){
// Définition d'une méthode publique "run" pour exécuter la boucle de jeu

        long lastTime=System.nanoTime();
        // Initialisation du temps de la dernière mise à jour de la boucle de jeu

        double amountOfTicks=60.0;
        // Définition du nombre de mises à jour par seconde que la boucle de jeu doit effectuer

        double ns = 1000000000/amountOfTicks;
        // Calcul de la durée en nanosecondes que chaque mise à jour doit durer

        double delta=0;
        // Initialisation du temps écoulé depuis la dernière mise à jour

        while (true){
            // Boucle de jeu infinie

            long now= System.nanoTime();
            // Obtenir le temps actuel pour calculer la durée de chaque mise à jour

            delta+=(now-lastTime)/ns;
            // Ajouter le temps écoulé depuis la dernière mise à jour au delta

            lastTime = now;
            // Mettre à jour le temps de la dernière mise à jour

            if(delta>=1){
                // Si le temps écoulé dépasse la durée de mise à jour d'une image

                move();
                // Appeler une méthode pour déplacer les objets du jeu

                checkCollision();
                // Appeler une méthode pour vérifier les collisions entre les objets

                repaint();
                // Appeler la méthode "repaint" pour mettre à jour l'affichage du jeu

                delta--;
                // Soustraire la durée d'une mise à jour de l'horloge delta
            }
        }
    }

    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
        paddle1.keyPressed(e);
        paddle2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
        paddle1.keyReleased(e);
        paddle2.keyReleased(e);
        }
    }
}
