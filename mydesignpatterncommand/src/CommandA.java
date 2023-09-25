public class CommandA implements Command {
private RecepteurImpl1 recepteur;

    public CommandA(RecepteurImpl1 recepteur) {
        this.recepteur = recepteur;
    }

    @Override
    public void executer() {
      recepteur.action1();
    }
}
