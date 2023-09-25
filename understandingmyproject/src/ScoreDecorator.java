//Ce code définit une interface appelée "ScoreDecorator". Cette interface contient une seule méthode appelée "drawScore" qui prend en paramètre un objet de type "Graphics" et deux entiers représentant les scores des joueurs 1 et 2. Cette méthode sera implémentée par d'autres classes qui souhaitent ajouter une fonctionnalité de décoration au dessin du score dans le jeu.
import java.awt.*;

public interface ScoreDecorator {
    void drawScore(Graphics g, int player1Score, int player2Score);
}
