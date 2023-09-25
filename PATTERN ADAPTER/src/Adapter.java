public class Adapter extends AnsienMethode implements IStandard {


    @Override
    public void Operation(int i, int j) {
        double res =  super.calcule(i, j);
        afficher(res);
    }
}
