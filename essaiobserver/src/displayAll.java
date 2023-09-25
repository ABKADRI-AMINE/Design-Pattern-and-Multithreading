public class displayAll implements Observer{
    private int position;
    private String precision;
    @Override
    public void update(Observable observable) {
        position = ((GPS)observable).getPosition();
        precision=((GPS)observable).getPrecision();
        System.out.println("****VotreResumee****");
    }
}
