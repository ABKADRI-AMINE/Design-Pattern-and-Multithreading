public class displayResume implements Observer{
    private int position;
    private String precision;
    @Override
    public void update(Observable observable) {
        position = ((GPS)observable).getPosition();
        precision=((GPS)observable).getPrecision();
    }
}
