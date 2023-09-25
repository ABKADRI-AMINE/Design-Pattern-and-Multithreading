public class Client {
    public static void main(String[] args){
        RecepteurImpl1 rec1=new RecepteurImpl1();
        RecepteurImpl2 rec2=new RecepteurImpl2();
        Command cmd1=new CommandA(rec1);
        Command cmd2=new CommandB(rec1);
        Command cmd3=new CommandC(rec2);
        Invoqueur telecommande=new Invoqueur();
        telecommande.addNewcommand("A",cmd1);
        telecommande.addNewcommand("B",cmd2);
        telecommande.addNewcommand("C",cmd3);
        telecommande.invoquer("A");
        telecommande.invoquer("B");
        telecommande.invoquer("C");
        telecommande.invoquer("D");
    }
}
