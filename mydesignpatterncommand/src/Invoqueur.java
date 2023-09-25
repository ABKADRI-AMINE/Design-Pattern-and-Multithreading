import java.util.HashMap;
import java.util.Map;

public class Invoqueur {
    // Déclaration de la variable "commandes" qui est une carte qui associe des chaînes de caractères à des objets "Command"
    private Map<String, Command> commandes = new HashMap<String, Command>();

    // Méthode pour ajouter une nouvelle commande à la carte "commandes"
    public void addNewcommand(String ref, Command cmd) {
        commandes.put(ref, cmd); // Ajoute la commande "cmd" à la carte avec la référence "ref"
    }

    // Méthode pour invoquer une commande à partir de sa référence
    public void invoquer(String ref) {
        Command cmd = commandes.get(ref); // Récupère la commande associée à la référence "ref" dans la carte "commandes"

        // Si la commande existe (c'est-à-dire que "cmd" n'est pas null), on appelle sa méthode "executer()"
        if (cmd != null) {
            cmd.executer();
        }
    }
}
