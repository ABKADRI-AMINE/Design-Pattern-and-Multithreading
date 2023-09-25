public class Journalisation {
    private final static Journalisation journalisation;
    private String log="";

    static {
        journalisation = new Journalisation();
    }
    private Journalisation(){}

    public static Journalisation getjournalisation() {
        return  journalisation;
    }
    public  void ajouterLog(String logf){
        this.log+='\n'+logf;
    }

    public String getLog() {
        return log;
    }
}

