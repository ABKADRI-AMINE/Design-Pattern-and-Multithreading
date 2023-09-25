public class CommandC implements Command {
private RecepteurImpl2 recepteur;

    public CommandC(RecepteurImpl2 recepteur) {
        this.recepteur = recepteur;
    }

    @Override
    public void executer() {
      recepteur.action3();
    }
}
