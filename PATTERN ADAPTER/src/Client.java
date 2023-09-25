public class Client {

    private IStandard iStandard;

    public void proccess(int i, int j){
        iStandard.Operation(i, j);
    }

    public void setiStandard(IStandard iStandard) {
        this.iStandard = iStandard;
    }
}
